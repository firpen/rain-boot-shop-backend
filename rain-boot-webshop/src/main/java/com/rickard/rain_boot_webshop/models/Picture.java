package com.rickard.rain_boot_webshop.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity 
public class Picture {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pictureId;

    @Column(nullable = false)
    private String img;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public Picture(String img, Product product) {
        this.img = img;
        this.product = product;
    }

    public Picture() {
    }

    public Long getPictureId() {
        return pictureId;
    }

    public void setPictureId(Long pictureId) {
        this.pictureId = pictureId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
