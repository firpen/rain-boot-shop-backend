package com.rickard.rain_boot_webshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rickard.rain_boot_webshop.models.Cart;

public interface CartRepository extends JpaRepository <Cart, Long> {
    
}
