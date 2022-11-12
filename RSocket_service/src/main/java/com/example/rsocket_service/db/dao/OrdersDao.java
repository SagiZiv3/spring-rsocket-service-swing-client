package com.example.rsocket_service.db.dao;

import com.example.rsocket_service.entities.OrderEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrdersDao extends ReactiveMongoRepository<OrderEntity, String> {
    Mono<OrderEntity> findByUserEmailEqualsAndFulfilledTimestampIsNull(String userEmail);

    Mono<OrderEntity> findByOrderIdEqualsAndFulfilledTimestampIsNull(String orderId);

    Flux<OrderEntity> findAllByUserEmailEquals(String userEmail);
}