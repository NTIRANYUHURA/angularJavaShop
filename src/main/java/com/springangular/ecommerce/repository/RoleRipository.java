package com.springangular.ecommerce.repository;

import com.springangular.ecommerce.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRipository extends JpaRepository<Role, String> {
}
