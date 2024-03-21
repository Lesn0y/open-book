package org.lesnoy.orderservice.controller;

import lombok.RequiredArgsConstructor;
import org.lesnoy.orderservice.dto.OrderDTO;
import org.lesnoy.orderservice.exceptions.OrderNotFoundException;
import org.lesnoy.orderservice.model.Order;
import org.lesnoy.orderservice.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders(@RequestParam(value = "number", required = false) String number) throws OrderNotFoundException {
        return ResponseEntity.ok(service.getAllOrders());
    }

    @GetMapping("/{orderNumber}")
    public ResponseEntity<Order> getByOrderNumber(@PathVariable String orderNumber) throws OrderNotFoundException {
        return ResponseEntity.ok(service.getByOrderNumber(orderNumber));
    }

    @PostMapping
    public ResponseEntity<Order> saveOrder(@RequestBody OrderDTO orderDTO) {
        return new ResponseEntity<>(service.placeOrder(orderDTO), HttpStatus.CREATED);
    }

}
