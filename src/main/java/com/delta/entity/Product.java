package com.delta.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Setter;

@Entity
@Setter
@Table(name = "PRODUCT")
public class Product {

    @Id
    @Column(name="id")
    private Integer id;
    @Column(name = "itemName")
    private String itemName;
    private int price;
    private boolean offer;
    //offer name
    private String offerDetail;
    //at this quantity there would be an offer
    private Integer buyQuantity;
    //this would be the no of quantity that would be priced for number of quantity (buyQuantity) of the product
    private Integer buyAtCostOfQuantity;

    public Integer getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public int getPrice() {
        return price;
    }

    public boolean isOffer() {
        return offer;
    }

    public String getOfferDetail() {
        return offerDetail;
    }

    public Integer getBuyQuantity() {
        return buyQuantity;
    }

    public Integer getBuyAtCostOfQuantity() {
        return buyAtCostOfQuantity;
    }
}
