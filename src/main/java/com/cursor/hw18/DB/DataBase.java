package com.cursor.hw18.DB;

import com.cursor.hw18.entity.Author;
import com.cursor.hw18.entity.Book;
import com.cursor.hw18.entity.JointTable;
import com.cursor.hw18.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
public class DataBase {

    private User userId1 = new User("Bob", "Marley");
    private User userId2 = new User("Isabelle", "Hammond");
    private User userId3 = new User("Sharon", "Rodgers");
    private User userId4 = new User("Phoebe", "Mendez");
    private User userId5 = new User("Willie", "Murray");

    private Author authorId1 = new Author("Ronald", "Tolkien");
    private Author authorId2 = new Author("George", "Orwell");
    private Author authorId3 = new Author("Agatha", "Christie");
    private Author authorId4 = new Author("Arthur", "Miller");
    private Author authorId5 = new Author("Stephen", "King");

    private Book bookId1 = new Book("The Hobbit", "Adventure");
    private Book bookId2 = new Book("1984", "Classic");
    private Book bookId3 = new Book("And There Were None", "Crime");
    private Book bookId4 = new Book("The Crucible", "Drama");
    private Book bookId5 = new Book("The Shining", "Horror");

    private JointTable jointTableId1 = new JointTable(userId1, authorId1, bookId1);
    private JointTable jointTableId2 = new JointTable(userId2, authorId2, bookId2);
    private JointTable jointTableId3 = new JointTable(userId3, authorId3, bookId3);
    private JointTable jointTableId4 = new JointTable(userId4, authorId4, bookId4);
    private JointTable jointTableId5 = new JointTable(userId5, authorId5, bookId5);


    @Autowired
    private EntityManager entityManager;

    public void fillDb() {

        addUsers();
        addBooks();
        addAuthors();
        addIdToJointTable();
    }

    private void addUsers() {

        entityManager.persist(userId1);
        entityManager.persist(userId2);
        entityManager.persist(userId3);
        entityManager.persist(userId4);
        entityManager.persist(userId5);
    }

    private void addAuthors() {

        entityManager.persist(authorId1);
        entityManager.persist(authorId2);
        entityManager.persist(authorId3);
        entityManager.persist(authorId4);
        entityManager.persist(authorId5);
    }


    private void addBooks() {

        entityManager.persist(bookId1);
        entityManager.persist(bookId2);
        entityManager.persist(bookId3);
        entityManager.persist(bookId4);
        entityManager.persist(bookId5);
    }

    private void addIdToJointTable() {

        entityManager.persist(jointTableId1);
        entityManager.persist(jointTableId2);
        entityManager.persist(jointTableId3);
        entityManager.persist(jointTableId4);
        entityManager.persist(jointTableId5);
    }
}
