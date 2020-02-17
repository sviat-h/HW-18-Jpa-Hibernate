package com.cursor.hw18.controller;

import com.cursor.hw18.DB.DataBase;
import com.cursor.hw18.repository.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Component
public class AppExecutor {

    @Autowired
    private DataBase dataBase;

    @Autowired
    private UserRepositoryImpl userRepository;

    @Autowired
    EntityManager entityManager;

    @Transactional
    public void runApp() {

        dataBase.fillDb();

        makeUserOperations();
    }

    private void makeUserOperations() {

        userRepository.takeBookById(1L);

        userRepository.addBook("The Witcher", "Fantasy");

        userRepository.findByAuthor("King");

        userRepository.findByGenre("Drama");
    }
}
