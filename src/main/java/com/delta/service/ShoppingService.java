package com.delta.service;

import com.delta.entity.Product;
import com.delta.exception.ProductNotFoundException;
import com.delta.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ShoppingService {
    @Autowired
    PriceCalculation priceCalculation;

    @Autowired
    ProductRepository repository;

    public String calculateCost(String[] listOfItems) throws ProductNotFoundException {
        List<String> itemShopped = Arrays.stream(listOfItems).map(String::toLowerCase).collect(Collectors.toList());
        Optional<List<Product>> products = repository.findByItemNameIn(itemShopped);
        String totalCost = "0p";
        if (products.isPresent()) {
            Map<String, Product> productMap = products.get().stream().collect(Collectors.toUnmodifiableMap(product -> product.getItemName().toLowerCase(), Function.identity()));
            totalCost = priceCalculation.totalCostOfShopping(itemShopped, productMap);
        } else {
            throw new ProductNotFoundException("Products listed in shopping bags are not found. List of items include " + itemShopped.toString());
        }
        return totalCost;
    }
}
