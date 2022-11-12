package com.example.rsocket_service.boundaries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderBoundary {
    private String orderId;
    private String userEmail;
    private Date createdTimestamp;
    private Date fulfilledTimestamp;
    private ProductBoundary[] products;
}