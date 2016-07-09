package com.bluespurs.starterkit.controller;

import com.bluespurs.starterkit.model.ProductDetailsModel;
import com.bluespurs.starterkit.model.BestBuyProductModel;
import com.bluespurs.starterkit.model.BestBuyResponseModel;
import com.bluespurs.starterkit.model.WalmartProductModel;
import com.bluespurs.starterkit.model.WalmartResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class ProductSearchController {
    public static final Logger log = LoggerFactory.getLogger(ProductSearchController.class);

    @RequestMapping("/product/search")
    public ProductDetailsModel performSearch(@RequestParam(value="name", defaultValue = "") String name) {
        log.info("[ProductSearchController] Searching for product '" + name + "'");
        ProductDetailsModel product = null;
        RestTemplate request        = new RestTemplate();

        log.info("[ProductSearchController] Requesting product from Walmart...");
        WalmartResponseModel walmartResponse    = request.getForObject("http://api.walmartlabs.com/v1/search?apiKey=rm25tyum3p9jm9x9x7zxshfa&query=" + name + "&sort=price&order=asc&numItems=1", WalmartResponseModel.class);

        if (walmartResponse != null && walmartResponse.getItems().length > 0) {
            WalmartProductModel walmartProduct = walmartResponse.getItems()[0];
            product = new ProductDetailsModel(walmartProduct.getName(), String.format("%.2f",walmartProduct.getSalePrice()), "USD", "Walmart");
            log.info("[ProductSearchController] Found product " + product.getProductName() + " from Walmart for " + product.getBestPrice() + " USD");
        }

        log.info("[ProductSearchController] Requesting product from BestBuy...");
        BestBuyResponseModel bestBuyResponse    = request.getForObject("https://api.bestbuy.com/v1/products(name=\"" + name + "*\")?format=json&pageSize=1&page=1&show=name,salePrice&sort=salePrice.asc&apiKey=pfe9fpy68yg28hvvma49sc89", BestBuyResponseModel.class);

        if (bestBuyResponse != null && bestBuyResponse.getProducts().length > 0) {
            BestBuyProductModel bestBuyProduct  = bestBuyResponse.getProducts()[0];
            if (product == null || bestBuyProduct.getSalePrice() < Float.valueOf(product.getBestPrice())) {
                product = new ProductDetailsModel(bestBuyProduct.getName(), String.format("%.2f", bestBuyProduct.getSalePrice()), "USD", "BestBuy");
                log.info("[ProductSearchController] Found product " + product.getProductName() + " from BestBuy for " + product.getBestPrice() + " USD");
            }
        }

        return product;
    }
}
