package com.rickard.rain_boot_webshop.dtos;

import java.util.List;

public record CartDto(Long cartId, List<CartItemDto> cartItems) {
    
}
