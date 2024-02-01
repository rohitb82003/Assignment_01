package com.example.demo.repository;

import com.example.demo.entity.book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {

    private final List<book> list = new ArrayList<>();

    public List<book> getAllBooks() {
        return list;
    }

    public book findById(Long id) {
        for (book book : list) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    public book save(book book) {
        book newBook = new book();
        newBook.setId(book.getId());
        newBook.setName(book.getName());
        newBook.setDescription(book.getDescription());
        list.add(newBook);
        return newBook;
    }

    public book updateBook(Long id, book updatedBook) {
        book existingBook = findById(id);
        if (existingBook != null) {
            existingBook.setName(updatedBook.getName());
            existingBook.setDescription(updatedBook.getDescription());
            // Update other fields as needed
            return existingBook;
        } else {
            throw new RuntimeException("Book not found with id: " + id);
        }
    }

    public void deleteBook(Long id) {
        book existingBook = findById(id);
        if (existingBook != null) {
            list.remove(existingBook);
        } else {
            throw new RuntimeException("Book not found with id: " + id);
        }
    }
}
