package com.neoteric.oopsandexceptions.product;

import com.neoteric.oopsandexceptions.product.exceptions.InvalidOrderException;
import com.neoteric.oopsandexceptions.product.interfaces.OrderService;
import com.neoteric.oopsandexceptions.product.model.*;
import com.neoteric.oopsandexceptions.product.service.OrderServiceImpl;
import com.neoteric.oopsandexceptions.product.service.ProductService;
import com.neoteric.oopsandexceptions.product.service.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductTest {
    public static void main(String[] args) {

        try {
            ProductService laptop = new Electronics("P001", "Laptop", 53999, 27);
            ProductService lehanga = new Clothing("P002", "Lehanga", 6999, 12);

            UserService regularUser = new RegularUser("U001", "Ashri");
            UserService premiumUser = new PremiumUser("U002", "Krish");

            Order premiumOrder = new Order("O002", premiumUser, Arrays.asList(laptop, lehanga));
            Order regularOrder = new Order("O001", regularUser, Arrays.asList(laptop, lehanga));

            OrderService orderService = new OrderServiceImpl();

            orderService.placeOrder(premiumOrder);
            System.out.println("Order placed successfully for premium user: " + premiumOrder.getOrderId());
            System.out.println("Total amount for premium user (after discount): " + premiumOrder.getTotalAmount() * 0.9);


            orderService.placeOrder(regularOrder);
            System.out.println("Order placed successfully for regular user: " + regularOrder.getOrderId());
            System.out.println("Total amount for regular user (no discount): " + regularOrder.getTotalAmount());

            orderService.updateOrder("O002",Arrays.asList(lehanga));

        } catch (InvalidOrderException e) {
            System.out.println("Invalid Order Exception occurred: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected exception occurred: " + e.getMessage());
        }

    }
}
