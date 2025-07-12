package com.dipankar.onlinestore.orders.service;

import com.dipankar.onlinestore.orders.data.entities.Order;
import com.dipankar.onlinestore.orders.data.repository.OrderRepository;
import com.dipankar.onlinestore.orders.util.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    @Transactional
    public Order saveOrder(Order order) {
        order.setOrderDate(LocalDateTime.now());
        order.setStatus(Constants.Orders.NEW);
        return orderRepository.save(order);
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public List<Order> getOrderByCustomerId(Long id) {
        return orderRepository.findByCustomerId(id);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
