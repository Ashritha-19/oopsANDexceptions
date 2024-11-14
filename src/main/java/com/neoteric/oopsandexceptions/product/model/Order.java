package com.neoteric.oopsandexceptions.product.model;

import java.util.List;

public class Order {

    private String orderId;

    private User user;

    private List<Product> productList;

    private double totalAmount;

    private boolean isPaid;

    public Order(String orderId,User user,List<Product> productList) {

        this.orderId = orderId;
        this.user = user;
        this.productList = productList;
        this.totalAmount = calculateTotal();
        this.isPaid = false;

    }

    private double calculateTotal() {
        return productList.stream().mapToDouble(Product::getPrice).sum();
    }

    public void markAsPaid() {
        this.isPaid = true;
    }

    public String getOrderId() {
        return orderId;
    }

    public User getUser() {
        return user;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public double getTotalAmount() {
        return totalAmount;
    }


    public boolean isPaid() {
        return isPaid;
    }
}