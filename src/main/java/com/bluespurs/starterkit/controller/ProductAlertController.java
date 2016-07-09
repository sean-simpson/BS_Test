package com.bluespurs.starterkit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductAlertController {
    public static final Logger log = LoggerFactory.getLogger(ProductAlertController.class);

    @RequestMapping(method = RequestMethod.POST, path = "/product/alert")
    public String productAlert() {
        log.info("Visiting index page");
        return INTRO;
    }
}
