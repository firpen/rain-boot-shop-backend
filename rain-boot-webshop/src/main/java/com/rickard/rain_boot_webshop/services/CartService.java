package com.rickard.rain_boot_webshop.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rickard.rain_boot_webshop.dtos.CartDto;
import com.rickard.rain_boot_webshop.dtos.CartItemDto;
import com.rickard.rain_boot_webshop.dtos.ProductDto;
import com.rickard.rain_boot_webshop.exceptions.CartNotFoundException;
import com.rickard.rain_boot_webshop.models.Cart;
import com.rickard.rain_boot_webshop.models.CartItem;
import com.rickard.rain_boot_webshop.models.RainBoot;
import com.rickard.rain_boot_webshop.repositories.CartRepository;

@Service
public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public CartDto createCart() {
        List<CartItem> cartItems = new ArrayList<>();
        Cart cart = new Cart(cartItems);
        cartRepository.save(cart);
        List<CartItemDto> cartItemDtos = new ArrayList<>();
        CartDto cartDto = new CartDto(cart.getCartId(), cartItemDtos);
        return cartDto;
    }

    public CartDto getCart(Long cartId) {
        Optional<Cart> optionalCart = cartRepository.findById(cartId);
        if (optionalCart.isEmpty()) {
            throw new CartNotFoundException();
        }
        Cart cart = optionalCart.get();
        List<CartItem> cartItems = cart.getCartItems();
        List<CartItemDto> cartItemDtos = new ArrayList<>();
        for (CartItem cartItem : cartItems) {
            ProductDto productDto = new ProductDto(cartItem.getProduct().getProductId(),
                    cartItem.getProduct().getProductName(), cartItem.getProduct().getPrice());
            Integer size = cartItem.getProduct() instanceof RainBoot rainBoot
                    ? rainBoot.getSize()
                    : null;
            CartItemDto cartItemDto = new CartItemDto(cartItem.getQuantity(), productDto, size,
                    cartItem.getCart().getCartId());
                    cartItemDtos.add(cartItemDto);
        }
        CartDto cartDto = new CartDto(cart.getCartId(), cartItemDtos);
        return cartDto;
    }

    public void deleteCart(Long cartId) {
        Optional<Cart> optionalCart = cartRepository.findById(cartId);
        Cart cart = optionalCart.get();
        cartRepository.delete(cart);
    }

}
