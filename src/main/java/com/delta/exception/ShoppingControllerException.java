package com.delta.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ShoppingControllerException {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductDoesNotExist(ProductNotFoundException ex){
        return ResponseEntity.status(404).body(ex.getMessage());
    }
}
