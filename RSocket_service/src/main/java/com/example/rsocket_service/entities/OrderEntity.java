package com.example.rsocket_service.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {
    @Id
    private String orderId;
    private String userEmail;
    private Date createdTimestamp;
    private Date fulfilledTimestamp;
    private Map<String, ProductEntity> products;
}