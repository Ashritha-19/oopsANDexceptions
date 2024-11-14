package com.neoteric.oopsandexceptions.product.model;

import com.neoteric.oopsandexceptions.product.service.ProductService;

public class Clothing extends ProductService {
    public Clothing(String productId, String name, double price, int stock) {
        super(productId, name, price, stock);
    }

    @Override
    public String getCategory() {
        return "Clothing";
    }
}
