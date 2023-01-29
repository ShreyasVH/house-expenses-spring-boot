package com.example.demo.controllers;

import com.example.demo.models.db.Category;
import com.example.demo.models.requests.category.CreateRequest;
import com.example.demo.services.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/v1/categories", method = RequestMethod.POST)
    public Category create(@RequestBody CreateRequest createRequest) {
        return categoryService.create(createRequest);
    }

    @RequestMapping(value = "/v1/categories", method = RequestMethod.GET)
    public List<Category> getAll() {
        return categoryService.getAll();
    }
}
