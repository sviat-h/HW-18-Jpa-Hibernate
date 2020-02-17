package com.cursor.hw18.service;

import com.cursor.hw18.entity.Author;
import com.cursor.hw18.entity.Book;
import com.cursor.hw18.entity.JointTable;
import com.cursor.hw18.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
public class UserService {

    @Autowired
    private EntityManager entityManager;
    @Autowired
    Author author;
    @Autowired
    Book book;
    @Autowired
    User user;
    @Autowired
    JointTable jointTable;


    public void takeBook() {
        entityManager.createQuery("");
    }

}
