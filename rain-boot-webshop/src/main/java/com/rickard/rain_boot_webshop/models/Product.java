package com.rickard.rain_boot_webshop.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

/* https://www.baeldung.com/hibernate-inheritance */
@Entity 
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Product {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id 
    private Long productId;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private String img;

    public Product(String productName, double price, String img) {
        this.productName = productName;
        this.price = price;
        this.img = img;
    }

    public Product() {}

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

}
