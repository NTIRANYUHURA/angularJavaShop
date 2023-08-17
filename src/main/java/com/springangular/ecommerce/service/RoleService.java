package com.springangular.ecommerce.service;

import com.springangular.ecommerce.model.Role;
import com.springangular.ecommerce.repository.RoleRipository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoleService {

    @Autowired
    private RoleRipository roleRepository;

    public Role createNewRole(Role role) {
        return roleRepository.save(role);
    }
}
