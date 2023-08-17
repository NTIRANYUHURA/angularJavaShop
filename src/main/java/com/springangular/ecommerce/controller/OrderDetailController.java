package com.springangular.ecommerce.controller;

import com.springangular.ecommerce.model.OrderInput;
import com.springangular.ecommerce.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderDetailController {

        @Autowired
        private OrderDetailService orderDetailService;

        @PreAuthorize("hasRole('User')")
        @PostMapping({"/placeOrder"})
        public void placeOrder(@RequestBody OrderInput orderInput){
                orderDetailService.placeOrder(orderInput);

        }

}
