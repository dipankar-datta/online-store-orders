package com.dipankar.onlinestore.orders.util;

import com.dipankar.onlinestore.orders.data.entities.Order;
import com.dipankar.onlinestore.orders.data.entities.OrderItem;
import com.dipankar.onlinestore.orders.rest.dto.response.OrderItemResponse;
import com.dipankar.onlinestore.orders.rest.dto.response.OrderResponse;


import static org.springframework.beans.BeanUtils.copyProperties;
import static com.dipankar.onlinestore.orders.util.CommonUtil.convertList;

public class EntityToResponseConverter {

    static OrderItemResponse toOrderItemResponse(OrderItem orderItem) {
        OrderItemResponse response = new OrderItemResponse();
        copyProperties(orderItem, response);
        return response;
    }

    public static OrderResponse toOrderResponse(Order order) {
        OrderResponse response = new OrderResponse();
        copyProperties(order, response);
        response.setOrderItems(convertList(order.getOrderItems(), EntityToResponseConverter::toOrderItemResponse));
        return response;
    }
}
