package com.delta.service;

import java.util.Collections;
import com.delta.entity.Product;
import com.delta.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PriceCalculationTest {

    @Mock OfferCalculation offerCalculation;
    @Mock ProductRepository repository;

    @InjectMocks PriceCalculation priceCalculation;

    @BeforeEach
    void setup() {
        Product product = new Product();
        product.setItemName("Apple");
        product.setPrice(35);
        product.setOffer(false);
        Mockito.when(repository.findAll()).thenReturn(Collections.singletonList(product));
    }

    @Test
    protected void totalCostOfShopping() {
        String[] items = {"Apple"};
        priceCalculation.totalCostOfShopping(items);
        Mockito.verify(offerCalculation, Mockito.times(1)).addOffer(Mockito.any());

    }

}
