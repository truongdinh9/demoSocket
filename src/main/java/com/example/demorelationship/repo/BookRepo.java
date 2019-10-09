package com.example.demorelationship.repo;

import com.example.demorelationship.model.Book;
import com.example.demorelationship.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
@Transactional
public interface BookRepo extends JpaRepository<Book, UUID> {
    List<Book> findAllByCategory(Category category);

}
