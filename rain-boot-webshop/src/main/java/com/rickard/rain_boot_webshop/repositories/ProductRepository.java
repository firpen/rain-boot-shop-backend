package com.rickard.rain_boot_webshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rickard.rain_boot_webshop.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
