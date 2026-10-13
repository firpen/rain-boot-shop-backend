package com.rickard.rain_boot_webshop.models;

import com.rickard.rain_boot_webshop.enums.Color;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

/* https://www.baeldung.com/hibernate-inheritance */
@Entity 
public class Umbrella extends Product {

    @Column(nullable = false)
    private Color color;

    public Umbrella(String productName, double price, String img, Color color) {
        super(productName, price, img);
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

