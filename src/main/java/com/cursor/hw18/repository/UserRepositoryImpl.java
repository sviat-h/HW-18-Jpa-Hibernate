package com.cursor.hw18.repository;

import com.cursor.hw18.entity.Author;
import com.cursor.hw18.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
public class UserRepositoryImpl {

    @Autowired
    private EntityManager entityManager;
    @Autowired
    private UserRepository userRepository;

    public void takeBookById(Long id) {
        System.out.println(userRepository.findById(id));
    }

    public void addBook(String title, String genre) {
        entityManager.persist(new Book(title, genre));
    }

    public void findByAuthor(String lastName) {
        System.out.println(entityManager.createNativeQuery("SELECT books.* FROM authors INNER JOIN books ON books.id = authors.id\n" +
                "WHERE authors.last_name = '" + lastName + "'", Author.class).getSingleResult());
    }

    public void findByGenre(String genre) {
        System.out.println(entityManager.createNativeQuery("SELECT title FROM books \n" +
                "WHERE genre = '" + genre + "';").getSingleResult());
    }
}
