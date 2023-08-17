package com.springangular.ecommerce.repository;

import com.springangular.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRipository extends JpaRepository<User, String> {
}
