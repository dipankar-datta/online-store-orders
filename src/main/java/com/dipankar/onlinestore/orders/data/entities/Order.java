package com.dipankar.onlinestore.orders.data.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Long id;
    private Long customerId;
    private List<OrderItem> orderItems;
    private Double totalAmount;
    private LocalDateTime orderDate;
    private String status;
}
