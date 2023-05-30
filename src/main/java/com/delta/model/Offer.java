package com.delta.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Offer {
    private String offerDetail;
    //at this quantity there would be an offer
    private Integer buyQuantity;
    //this would be the no of quantity that would be priced for number of quantity (buyQuantity) of the product
    private Integer buyAtCostOfQuantity;

}
