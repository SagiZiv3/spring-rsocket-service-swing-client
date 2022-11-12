package com.example.rsocket_service.db;

import com.example.rsocket_service.boundaries.OrderBoundary;
import com.example.rsocket_service.boundaries.OrderItemBoundary;
import com.example.rsocket_service.boundaries.ProductBoundary;
import com.example.rsocket_service.boundaries.UserBoundary;
import com.example.rsocket_service.db.dao.OrdersDao;
import com.example.rsocket_service.entities.OrderEntity;
import com.example.rsocket_service.entities.ProductEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OrdersServiceInMongoImpl implements OrdersService {
    private final OrdersDao ordersDao;

    @Autowired
    public OrdersServiceInMongoImpl(OrdersDao ordersDao) {
        this.ordersDao = ordersDao;
    }

    @Override
    public Mono<OrderBoundary> create(OrderBoundary orderBoundary) {
        return Mono.just(orderBoundary)
                .map(this::toEntity)
                .map(orderEntity -> {
                    orderEntity.setCreatedTimestamp(new Date());
                    return orderEntity;
                })
                .flatMap(newOrderEntity ->
                        ordersDao.findByUserEmailEqualsAndFulfilledTimestampIsNull(newOrderEntity.getUserEmail())
                                .map(storedOrderEntity -> {
                                    log.debug("Found an order for user {} - {}", orderBoundary.getUserEmail(), storedOrderEntity.getOrderId());
                                    for (ProductEntity productToAdd : newOrderEntity.getProducts().values()) {
                                        ProductEntity currentProduct = storedOrderEntity.getProducts().get(productToAdd.getProductId());
                                        if (currentProduct != null)
                                            currentProduct.setQuantity(currentProduct.getQuantity() + productToAdd.getQuantity());
                                        else {
                                            currentProduct = productToAdd;
                                            storedOrderEntity.getProducts().put(productToAdd.getProductId(), productToAdd);
                                        }

                                        if (currentProduct.getQuantity() < 0) {
                                            currentProduct.setQuantity(0);
                                        }
                                    }
                                    return storedOrderEntity;
                                })
                                .defaultIfEmpty(newOrderEntity)
                                .log()
                )
                .flatMap(ordersDao::save)
                .map(this::toBoundary)
                .log();
    }

    @Override
    public Mono<Void> markAsFulfilled(OrderBoundary orderBoundary) {
        return Mono.just(orderBoundary)
                .map(this::toEntity)
                .flatMap(orderEntity -> this.ordersDao.findByOrderIdEqualsAndFulfilledTimestampIsNull(orderEntity.getOrderId()))
                .flatMap(stored_entity -> {
                    log.info("Marking {} as fulfilled", stored_entity.getOrderId());
                    stored_entity.setFulfilledTimestamp(new Date());
                    return this.ordersDao.save(stored_entity);
                })
                .then();
    }

    @Override
    public Flux<OrderItemBoundary> getAllOrderedProducts(UserBoundary userBoundary) {
        return ordersDao.findByUserEmailEqualsAndFulfilledTimestampIsNull(userBoundary.getUserEmail())
                .flatMapMany(orderEntity ->
                        Flux.fromIterable(orderEntity.getProducts().values())
                                .map(productEntity ->
                                        new OrderItemBoundary(
                                                orderEntity.getOrderId(),
                                                productEntity.getProductId(),
                                                productEntity.getQuantity()
                                        )
                                )
                );
    }

    @Override
    public Flux<OrderBoundary> getAllOrderedItems(UserBoundary userBoundary) {
        return this.ordersDao.findAllByUserEmailEquals(userBoundary.getUserEmail())
                .map(orderEntity -> { // Remove the products list from the entity.
                    orderEntity.setProducts(Collections.emptyMap());
                    return orderEntity;
                })
                .map(this::toBoundary);
    }

    @Override
    public Flux<OrderItemBoundary> getProducts(Flux<OrderBoundary> orders) {
        return orders.
                map(this::toEntity)
                .flatMap(entity -> this.ordersDao.findById(entity.getOrderId()))
                .flatMap(storedEntity -> Flux.fromIterable(storedEntity.getProducts().values())
                        .map(productEntity ->
                                new OrderItemBoundary(storedEntity.getOrderId(), productEntity.getProductId(),
                                        productEntity.getQuantity())
                        )
                );
    }

    @Override
    public Mono<Void> deleteAll() {
        return this.ordersDao.deleteAll();
    }

    public OrderBoundary toBoundary(OrderEntity entity) {
        OrderBoundary rv = new OrderBoundary();
        rv.setOrderId(entity.getOrderId());
        rv.setProducts(entity.getProducts().values()
                .stream()
                .map(this::productEntityToBoundary)
                .toArray(ProductBoundary[]::new));
        rv.setCreatedTimestamp(entity.getCreatedTimestamp());
        rv.setFulfilledTimestamp(entity.getFulfilledTimestamp());
        rv.setUserEmail(entity.getUserEmail());

        return rv;
    }

    private ProductBoundary productEntityToBoundary(ProductEntity productEntity) {
        ProductBoundary productBoundary = new ProductBoundary();
        productBoundary.setProductId(productEntity.getProductId());
        productBoundary.setQuantity(productEntity.getQuantity());
        return productBoundary;
    }

    private ProductEntity productBoundaryToEntity(ProductBoundary productBoundary) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductId(productBoundary.getProductId());
        productEntity.setQuantity(productBoundary.getQuantity());
        return productEntity;
    }

    public OrderEntity toEntity(OrderBoundary boundary) {
        OrderEntity rv = new OrderEntity();
        rv.setOrderId(boundary.getOrderId());
        rv.setProducts(Arrays.stream(boundary.getProducts())
                .collect(Collectors.toMap(ProductBoundary::getProductId,
                        this::productBoundaryToEntity)));
        if (boundary.getCreatedTimestamp() == null)
            rv.setCreatedTimestamp(new Date());
        else
            rv.setCreatedTimestamp(boundary.getCreatedTimestamp());
        rv.setFulfilledTimestamp(boundary.getFulfilledTimestamp());
        rv.setUserEmail(boundary.getUserEmail());

        return rv;
    }
}