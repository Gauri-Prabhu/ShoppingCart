package com.delta.service;

import java.util.*;

import com.delta.entity.Product;
import com.delta.exception.ProductNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PriceCalculationTest {

    @Mock
    OfferCalculation offerCalculation;

    @InjectMocks
    PriceCalculation priceCalculation;
    Map<String, Product> productMap = new HashMap<>();

    @BeforeEach
    void setup() {

        Product product = new Product();
        product.setItemName("Apple");
        product.setPrice(35);
        product.setOffer(false);
        productMap.put("apple", product);
    }

    @Test
    protected void totalCostOfShopping() {
        List<String> items = new ArrayList<>();
        items.add("apple");
        priceCalculation.totalCostOfShopping(items, productMap);
        Mockito.verify(offerCalculation, Mockito.times(1)).addOffer(Mockito.any());

    }

    @Test
    protected void productNotFound() {
        List<String> items = new ArrayList<>();
        items.add("apple");
        items.add("orange");
        Assertions.assertThrows(ProductNotFoundException.class, () -> priceCalculation.totalCostOfShopping(items, productMap));
    }
}
