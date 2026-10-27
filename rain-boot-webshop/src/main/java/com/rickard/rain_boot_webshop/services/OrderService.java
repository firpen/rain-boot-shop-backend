package com.rickard.rain_boot_webshop.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rickard.rain_boot_webshop.dtos.OrderDto;
import com.rickard.rain_boot_webshop.models.Cart;
import com.rickard.rain_boot_webshop.models.Order;
import com.rickard.rain_boot_webshop.repositories.CartRepository;
import com.rickard.rain_boot_webshop.repositories.OrderRepository;

@Service 
public class OrderService {
    
    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;

    public OrderService(OrderRepository orderRepository, CartRepository cartRepository) {
        this.orderRepository = orderRepository;
        this.cartRepository = cartRepository;
    }

    public void createOrder(OrderDto orderDto) {
        Optional<Cart> optionalCart = cartRepository.findById(orderDto.cartId());
        Cart cart = optionalCart.get();
        Order order = new Order(orderDto.email(), cart);
        orderRepository.save(order);
    }

}
