package com.delta.exception;

public class ProductNotFoundException extends RuntimeException{

    String message;

    public ProductNotFoundException(String message) {
        super(message);
        this.message = message;
    }

}
