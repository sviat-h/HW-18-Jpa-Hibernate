package com.cursor.hw18.controller;

import com.cursor.hw18.model.Book;
import com.cursor.hw18.service.impl.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AuthorController {

    @Autowired
    AuthorServiceImpl authorService;

    @Autowired
    public void addAuthorsAndBooks() {
        authorService.addAuthorAndBooks("Ronald", "Tolkien", List.of(new Book("The Hobbit", "Adventure")));
        authorService.addAuthorAndBooks("George", "Orwell", List.of(new Book("1984", "Classic"), new Book("Animal Farm", "Political satire")));
        authorService.addAuthorAndBooks("Agatha", "Christie", List.of(new Book("And There Were None", "Crime"), new Book("Murder in the Mews", "Adventure")));
        authorService.addAuthorAndBooks("Arthur", "Miller", List.of(new Book("The Crucible", "Drama")));
        authorService.addAuthorAndBooks("Stephen", "King", List.of(new Book("The Shining", "Horror")));
    }
}
