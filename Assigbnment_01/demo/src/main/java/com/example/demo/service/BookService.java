package com.example.demo.service;

import com.example.demo.entity.book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public book saveBook(book book) {
        return bookRepository.save(book);
    }

    public book getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public List<book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    public book updateBook(Long id, book updatedBook) {
        return bookRepository.updateBook(id, updatedBook);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteBook(id);
    }
}
