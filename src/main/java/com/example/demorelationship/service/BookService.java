package com.example.demorelationship.service;

import com.example.demorelationship.model.Book;
import com.example.demorelationship.model.Category;

import java.util.List;
import java.util.UUID;

public interface BookService {
    List<Book> findAll();
    List<Book>findAllByCategory(Category category);
    Book findById(UUID id);
    void save( Book book);
    void delete(Book book);

}
