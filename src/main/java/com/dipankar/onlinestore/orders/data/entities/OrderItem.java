package com.dipankar.onlinestore.orders.data.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {

    private Long productId;
    private Double pricePerUnit;
    private Integer quantity;
}
