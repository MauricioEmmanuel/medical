package com.admin.medical.service;

import com.admin.medical.model.User;
import com.admin.medical.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public User getUser(String userName, String userPass) {
        return (User) userRepository.findByUserNameAndUserPass(userName, userPass);
    }
}

