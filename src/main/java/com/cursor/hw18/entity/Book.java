package com.cursor.hw18.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long bookId;

    @Column(name = "authors_first_name")
    private String authorsFirstName;

    @Column(name = "authors_last_name")
    private String authorsLastName;

    @Column(name = "title")
    private String title;

    @Column(name = "genre")
    private String genre;

    @OneToMany(mappedBy = "book", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<JointTable> jointTables;


    public Book(String authorsFirstName, String authorsLastName, String title, String genre) {
        this.authorsFirstName = authorsFirstName;
        this.authorsLastName = authorsLastName;
        this.title = title;
        this.genre = genre;
    }

    public Book() {
    }
}
