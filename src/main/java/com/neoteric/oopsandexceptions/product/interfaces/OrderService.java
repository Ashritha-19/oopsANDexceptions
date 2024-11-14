package com.neoteric.oopsandexceptions.product.interfaces;

import com.neoteric.oopsandexceptions.product.exceptions.InvalidOrderException;
import com.neoteric.oopsandexceptions.product.model.Order;
import com.neoteric.oopsandexceptions.product.model.Product;

import java.util.List;


public interface OrderService {

    void placeOrder(Order order) throws InvalidOrderException;

    void cancelOrder(String orderId) throws InvalidOrderException;

    void updateOrder(String orderId, List<Product> productList) throws InvalidOrderException;


}
