package com.rickard.rain_boot_webshop.models;

import com.rickard.rain_boot_webshop.enums.Color;
import com.rickard.rain_boot_webshop.enums.ShaftHeight;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

/* https://www.baeldung.com/hibernate-inheritance */
@Entity
public class RainBoot extends Product {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ShaftHeight shaftHeight;

    @Column(nullable = false)
    private int size;

    @Enumerated(EnumType.STRING)    
    @Column(nullable = false)
    private Color color;

    public RainBoot(String productName, double price, ShaftHeight shaftHeight, int size, Color color) {
        super(productName, price);
        this.shaftHeight = shaftHeight;
        this.size = size;
        this.color = color;
    }

    public RainBoot() {
    }

    public ShaftHeight getShaftHeight() {
        return shaftHeight;
    }

    public void setShaftHeight(ShaftHeight shaftHeight) {
        this.shaftHeight = shaftHeight;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
