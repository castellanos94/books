package com.example.book_api.repository;

import com.example.book_api.bo.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    /*List<Book> findAll();
    Optional<Book> findById(long id);
    Book save(Book book);
    void deleteById(long id);*/
}
