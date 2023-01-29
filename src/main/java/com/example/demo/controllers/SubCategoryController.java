package com.example.demo.controllers;

import com.example.demo.models.db.SubCategory;
import com.example.demo.models.requests.subCategory.CreateRequest;
import com.example.demo.services.SubCategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubCategoryController {

    @Autowired
    private SubCategoryService subCategoryService;

    @RequestMapping(value = "/v1/sub-categories", method = RequestMethod.POST)
    public SubCategory create(@RequestBody CreateRequest createRequest) {
        return subCategoryService.create(createRequest);
    }

    @RequestMapping(value = "/v1/sub-categories", method = RequestMethod.GET)
    public List<SubCategory> getAll() {
        return subCategoryService.getAll();
    }
}
