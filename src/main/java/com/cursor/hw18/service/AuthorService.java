package com.cursor.hw18.service;

import com.cursor.hw18.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {
    void addAuthorAndBooks(String firstName, String lastName, List<Book> books);
}
