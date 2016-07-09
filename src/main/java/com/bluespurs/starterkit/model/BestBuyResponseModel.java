package com.bluespurs.starterkit.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by seansimpson on 2016-07-09.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class BestBuyResponseModel {
    private BestBuyProductModel[]   products;

    public BestBuyResponseModel() {
        // STUB
    }

    public BestBuyProductModel[]    getProducts()                          { return products; }
    public void                     setProducts(BestBuyProductModel[] val) { products = val; }
}
