package com.cursor.hw18.view.impl;

import com.cursor.hw18.controller.UserController;
import com.cursor.hw18.view.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class LibraryMenu extends Menu {

    @Autowired
    UserController userController;

    @Autowired
    UsersMenu usersMenu;

    private Scanner scanner = new Scanner(System.in);

    private String[] exitItems = {"9.Back", "0.Exit"};
    private String[] items = {"1.Search books by genre", "2.Search books by author", "3.Show all books", "4.Add book to library", "9.Back", "0.Exit"};

    @Override
    protected void showMenu() {

        showItems(items);
        String choice = scanner.next();

        switch (choice) {
            case "1":
                findByGenre();
                break;
            case "2":
                findByAuthor();
                break;
            case "3":
                showAllBooks();
                break;
            case "4":
                addBookToLibrary();
                break;
            case "9":
                takeStepBack();
                break;
            case "0":
                exit();
            default:
                System.err.println("Wrong choice. Please try again.");
                showMenu();
        }
    }

    private void addBookToLibrary() {

        System.out.println("Enter author first name: ");
        String firstName = scanner.next().toLowerCase();

        System.out.println("Enter author last name: ");
        String lastName = scanner.next().toLowerCase();

        System.out.println("Enter book title: ");
        String title = scanner.next().toLowerCase();

        System.out.println("Enter book genre: ");
        String genre = scanner.next().toLowerCase();

        userController.addBookToLibrary(capitalizeFirstLetter(firstName), capitalizeFirstLetter(lastName), capitalizeFirstLetter(title), capitalizeFirstLetter(genre));

        System.err.println("You have successfully added the book to our library.Thank you!");

        showItems(exitItems);
        showExitMenu();
    }

    private void showAllBooks() {

        userController.showAllBooks();

        showItems(exitItems);
        showExitMenu();
    }


    private void findByGenre() {

        System.out.println("Enter genre: ");

        String choice = scanner.next().toLowerCase();

        switch (choice) {
            case "adventure":
            case "classic":
            case "crime":
            case "drama":
            case "horror":
            case "political satire":

                userController.findBooksByGenre(capitalizeFirstLetter(choice));

                showItems(exitItems);
                showExitMenu();
        }
    }

    private void findByAuthor() {

        System.out.println("Enter author last name:");

        String choice = scanner.next().toLowerCase();

        switch (choice) {
            case "tolkien":
            case "orwell":
            case "christie":
            case "miller":
            case "king":

                userController.findBooksByAuthor(capitalizeFirstLetter(choice));

                showItems(exitItems);
                showExitMenu();
        }
    }

    private void showExitMenu() {
        String choice = scanner.next();

        switch (choice) {
            case "9":
                showMenu();
                break;
            case "0":
                exit();
            default:

                System.err.println("Wrong choice. Please try again.");
                showExitMenu();
        }
    }

    @Override
    protected void takeStepBack() {
        usersMenu.showMenu();
    }

    private String capitalizeFirstLetter(String word) {
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }
}
