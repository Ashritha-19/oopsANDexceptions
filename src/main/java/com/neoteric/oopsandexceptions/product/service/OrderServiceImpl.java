package com.neoteric.oopsandexceptions.product.service;

import com.neoteric.oopsandexceptions.product.exceptions.InvalidOrderException;
import com.neoteric.oopsandexceptions.product.interfaces.OrderService;
import com.neoteric.oopsandexceptions.product.model.Order;
import com.neoteric.oopsandexceptions.product.model.PremiumUser;
import com.neoteric.oopsandexceptions.product.model.Product;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements OrderService {

    private Map<String,Order> orderMap = new HashMap<>();

    @Override
    public void placeOrder(Order order) throws InvalidOrderException{

        if (order.getUser() == null || order.getProductList().isEmpty()) {
            throw new InvalidOrderException("Invalid Order: User or Products missing");

        }
        double totalAmount = order.getTotalAmount();

        if (order.getUser() instanceof PremiumUser) {
            PremiumUser premiumUser = (PremiumUser) order.getUser();
            totalAmount = premiumUser.applyDiscount(totalAmount);
            System.out.println("Applying discount for premium user. Discounted total: " + totalAmount);
        } else {
            System.out.println("No discount applied for regular user. Total amount: " + totalAmount);
        }

        if (!processPayment(order.getTotalAmount())){
            System.out.println("Payment Failed"+ PaymentEnum.FAILED);
        }else {
            orderMap.put(order.getOrderId(), order);
            order.markAsPaid();
            System.out.println("Order placed succesfully:"+ order.getTotalAmount());
        }
    }


    @Override
    public void cancelOrder(String orderId) throws InvalidOrderException {

        Order orders = orderMap.get(orderId);
        if (orders == null || orders.isPaid()) {
            throw new InvalidOrderException("Order cannot be cancelled.");
        }
        orderMap.remove(orderId);
        System.out.println("Order canceled successfully."+ PaymentEnum.SUCCES);

    }

    @Override
    public void updateOrder(String orderId, List<Product> productList) throws InvalidOrderException {

        Order orders = orderMap.get(orderId);
        if (orders == null) {
            throw new InvalidOrderException("Order not found.");
        }
        orders = new Order(orders.getOrderId(), orders.getUser(), productList);
        orderMap.put(orderId, orders);
        System.out.println("Order updated successfully.:"+ orders.getOrderId());

    }

    private boolean processPayment(double amount) {
        return amount <= 100000;
    }
}
