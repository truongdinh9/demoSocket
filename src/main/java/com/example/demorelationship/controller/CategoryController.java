package com.example.demorelationship.controller;

import com.example.demorelationship.model.Category;
import com.example.demorelationship.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping
    public ResponseEntity<List<Category>>getAllCategory(){
        List<Category> categories =categoryService.findAll();
//        Category category = new Category();
//        category.setName("maee");
//        categoryService.save(category);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Category>getAllCategory(@PathVariable String id){
        UUID uuid = UUID.fromString(id);
      Category category= categoryService.findById(uuid);
      return new ResponseEntity<Category>(category, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteBook(@PathVariable String id) {
        UUID categoryId = UUID.fromString(id);
        Category category = categoryService.findById(categoryId);
        if (category ==null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        if (!category.getBooks().isEmpty()) {
           category.getBooks().forEach(book -> book.setCategory(null));
        }
        categoryService.delete(category);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
