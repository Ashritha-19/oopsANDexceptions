package com.neoteric.oopsandexceptions.product.model;

import com.neoteric.oopsandexceptions.product.service.UserService;

public class RegularUser extends UserService {
    public RegularUser(String userId, String name) {
        super(userId, name);
    }

    @Override
    public boolean isPremiumUser() {
        return false;
    }
}
