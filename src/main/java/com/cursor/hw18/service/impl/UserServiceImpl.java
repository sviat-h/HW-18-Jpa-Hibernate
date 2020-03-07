package com.cursor.hw18.service.impl;

import com.cursor.hw18.model.User;
import com.cursor.hw18.repository.UserRepository;
import com.cursor.hw18.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void addUsers(String firstName, String lastName, String username) {
        userRepository.save(new User(firstName, lastName, username));

    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
