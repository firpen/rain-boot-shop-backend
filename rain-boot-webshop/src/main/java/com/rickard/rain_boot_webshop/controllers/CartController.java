package com.rickard.rain_boot_webshop.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rickard.rain_boot_webshop.dtos.CartDto;
import com.rickard.rain_boot_webshop.dtos.CartItemDto;

import com.rickard.rain_boot_webshop.services.CartItemService;
import com.rickard.rain_boot_webshop.services.CartService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/cart")
@RestController 
public class CartController {
    
    private final CartService cartService;
    private final CartItemService cartItemService;

    public CartController(CartService cartService, CartItemService cartItemService) {
        this.cartService = cartService;
        this.cartItemService = cartItemService;
    }

    @PostMapping("/cart")
    public ResponseEntity<CartDto> postCreateCart() {
        CartDto cartDto = this.cartService.createCart();
        return ResponseEntity.ok(cartDto);
    }

    @PostMapping("/items")
    public ResponseEntity<CartDto> postAddCartItem(@RequestBody CartItemDto cartItemDto) { 
        cartItemService.createCartItem(cartItemDto.cartId(), cartItemDto.quantity(), cartItemDto.product().productId());
        CartDto cartDto = cartService.getCart(cartItemDto.cartId());
        return ResponseEntity.ok(cartDto);
    }

    @GetMapping()
    public ResponseEntity<CartDto> getCartById(@PathVariable Long id) {
        CartDto cartDto = cartService.getCart(id);
        return ResponseEntity.ok(cartDto);
    }
    
}
