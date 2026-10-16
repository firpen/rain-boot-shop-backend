package com.rickard.rain_boot_webshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rickard.rain_boot_webshop.models.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
