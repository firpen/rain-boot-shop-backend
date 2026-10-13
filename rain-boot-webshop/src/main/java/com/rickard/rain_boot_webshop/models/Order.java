package com.rickard.rain_boot_webshop.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Table(name = "orders")
@Entity 
public class Order {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    @Column(nullable=false)
    private String email;

    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    public Order(Long orderId, String email, Cart cart) {
        this.orderId = orderId;
        this.email = email;
        this.cart = cart;
    }

    public Order() {}

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    

}
