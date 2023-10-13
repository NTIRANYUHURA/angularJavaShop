package com.springangular.ecommerce.repository;

import com.springangular.ecommerce.model.OrderDetail;
import com.springangular.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
 public List<OrderDetail> findByUser(User user);

 public List<OrderDetail> findByOrderStatus( String status);
}
