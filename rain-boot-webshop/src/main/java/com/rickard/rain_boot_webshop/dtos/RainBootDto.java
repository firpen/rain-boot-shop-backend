package com.rickard.rain_boot_webshop.dtos;

import java.util.List;

import com.rickard.rain_boot_webshop.enums.Color;
import com.rickard.rain_boot_webshop.enums.ShaftHeight;

public record RainBootDto(Long productId, String productName, ShaftHeight shaftHeight, int size, Color color, double price,
        List<PictureDto> pictures) {

}
