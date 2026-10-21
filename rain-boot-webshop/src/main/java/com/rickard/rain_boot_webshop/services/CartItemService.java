package com.rickard.rain_boot_webshop.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rickard.rain_boot_webshop.exceptions.CartNotFoundException;
import com.rickard.rain_boot_webshop.exceptions.ProductNotFoundException;
import com.rickard.rain_boot_webshop.models.Cart;
import com.rickard.rain_boot_webshop.models.CartItem;
import com.rickard.rain_boot_webshop.models.Product;
import com.rickard.rain_boot_webshop.repositories.CartItemRepository;
import com.rickard.rain_boot_webshop.repositories.CartRepository;
import com.rickard.rain_boot_webshop.repositories.ProductRepository;

@Service 
public class CartItemService {
    
    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public CartItemService(CartItemRepository cartItemRepository, CartRepository cartRepository, ProductRepository productRepository) {
        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
        this.productRepository= productRepository;
    }

    public void createCartItem(Long cartId, int quantity, Long productId) {
        Optional<Cart> optionalCart = this.cartRepository.findById(cartId);
        Optional<Product> optionalProduct = this.productRepository.findById(productId);
        if (optionalProduct.isEmpty()) {
            throw new ProductNotFoundException();
        } else if (optionalCart.isEmpty()) { 
            throw new CartNotFoundException();
        }
        Cart cart = optionalCart.get();
        Product product = optionalProduct.get();
        CartItem cartItem = new CartItem(quantity, cart, product);
        cartItemRepository.save(cartItem);
    }
}
