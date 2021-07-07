package com.cursor.hw18.view.impl;

import com.cursor.hw18.controller.UserController;
import com.cursor.hw18.model.User;
import com.cursor.hw18.view.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class UsersMenu extends Menu {

    @Autowired
    UserController userController;

    @Autowired
    LibraryMenu libraryMenu;

    private Scanner scanner = new Scanner(System.in);
    private String[] items = {"0.Exit"};

    @Override
    protected void showMenu() {
        List<User> users = userController.showAllUsers();
        int choice = scanner.nextInt();

        for (int i = 0; i < users.size(); i++) {
            System.out.println(i + 1 + ". " + users.get(i));
        }
        showItems(items);

        if (choice <= users.size() && choice != 0) {
            System.err.println("You are - " + users.get(choice - 1));
            libraryMenu.showMenu();
        } else if (choice == 0) {
            exit();
        } else {
            System.err.println("--------------------------\nWrong choice. Please try again.\n--------------------------");
            showMenu();
        }
    }
}
