package com.springangular.ecommerce.exception;

public class InvalidEntityException extends RuntimeException {

    public InvalidEntityException (String msg) {
        super(msg);
    }
}
