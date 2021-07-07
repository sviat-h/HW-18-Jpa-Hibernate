package com.cursor.hw18.service.impl;

import com.cursor.hw18.model.Author;
import com.cursor.hw18.model.Book;
import com.cursor.hw18.repository.AuthorRepository;
import com.cursor.hw18.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public void addAuthorAndBooks(String firstName, String lastName, List<Book> books) {
        authorRepository.save(new Author(firstName, lastName, books));
    }
}
