package com.springangular.ecommerce.repository;

import com.springangular.ecommerce.model.Cart;
import com.springangular.ecommerce.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends CrudRepository<Cart, Integer> {

    public List<Cart> findByUser(User user);



}
