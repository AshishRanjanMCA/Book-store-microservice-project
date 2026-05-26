package com.example.orderservice.controller;

import com.example.orderservice.entity.Orders;
import com.example.orderservice.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public List<Orders> getOrders() {
        return orderRepository.findAll();
    }

    @PostMapping
    public Orders createOrder(@RequestBody Orders orders) {
        return orderRepository.save(orders);
    }
}
