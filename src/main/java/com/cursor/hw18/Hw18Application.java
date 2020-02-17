package com.cursor.hw18;

import com.cursor.hw18.controller.AppExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Hw18Application implements CommandLineRunner {

    @Autowired
    private AppExecutor appExecutor;

    public static void main(String[] args) {
        SpringApplication.run(Hw18Application.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        appExecutor.runApp();
    }
}
