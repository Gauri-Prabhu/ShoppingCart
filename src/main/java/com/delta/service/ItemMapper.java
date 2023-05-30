package com.delta.service;

import com.delta.entity.Product;
import com.delta.model.Item;
import com.delta.model.Offer;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ItemMapper {

    public static Item mapItem(Product product) {
        Item item = new Item();
        item.setItemName(product.getItemName());
        item.setBasePrice(product.getPrice());
        item.setPrice(0);
        item.setOffer(product.isOffer() ? mapOffer(product) : null);
        return item;
    }


    private static Offer mapOffer(Product product) {
        Offer offer = new Offer();
        offer.setOfferDetail(product.getOfferDetail());
        offer.setBuyAtCostOfQuantity(product.getBuyAtCostOfQuantity());
        offer.setBuyQuantity(product.getBuyQuantity());
        return offer;
    }
}
