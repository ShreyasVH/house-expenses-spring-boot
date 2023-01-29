package com.example.demo.services.impl;

import com.example.demo.models.db.Category;
import com.example.demo.models.requests.category.CreateRequest;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.services.CategoryService;
import com.example.demo.utils.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category create(CreateRequest createRequest) {
        Category category = Utils.convertObject(createRequest, Category.class);
        return categoryRepository.save(category);
    }

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
}
