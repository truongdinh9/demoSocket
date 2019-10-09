package com.example.demorelationship.service.impl;

import com.example.demorelationship.model.Category;
import com.example.demorelationship.repo.CategoryRepo;
import com.example.demorelationship.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepo categoryRepo;
    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Category findById(UUID id) {
        Optional<Category> optionalCategory = categoryRepo.findById(id);
        return optionalCategory.orElse(null);
    }
    @Override
    public void save(Category category) {
        categoryRepo.save(category);
    }

    @Override
    public void delete(Category category) {

        categoryRepo.delete(category);

    }
}
