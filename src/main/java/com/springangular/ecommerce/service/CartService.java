package com.springangular.ecommerce.service;


import com.springangular.ecommerce.model.Cart;


import java.util.List;



public interface CartService {


    public void deleteCartItem(Integer cartId);


    public Cart addToCart(Integer productId);


    public List<Cart> getCartDetails();

}
