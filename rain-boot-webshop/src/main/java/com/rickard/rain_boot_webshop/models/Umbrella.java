package com.rickard.rain_boot_webshop.models;

import com.rickard.rain_boot_webshop.enums.Color;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

/* https://www.baeldung.com/hibernate-inheritance */
@Entity 
public class Umbrella extends Product {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Color color;

    public Umbrella(String productName, double price, Color color) {
        super(productName, price);
        this.color = color;
    }

    public Umbrella() {}

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
}

