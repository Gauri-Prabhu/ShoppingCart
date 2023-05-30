package com.delta.controller;

import com.delta.service.PriceCalculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppingController {

    @Autowired
    PriceCalculation calculation;

    @RequestMapping(value = "/calculateShoppingCost")
    public String calculateTotalCost(@RequestParam(value = "items") String[] items){
        return calculation.totalCostOfShopping(items);
    }

}
