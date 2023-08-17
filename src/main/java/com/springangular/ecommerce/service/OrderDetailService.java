package com.springangular.ecommerce.service;

import com.springangular.ecommerce.config.JwtRequestFilter;
import com.springangular.ecommerce.model.*;
import com.springangular.ecommerce.repository.OrderDetailRepository;
import com.springangular.ecommerce.repository.ProductRepository;
import com.springangular.ecommerce.repository.UserRipository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {

    private static final String ORDER_PLACED = "placed";
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRipository userRipository;

    public void placeOrder(OrderInput orderInput){
        List<OrderProductQuantity>  productQuantityList= orderInput.getOrderProductQuantityList();

        for(OrderProductQuantity order : productQuantityList){
            Product product = productRepository.findById(order.getProductId()).get();
            String currentUser = JwtRequestFilter.CURRENT_USER;
            User user= userRipository.findById(currentUser).get();
            OrderDetail  orderDetail = new OrderDetail(
                    orderInput.getFullName(),
                    orderInput.getFullAddress(),
                    orderInput.getContactNumber(),
                    orderInput.getAlternateContactNumber(),
                    ORDER_PLACED,
                   product.getProductActualPrice() * order.getProductId(),
                    product,
                    user
            );

            orderDetailRepository.save(orderDetail);
        }


    }
}
