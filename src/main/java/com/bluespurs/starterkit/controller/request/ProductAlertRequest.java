package com.bluespurs.starterkit.controller.request;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by seansimpson on 2016-07-09.
 */
public class ProductAlertRequest {
    @NotBlank
    private String productName;

    @NotBlank
    @Email
    private String email;

    public ProductAlertRequest() {
        // STUB
    }

    public String   getProductName()            { return productName; }
    public void     setProductName(String val)  { productName = val; }

    public String   getEmail()                  { return email; }
    public void     setEmail(String val)        { email = val; }
}
