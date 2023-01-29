package com.example.demo.services;

import com.example.demo.models.db.Category;
import com.example.demo.models.requests.category.CreateRequest;

import java.util.List;

public interface CategoryService {
    Category create(CreateRequest createRequest);
    List<Category> getAll();
}
