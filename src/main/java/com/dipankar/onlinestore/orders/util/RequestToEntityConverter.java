package com.dipankar.onlinestore.orders.util;

import com.dipankar.onlinestore.orders.data.entities.Order;
import com.dipankar.onlinestore.orders.data.entities.OrderItem;
import com.dipankar.onlinestore.orders.rest.dto.request.OrderItemRequest;
import com.dipankar.onlinestore.orders.rest.dto.request.OrderRequest;

import static com.dipankar.onlinestore.orders.util.CommonUtil.convertList;
import static org.springframework.beans.BeanUtils.copyProperties;

public class RequestToEntityConverter {

    static OrderItem toOrderItem(OrderItemRequest request) {
        OrderItem orderItem = new OrderItem();
        copyProperties(request, orderItem);
        return orderItem;
    }

    public static Order toOrder(OrderRequest request) {
        Order order = new Order();
        copyProperties(request, order);
        order.setOrderItems(convertList(request.getOrderItems(), RequestToEntityConverter::toOrderItem));
        order.getOrderItems().forEach(orderItem -> orderItem.setOrder(order));
        return order;
    }
}
