package com.example.demorelationship.service;

import com.example.demorelationship.model.Book;
import com.example.demorelationship.model.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
   List<Category>  findAll();
   Category findById(UUID id);
   void save( Category category);
   void delete(Category category);

}
