package com.neoteric.oopsandexceptions.product.model;

import com.neoteric.oopsandexceptions.product.service.UserService;

public class PremiumUser extends UserService {

    private double discountRate = 0.1;

    public PremiumUser(String userId, String name) {
        super(userId, name);
    }

    @Override
    public boolean isPremiumUser() {
        return true;
    }
    public double applyDiscount(double amount) {
        return amount * (1 - discountRate);
    }
}
