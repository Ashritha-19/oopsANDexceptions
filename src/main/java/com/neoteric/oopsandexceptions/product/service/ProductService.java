package com.neoteric.oopsandexceptions.product.service;

import com.neoteric.oopsandexceptions.product.exceptions.OutOfStackException;
import com.neoteric.oopsandexceptions.product.model.Product;

public abstract class ProductService extends Product {

    public ProductService(String productId, String name, double price, int stock) {
        super(productId, name, price, stock);
    }

   public void reduceStock(int quantity){
        if (quantity > getStock()){
            throw new OutOfStackException("Stock not availabe for :" + getName());
        }
            setStock(getStock()- quantity);

   }

   public abstract String getCategory();
}
