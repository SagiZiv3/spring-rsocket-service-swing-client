package com.example.rsocket_service;

import com.example.rsocket_service.boundaries.OrderBoundary;
import com.example.rsocket_service.boundaries.OrderItemBoundary;
import com.example.rsocket_service.boundaries.UserBoundary;
import com.example.rsocket_service.db.OrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Hooks;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;

@Slf4j
@Controller
public class OrdersController {
    private final OrdersService ordersService;

    @Autowired
    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @PostConstruct
    public void init() {
        Hooks.onErrorDropped(e -> {
//			if (e instanceof CancellationException
//				|| e.getCause() instanceof CancellationException) {
//				this.logger.trace("Operator called default onErrorDropped", e);
//			}else {
//				this.logger.error("Error while interacting with consumer", e);
//			}
        });
    }

    @MessageMapping("order-req-resp")
    public Mono<OrderBoundary> create_order(OrderBoundary orderBoundary) {
        log.info("Creating/Updating an order");
        return ordersService.create(orderBoundary);
    }

    @MessageMapping("fulfill-fire-and-forget")
    public Mono<Void> markAsFulfilled(OrderBoundary orderBoundary) {
        log.info("Marking '{}' as fulfilled", orderBoundary.getOrderId());
        return ordersService.markAsFulfilled(orderBoundary);
    }

    @MessageMapping("getOpenOrderItems-stream")
    public Flux<OrderItemBoundary> getAllOrderedProducts(UserBoundary userBoundary) {
        log.info("Retrieving all products for '{}'", userBoundary.getUserEmail());
        return ordersService.getAllOrderedProducts(userBoundary);
    }

    @MessageMapping("getOrders-stream")
    public Flux<OrderBoundary> getAllOrderedItems(UserBoundary userBoundary) {
        log.info("Retrieving all orders for '{}'", userBoundary.getUserEmail());
        return ordersService.getAllOrderedItems(userBoundary);
    }

    @MessageMapping("getItemsByOrder-channel")
    public Flux<OrderItemBoundary> getProducts(Flux<OrderBoundary> orders) {
        return ordersService.getProducts(orders);
    }

    @MessageMapping("cleanup-fire-and-forget")
    public Mono<Void> deleteAll() {
        log.info("Deleting everything :-O");
        return ordersService.deleteAll();
    }
}