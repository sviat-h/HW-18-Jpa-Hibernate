package com.cursor.hw18.repository;

import com.cursor.hw18.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<Book, Long> {

    Optional<Book> findById(Long id);
}
