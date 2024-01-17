package com.springangular.ecommerce.validators;

import com.springangular.ecommerce.model.OrderInput;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class OrderInputValidator {

    public static List<String> validate(OrderInput orderInput) {
        List<String> errors = new ArrayList<>();
        if (!StringUtils.hasLength(orderInput.getFullName())) {
            errors.add("veiller renseigner votre nom ");
        }

        if (!StringUtils.hasLength(orderInput.getFullAddress())) {
            errors.add("veiller renseigner le votre adresse");
        }

        if (!StringUtils.hasLength(orderInput.getContactNumber())) {
            errors.add("veiller renseigner le votre numero de contact");
        }

        return errors;


    }

}
