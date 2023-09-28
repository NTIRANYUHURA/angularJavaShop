package com.springangular.ecommerce.service;

import com.springangular.ecommerce.config.JwtRequestFilter;
import com.springangular.ecommerce.model.Cart;
import com.springangular.ecommerce.model.Product;
import com.springangular.ecommerce.model.User;
import com.springangular.ecommerce.repository.CartRepository;
import com.springangular.ecommerce.repository.ProductRepository;
import com.springangular.ecommerce.repository.UserRipository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRipository userRipository;

    public Cart addToCart(Integer productId){
        Product product = productRepository.findById(productId).get();
        String userName = JwtRequestFilter.CURRENT_USER;
        User user = null;
        if(userName != null) {
            user = userRipository.findById(userName).get();
        }
        if(product != null && user != null){

            Cart cart = new Cart(product, user);
            return cartRepository.save(cart);

        }

        return null;


    }

public List<Cart> getCartDetails(){
String username = JwtRequestFilter.CURRENT_USER;
User user = userRipository.findById(username).get();
return cartRepository.findByUser(user);


}

}
