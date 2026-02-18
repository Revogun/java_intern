package com.example.expense_tracker.controller;


import com.example.expense_tracker.model.Category;
import com.example.expense_tracker.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/{userId}")
    public List<Category> getUserCategories(@PathVariable Long userId) {
        return categoryRepository.findByUserId(userId);
    }

    @PostMapping
    public Category addCategory(@RequestBody Category category) {
        return categoryRepository.save(category);
    }
}

