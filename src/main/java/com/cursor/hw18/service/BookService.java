package com.cursor.hw18.service;

import com.cursor.hw18.model.Book;
import org.springframework.stereotype.Service;

@Service
public interface BookService {
    Book findBookById(Long bookId);

    void findBooksByGenre(String genre);

    void findBooksByAuthor(String authorsLastName);

    void showAllBook();
}
