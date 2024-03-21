package org.lesnoy.orderservice.service;

import lombok.RequiredArgsConstructor;
import org.lesnoy.orderservice.dao.OrderRepository;
import org.lesnoy.orderservice.dto.OrderDTO;
import org.lesnoy.orderservice.exceptions.OrderNotFoundException;
import org.lesnoy.orderservice.model.Order;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;

    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    public Order getByOrderNumber(String orderNumber) throws OrderNotFoundException {
        return repository.findByOrderNumber(orderNumber)
                .orElseThrow(() -> new OrderNotFoundException("Order #" + orderNumber + " was not found"));
    }

    public Order placeOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setItems(orderDTO.items());
        order.setOrderDate(new Date(System.currentTimeMillis()));
        return repository.save(order);
    }

}
