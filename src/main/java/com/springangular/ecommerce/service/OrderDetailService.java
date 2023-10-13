package com.springangular.ecommerce.service;

import com.springangular.ecommerce.config.JwtRequestFilter;
import com.springangular.ecommerce.model.*;
import com.springangular.ecommerce.repository.CartRepository;
import com.springangular.ecommerce.repository.OrderDetailRepository;
import com.springangular.ecommerce.repository.ProductRepository;
import com.springangular.ecommerce.repository.UserRipository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    private CartRepository cartRepository;


    public List<OrderDetail> getAllOrderDetails(String status){
        List<OrderDetail> orderDetails = new ArrayList<>();
         if(status.equals("All")){

             orderDetailRepository.findAll().forEach(
                     x-> orderDetails.add(x)
             );

         } else {

             orderDetailRepository.findByOrderStatus(status).forEach(
                     x -> orderDetails.add(x)
             );

         }



         return orderDetails;
    }


    public List<OrderDetail> getOrderDetails(){

        String currentUser = JwtRequestFilter.CURRENT_USER;
        User user = userRipository.findById(currentUser).get();

        return orderDetailRepository.findByUser(user);

    }

    public void placeOrder(OrderInput orderInput, boolean isSingleProductCheckout){

        List<OrderProductQuantity> productQuantityList = orderInput.getOrderProductQuantityList();

            for (OrderProductQuantity o : productQuantityList) {
                Product product = productRepository.findById(o.getProductId()).get();

                String currentUser = JwtRequestFilter.CURRENT_USER;
                User user = userRipository.findById(currentUser).get();

            OrderDetail orderDetail = new OrderDetail(

                    orderInput.getFullName(),
                    orderInput.getFullAddress(),
                    orderInput.getContactNumber(),
                    orderInput.getAlternateContactNumber(),
                    ORDER_PLACED,
                    product.getProductActualPrice() * o.getQuantity(),
                    product,
                    user
            );

            if(!isSingleProductCheckout){
                List<Cart> carts =  cartRepository.findByUser(user);
                carts.stream().forEach(x-> cartRepository.deleteById(x.getCartId()));

            }

            orderDetailRepository.save(orderDetail);

        }



        }

    public void markOrderAsDelivered(Integer orderId) {

        OrderDetail orderDetail =  orderDetailRepository.findById(orderId).get();

    if(orderDetail != null){
        orderDetail.setOrderStatus("commande livré");
        orderDetailRepository.save(orderDetail);
    }

    }
}

