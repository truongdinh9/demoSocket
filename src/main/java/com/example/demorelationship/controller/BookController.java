package com.example.demorelationship.controller;

import com.example.demorelationship.model.Book;
import com.example.demorelationship.model.Category;
import com.example.demorelationship.service.BookService;
import com.example.demorelationship.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    BookService bookService;
    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Book>> getallBooks() {
//        Book book = new Book();
//        book.setName("adsa");
//        Category category = categoryService.findAll().get(0);
//        book.setCategory(category);
//        category.getBooks().add(book);
//        bookService.save(book);
//        categoryService.save(category);
        List<Book> books = bookService.findAll();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteBook(@PathVariable String id) {
        UUID bookId = UUID.fromString(id);
        Book book = bookService.findById(bookId);
        if (book ==null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        if (book.getCategory() != null) {
            book.getCategory().getBooks().remove(book);
        }
        bookService.delete(book);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable String id) {
        UUID bookId = UUID.fromString(id);
        Book book = bookService.findById(bookId);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

}
