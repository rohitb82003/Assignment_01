package com.example.demo.controller;

import com.example.demo.entity.book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // Create a new book
    @PostMapping("/create")
    public book createBook(@RequestBody book book) {
        return bookService.saveBook(book);
    }

    // Retrieve all books
    @GetMapping("/all")
    public List<book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // Retrieve a specific book by ID
    @GetMapping("/{bookId}")
    public book getBookById(@PathVariable Long bookId) {
        return bookService.getBookById(bookId);
    }

    // Update an existing book
    @PutMapping("/update/{bookId}")
    public book updateBook(@PathVariable Long bookId, @RequestBody book updatedBook) {
        return bookService.updateBook(bookId, updatedBook);
    }

    // Delete a book by ID
    @DeleteMapping("/delete/{bookId}")
    public String deleteBook(@PathVariable Long bookId) {
        bookService.deleteBook(bookId);
        return "Book with id " + bookId + " has been deleted.";
    }
}
