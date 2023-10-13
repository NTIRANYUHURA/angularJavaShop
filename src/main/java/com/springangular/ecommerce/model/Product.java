package com.springangular.ecommerce.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;
import java.util.Set;

@Getter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )

    private Integer productId;

    private String productName;

    @Column(length=2000)
    private String productDescription;

    private Double productDiscountedPrice;

    private Double productActualPrice;






    @ManyToMany(fetch = FetchType.EAGER, cascade= CascadeType.ALL)
    @JoinTable(name = "product_images",
    joinColumns = {
        @JoinColumn(name = "product_id")},
        inverseJoinColumns = {
        @JoinColumn(name = "image_id")

    })
    private Set<ImageModel> productImages;





    public Product(){

    }

    public Product(String productName, String productDescription, Double productDiscountedPrice, Double productActualPrice, Set<ImageModel> productImages) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productDiscountedPrice = productDiscountedPrice;
        this.productActualPrice = productActualPrice;
        this.productImages = productImages;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public void setProductDiscountedPrice(Double productDiscountedPrice) {
        this.productDiscountedPrice = productDiscountedPrice;
    }

    public void setProductActualPrice(Double productActualPrice) {
        this.productActualPrice = productActualPrice;
    }

    public void setProductImages(Set<ImageModel> productImages) {
        this.productImages = productImages;
    }
}
