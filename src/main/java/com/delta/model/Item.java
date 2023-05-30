package com.delta.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {

    private String itemName;
    private Integer basePrice;
    private int price;
    private int quantity;
    private Offer offer;

}
