package com.springangular.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.List;



@Getter

public class  OrderInput {


    private String fullName;

    private String fullAddress;

    private String contactNumber;


    private String alternateContactNumber;

    private List<OrderProductQuantity> OrderProductQuantityList;


    public OrderInput(String fullName, String fullAddress, String contactNumber, String alternateContactNumber, List<OrderProductQuantity> orderProductQuantityList) {
        this.fullName = fullName;
        this.fullAddress = fullAddress;
        this.contactNumber = contactNumber;
        this.alternateContactNumber = alternateContactNumber;
        OrderProductQuantityList = orderProductQuantityList;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setAlternateContactNumber(String alternateContactNumber) {
        this.alternateContactNumber = alternateContactNumber;
    }

    public void setOrderProductQuantityList(List<OrderProductQuantity> orderProductQuantityList) {
        OrderProductQuantityList = orderProductQuantityList;
    }
}
