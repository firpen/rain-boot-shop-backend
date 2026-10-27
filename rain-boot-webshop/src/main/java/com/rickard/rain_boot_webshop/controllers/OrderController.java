package com.rickard.rain_boot_webshop.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rickard.rain_boot_webshop.dtos.OrderDto;
import com.rickard.rain_boot_webshop.services.OrderService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping("/order")
@RestController 
public class OrderController {
    
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping()
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto order) {
        orderService.createOrder(order);
        return ResponseEntity.ok(order);
    }
  
}
