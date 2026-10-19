package com.rickard.rain_boot_webshop.dtos;

import java.util.List;

import com.rickard.rain_boot_webshop.enums.Color;

public record UmbrellaDto(Long productId, String productName, double price, Color color, List<PictureDto> pictures) {
    
}
