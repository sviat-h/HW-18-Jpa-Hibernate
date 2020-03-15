package com.cursor.hw18.controller;

import com.cursor.hw18.model.Book;
import com.cursor.hw18.model.User;
import com.cursor.hw18.service.impl.AuthorServiceImpl;
import com.cursor.hw18.service.impl.BookServiceImpl;
import com.cursor.hw18.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    BookServiceImpl bookService;

    @Autowired
    AuthorServiceImpl authorService;

    @Autowired
    public void addUsersToDb() {
        userService.addUsers("Bob", "Marley", "barley");
        userService.addUsers("Isabelle", "Hammond", "hammond");
        userService.addUsers("Sharon", "Rodgers", "rodgers");
        userService.addUsers("Phoebe", "Mendez", "mendez");
        userService.addUsers("Willie", "Murray", "murray");
        userService.addUsers("Sviatoslav", "Hrynyk", "sviat-h");
        userService.addUsers("Vladyslav", "Verbytskiy", "vladusik");
        userService.addUsers("Markian", "Pylat", "mr.Error");
    }

    public Book findBookById(Long id) {
        return bookService.findBookById(id);
    }

    public List<User> showAllUsers() {
        return userService.getAllUsers();
    }

    public void findBooksByGenre(String genre) {
        bookService.findBooksByGenre(genre);
    }

    public void findBooksByAuthor(String authorsLastName) {
        bookService.findBooksByAuthor(authorsLastName);
    }

    public void showAllBooks() {
        bookService.showAllBook();
    }

    public void addBookToLibrary(String authorFirstName, String authorLastName, String bookTitle, String bookGenre) {
        authorService.addAuthorAndBooks(authorFirstName, authorLastName, List.of(new Book(bookTitle, bookGenre)));
    }
}
