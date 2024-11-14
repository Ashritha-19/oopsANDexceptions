package com.neoteric.oopsandexceptions.product.service;

import com.neoteric.oopsandexceptions.product.model.User;

public abstract class UserService extends User {

    public UserService(String userId, String name) {
        super(userId, name);
    }

    public abstract boolean isPremiumUser();

}
