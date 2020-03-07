package com.cursor.hw18.view.impl;

import com.cursor.hw18.controller.UserController;
import com.cursor.hw18.view.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MainMenu extends Menu {

    @Autowired
    UserController userController;

    @Autowired
    UsersMenu usersMenu;

    private Scanner scanner = new Scanner(System.in);

    private String[] items = {"1.Select user", "0.Exit"};

    @Override
    @Autowired
    protected void showMenu() {
        showItems(items);

        String choice = scanner.next();

        switch (choice) {
            case "1":
                System.err.println("List of users. Who are you? (We do not have any user authentication, and therefore -" +
                        " please do not fool us. God see everything. Thanks!)");

                usersMenu.showMenu();
                break;
            case "0":
                exit();
                break;
            default:
                System.err.println("Wrong choice. Please try again.");
                showMenu();
        }
    }
}
