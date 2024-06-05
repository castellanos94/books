package com.example.book_api.controllers;

import com.example.book_api.bo.Book;
import com.example.book_api.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class BookControllerImpl implements BookController{
    @Autowired
    private BookRepository bookRepository;
    @Override
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> all = bookRepository.findAll();
        if(all.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(all);
    }

    @Override
    public ResponseEntity<Book> getBookById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if(book.isPresent()) {
            return ResponseEntity.ok(book.get());
        }
        return ResponseEntity.notFound().build();

    }

    @Override
    public ResponseEntity<Book> createBook(Book book) {

        return null;
    }

    @Override
    public ResponseEntity<Book> updateBook(Long id, Book book) {
        Optional<Book> byId = bookRepository.findById(id);
        if(byId.isPresent()) {
            book.setId(id);
           Book saveBook =bookRepository.save(book);
           return ResponseEntity.ok(saveBook);
        }
        return ResponseEntity.badRequest().build();
    }

    @Override
    public ResponseEntity<Void> deleteBook(Long id) {
        Optional<Book> byId = bookRepository.findById(id);
        if(byId.isPresent()) {
            bookRepository.delete(byId.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

}
