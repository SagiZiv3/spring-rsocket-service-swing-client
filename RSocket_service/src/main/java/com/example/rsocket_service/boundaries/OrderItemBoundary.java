package com.example.rsocket_service.boundaries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemBoundary {
    private String orderId;
    private String productId;
    private int quantity;
}