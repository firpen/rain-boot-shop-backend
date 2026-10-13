package com.rickard.rain_boot_webshop.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

/* https://www.baeldung.com/spring-data-rest-relationships */
@Entity 
public class Cart {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long cartId;

    @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItems;

    public Cart(Long cartId, List<CartItem> cartItems) {
        this.cartId = cartId;
        this.cartItems = cartItems;
    }

    public Cart() {}

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

}
