package com.bluespurs.starterkit.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by seansimpson on 2016-07-09.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class WalmartResponseModel {
    private WalmartProductModel[]   items;

    public WalmartResponseModel() {
        // STUB
    }

    public WalmartProductModel[]    getItems()                          { return items; }
    public void                     setItems(WalmartProductModel[] val) { items = val; }
}
