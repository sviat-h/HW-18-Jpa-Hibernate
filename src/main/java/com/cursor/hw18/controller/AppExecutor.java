package com.cursor.hw18.controller;

import com.cursor.hw18.DB.DataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class AppExecutor {

    @Autowired
    private DataBase dataBase;

    @Transactional
    public void runApp() {

        dataBase.fillDb();

    }


}
