package com.bluespurs.starterkit.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by seansimpson on 2016-07-09.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class WalmartProductModel {
    private float   salePrice;
    private String  name;

    public WalmartProductModel() {
        // STUB
    }

    public float    getSalePrice()          { return salePrice; }
    public void     setSalePrice(float val) { salePrice = val; }

    public String   getName()               { return name; }
    public void     setName(String val)     { name = val; }

    @Override
    public String toString() {
        return "WalmartProductModel{" +
                "name='" + name + "'" +
                ",salePrice=" + String.format("%.2f", salePrice) +
                "}";
    }
}
