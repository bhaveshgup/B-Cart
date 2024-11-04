package com.Ecommerce.ByCart.Exceptions;

public class productNotFoundException extends RuntimeException{
    public productNotFoundException(String message) {
        super(message);
    }
}
