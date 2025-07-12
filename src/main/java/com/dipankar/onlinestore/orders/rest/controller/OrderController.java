package com.dipankar.onlinestore.orders.rest.controller;

import com.dipankar.onlinestore.orders.data.entities.Order;
import com.dipankar.onlinestore.orders.rest.dto.request.OrderRequest;
import com.dipankar.onlinestore.orders.rest.dto.response.OrderResponse;
import com.dipankar.onlinestore.orders.service.OrderService;
import com.dipankar.onlinestore.orders.util.EntityToResponseConverter;
import com.dipankar.onlinestore.orders.util.exception.ApplicationException;
import com.dipankar.onlinestore.orders.util.exception.ExceptionType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.dipankar.onlinestore.orders.util.CommonUtil.convertList;
import static com.dipankar.onlinestore.orders.util.CommonUtil.handleOptional;
import static com.dipankar.onlinestore.orders.util.EntityToResponseConverter.toOrderResponse;
import static com.dipankar.onlinestore.orders.util.RequestToEntityConverter.toOrder;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public OrderResponse createOrder(@RequestBody OrderRequest orderRequest) {
        Order savedOrder = orderService.saveOrder(toOrder(orderRequest));
        return toOrderResponse(savedOrder);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderResponse updateOrder(
            @PathVariable Long id, @RequestBody OrderRequest orderRequest) throws ApplicationException {
        if (!id.equals(orderRequest.getId())) {
            throw new ApplicationException(ExceptionType.INVALID_REQUEST);
        }

        Optional<Order> existingOrder = orderService.getOrderById(id);
        if (existingOrder.isEmpty()) {
            throw new ApplicationException(ExceptionType.CREDENTIAL_NOT_FOUND);
        }
        Order updatedOrder = orderService.saveOrder(toOrder(orderRequest));
        return toOrderResponse(updatedOrder);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderResponse getOrderById(@PathVariable Long id) throws ApplicationException {
        Optional<Order> order = orderService.getOrderById(id);
        return toOrderResponse(handleOptional(order));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderResponse> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return convertList(orders, EntityToResponseConverter::toOrderResponse);
    }

    @GetMapping("/customer/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderResponse> getOrdersByCustomerId(@PathVariable Long customerId) {
        List<Order> orders = orderService.getOrderByCustomerId(customerId);
        return convertList(orders, EntityToResponseConverter::toOrderResponse);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOrder(@PathVariable Long id) throws ApplicationException {
        Optional<Order> existingOrder = orderService.getOrderById(id);
        if (existingOrder.isEmpty()) {
            throw new ApplicationException(ExceptionType.INVALID_REQUEST);
        }
        orderService.deleteOrder(id);
    }
}
