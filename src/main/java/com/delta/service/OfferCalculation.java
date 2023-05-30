package com.delta.service;

import com.delta.model.Item;
import com.delta.model.Offer;
import org.springframework.stereotype.Service;

@Service
public class OfferCalculation {

    /**
     * Offer calculation is performed based on the defined Product's offer
     * <p>
     * It can handle buy one get one free - Buy 2 at the price of 1
     * It can handle buy 3 at the price of 2
     * Any challenges can be handled if we define Buy x at the price of y appropriately
     *
     * @param item
     */
    public void addOffer(Item item) {
        Offer offer = item.getOffer();
        int price = 0;
        if (offer != null && offer.getBuyQuantity() != null && item.getQuantity() > 0) {
            if (item.getQuantity() >= offer.getBuyQuantity()) {
                price = (item.getQuantity() / offer.getBuyQuantity()) * item.getBasePrice() * offer.getBuyAtCostOfQuantity();
            }
            if (item.getQuantity() % offer.getBuyQuantity() != 0) {
                price = price + (item.getQuantity() % offer.getBuyQuantity()) * item.getBasePrice();
            }
        } else {
            price = item.getQuantity() * item.getBasePrice();
        }
        item.setPrice(price);
    }
}
