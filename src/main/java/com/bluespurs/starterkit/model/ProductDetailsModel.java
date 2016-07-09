package com.bluespurs.starterkit.model;

/**
 * Created by seansimpson on 2016-07-09.
 */
public class ProductDetailsModel {
    private String        productName         = "";
    private String        bestPrice           = "0.00";
    private String        currency            = "USD";
    private String        location            = "";

    public ProductDetailsModel(String productName, String bestPrice, String currency, String location) {
        this.productName    = productName;
        this.bestPrice      = bestPrice;
        this.currency       = currency;
        this.location       = location;
    }

    public String getProductName()  { return productName; }
    public String getBestPrice()    { return bestPrice; }
    public String getCurrency()     { return currency; }
    public String getLocation()     { return location; }
}
