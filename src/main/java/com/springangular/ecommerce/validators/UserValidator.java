package com.springangular.ecommerce.validators;

import com.springangular.ecommerce.model.User;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UserValidator {

    public static List<String> validate(User user) {

        List<String> errors = new ArrayList<>();
        if(!StringUtils.hasLength(user.getUserName())){
            errors.add("veiller renseigner le nom d'utilisateur");
        }

        if(!StringUtils.hasLength(user.getUserPassword())){
            errors.add("veiller renseigner le mot de passe");
        }
            return errors;

    };
}
