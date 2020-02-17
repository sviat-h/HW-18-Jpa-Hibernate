package com.cursor.hw18.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString

@Component
@Entity
@Table(name = "Books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long bookId;

    @Column(name = "title")
    private String title;

    @Column(name = "genre")
    private String genre;

    @ManyToMany
    @JoinTable(name = "joint_table",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> authors = new ArrayList<>();

    @OneToMany(mappedBy = "book", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<JointTable> jointTables = new ArrayList<>();


    public Book(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }

    public Book() {
    }
}
