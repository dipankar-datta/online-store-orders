package com.dipankar.onlinestore.orders.rest.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

    private Long id;
    private Long customerId;
    private List<OrderItemRequest> orderItems;
    private Double totalAmount;
}
