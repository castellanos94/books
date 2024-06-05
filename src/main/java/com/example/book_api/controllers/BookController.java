package com.example.book_api.controllers;

import com.example.book_api.bo.Book;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public interface BookController {
    @GetMapping("/books")
    ResponseEntity<List<Book>> getAllBooks();

    @GetMapping("/books/{id}")
    ResponseEntity<Book> getBookById(@PathVariable Long id);

    @PostMapping
    ResponseEntity<Book> createBook(@RequestBody @Valid Book book);

    @PutMapping("/books/{id}")
    ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody @Valid Book book);

    @DeleteMapping("/books/{id}")
    ResponseEntity<Void> deleteBook(@PathVariable Long id);
}
