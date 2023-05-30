package com.delta.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.delta.entity.Product;
import com.delta.exception.ProductNotFoundException;
import com.delta.model.Item;
import com.delta.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceCalculation {

    @Autowired
    OfferCalculation offerCalculation;


    /**
     * Iterate through each item in the basket and calculate cost along with the offer
     * Once each item is mapped with their respective cost based on the quantity and offers
     * Then calculate total cost by adding them
     *
     * @param listOfItems
     * @return
     */
    public String totalCostOfShopping(List<String> listOfItems, Map<String, Product> productMap) {
        Map<String, Item> itemList = new HashMap<>();
        listOfItems.forEach(item -> mapProduct(itemList, item, productMap));
        int totalCostInPenny = itemList.entrySet().stream().map(Entry::getValue).map(Item::getPrice).reduce(0, Integer::sum);
        return totalCost(totalCostInPenny);
    }

    /**
     * Value in GBP or penny
     * If the value is less than 1 pound then return the String in penny otherwise return in pound
     *
     * @param totalCostInPenny
     * @return
     */
    private String totalCost(int totalCostInPenny) {
        return totalCostInPenny >= 100 ? (Double.valueOf(totalCostInPenny) / 100) + " GBP" : totalCostInPenny + "p";
    }


    /**
     * As the items are scanned they are performed below
     * Map Item with the default value received from ProductList
     * Offer calculations are also done
     *
     * @param itemList
     * @param itemName
     * @param productMap
     */
    private void mapProduct(Map<String, Item> itemList, String itemName, Map<String, Product> productMap) throws ProductNotFoundException {
        Item item;
        int quantity = 0;
        if (itemList.containsKey(itemName)) {
            item = itemList.get(itemName);
            quantity = item.getQuantity();
        } else {
            Product product = null;
            if (productMap.containsKey(itemName)) {
                product = productMap.get(itemName);
            } else {
                throw new ProductNotFoundException(itemName.toUpperCase() + " Product listed in shopping bags is not found.");
            }
            item = ItemMapper.mapItem(product);

        }
        item.setQuantity(++quantity);
        offerCalculation.addOffer(item);
        itemList.put(itemName, item);
    }
}
