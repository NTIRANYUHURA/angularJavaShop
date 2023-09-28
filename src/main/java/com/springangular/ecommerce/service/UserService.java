package com.springangular.ecommerce.service;

import com.springangular.ecommerce.model.Role;
import com.springangular.ecommerce.model.User;
import com.springangular.ecommerce.repository.RoleRipository;
import com.springangular.ecommerce.repository.UserRipository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
public class UserService {

    @Autowired
    private UserRipository userRepository;

    @Autowired
    private RoleRipository roleRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    public void initRoleAndUser() {

        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleRepository.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created record");
        roleRepository.save(userRole);

        User adminUser = new User();
        adminUser.setUserName("admin123");
        adminUser.setUserPassword(getEncodedPassword("admin@123"));
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userRepository.save(adminUser);

        User user = new User();
         user.setUserName("ntir");
        user.setUserPassword(getEncodedPassword("ntir@123"));
        user.setUserFirstName("flo");
         user.setUserLastName("fofo");
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        user.setRole(userRoles);
        userRepository.save(user);
    }

    public User registerNewUser(User user){
        Role role = roleRepository.findById("user").get();

        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        user.setRole(roleSet);
        String password = getEncodedPassword(user.getUserPassword());
        user.setUserPassword(password);


        return userRepository.save(user);
    }

    public String getEncodedPassword(String password){
        return passwordEncoder.encode(password);
    }



    //   public User registerNewUser(User user) {
   //     Role role = roleRepository.findById("User").get();
      //  Set<Role> userRoles = new HashSet<>();
       // userRoles.add(role);
       // user.setRole(userRoles);
       // user.setUserPassword(getEncodedPassword(user.getUserPassword()));

       // return userRepository.save(user);
   // }

    //public String getEncodedPassword(String password) {
       // return passwordEncoder.encode(password);
    //}


}