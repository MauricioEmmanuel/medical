package com.admin.medical.service;

import com.admin.medical.model.User;

public interface UserService {
    public User getUser(String userName, String userPass);
}
