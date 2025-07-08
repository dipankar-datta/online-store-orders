package com.dipankar.onlinestore.orders.rest.dto.response;

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
public class OrderResponse {

    private Long id;
    private Long customerId;
    private List<OrderItemResponse> orderItems;
    private Double totalAmount;
    private LocalDateTime orderDate;
    private String status;
}
