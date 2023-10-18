package com.springangular.ecommerce.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


import java.util.Optional;
import java.util.Set;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int productId;

    private String productName;

    @Column(length=2000)
    private String productDescription;

    private Double productDiscountedPrice;

    private Double productActualPrice;



    @ManyToMany(fetch = FetchType.EAGER, cascade= CascadeType.ALL  )
    @JoinTable(name = "product_images",
    joinColumns = {
        @JoinColumn(name = "product_id")},
        inverseJoinColumns = {
        @JoinColumn(name = "image_id")

    })
    private Set<ImageModel> productImages;



    public Product(){

    }


    public Product(int productId, String productName, String productDescription, Double productDiscountedPrice, Double productActualPrice, Set<ImageModel> productImages) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productDiscountedPrice = productDiscountedPrice;
        this.productActualPrice = productActualPrice;
        this.productImages = productImages;

    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Double getProductDiscountedPrice() {
        return productDiscountedPrice;
    }

    public void setProductDiscountedPrice(Double productDiscountedPrice) {
        this.productDiscountedPrice = productDiscountedPrice;
    }

    public Double getProductActualPrice() {
        return productActualPrice;
    }

    public void setProductActualPrice(Double productActualPrice) {
        this.productActualPrice = productActualPrice;
    }

    public Set<ImageModel> getProductImages() {
        return productImages;
    }

    public void setProductImages(Set<ImageModel> productImages) {
        this.productImages = productImages;
    }


}

