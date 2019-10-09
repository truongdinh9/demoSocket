package com.example.demorelationship.service.impl;

import com.example.demorelationship.model.Book;
import com.example.demorelationship.model.Category;
import com.example.demorelationship.repo.BookRepo;
import com.example.demorelationship.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepo bookRepo;
    @Override
    public List<Book> findAll() {
        return bookRepo.findAll();
    }

    @Override
    public List<Book> findAllByCategory(Category category) {
        return bookRepo.findAllByCategory(category);
    }

    @Override
    public Book findById(UUID id) {
        Optional<Book> optionalBook = bookRepo.findById(id);
        return optionalBook.orElse(null);
    }

    @Override
    public void save(Book book) {
       bookRepo.save(book);
    }

    @Override
    public void delete(Book book) {
        bookRepo.delete(book);
    }

}
