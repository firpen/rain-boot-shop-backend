package com.rickard.rain_boot_webshop.dtos;

public record CartItemDto(int quantity, ProductDto product, Integer size, Long cartId) {
    
}
