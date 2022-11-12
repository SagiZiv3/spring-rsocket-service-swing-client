package com.example.rsocket_service.db;

import com.example.rsocket_service.boundaries.OrderBoundary;
import com.example.rsocket_service.boundaries.OrderItemBoundary;
import com.example.rsocket_service.boundaries.UserBoundary;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrdersService {
    Mono<OrderBoundary> create(OrderBoundary orderBoundary);
    Mono<Void> markAsFulfilled(OrderBoundary orderBoundary);

    Flux<OrderItemBoundary> getAllOrderedProducts(UserBoundary userBoundary);

    Flux<OrderBoundary> getAllOrderedItems(UserBoundary userBoundary);

    Flux<OrderItemBoundary> getProducts(Flux<OrderBoundary> orders);

    Mono<Void> deleteAll();
}