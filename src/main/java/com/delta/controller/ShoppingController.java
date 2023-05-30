package com.delta.controller;

import com.delta.exception.ProductNotFoundException;
import com.delta.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppingController {

    @Autowired
    ShoppingService service;

    @RequestMapping(value = "/calculateShoppingCost")
    public ResponseEntity<String> calculateTotalCost(@RequestParam(value = "items") String[] items) throws ProductNotFoundException {
        return ResponseEntity.ok(service.calculateCost(items));
    }

}
