////////////////////////////////////////////////////////////////////////////////
//
// Copyright (c) 2023, Suncorp Metway Limited. All rights reserved.
//
// This is unpublished proprietary source code of Suncorp Metway Limited.
// The copyright notice above does not evidence any actual or intended
// publication of such source code.
//
////////////////////////////////////////////////////////////////////////////////

package com.delta.service;

import com.delta.model.Item;
import com.delta.model.Offer;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class OfferCalculationTest {

    @InjectMocks
    OfferCalculation offerCalculation;

    @Test
    protected void calculationWithoutOffer(){
        Item item = itemWithoutOffer();
        offerCalculation.addOffer(item);
        assertEquals(70, item.getPrice());
    }

    @Test
    protected void calculationWithOffer(){
        Item item = itemWithOffer();
        offerCalculation.addOffer(item);
        assertEquals(100, item.getPrice());
    }

    private Item itemWithoutOffer(){
        Item item = new Item();
        item.setItemName("Apple");
        item.setBasePrice(35);
        item.setPrice(0);
        item.setOffer(null);
        item.setQuantity(2);
        return item;
    }

    private Item itemWithOffer(){
        Item item = new Item();
        item.setItemName("Melon");
        item.setBasePrice(50);
        item.setPrice(0);
        Offer offer =new Offer();
        offer.setOfferDetail("Buy 1 get 1 Free");
        offer.setBuyAtCostOfQuantity(1);
        offer.setBuyQuantity(2);
        item.setOffer(offer);
        item.setQuantity(3);
        return item;
    }
}
