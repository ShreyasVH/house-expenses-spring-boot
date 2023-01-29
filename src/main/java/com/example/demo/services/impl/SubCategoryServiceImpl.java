package com.example.demo.services.impl;

import com.example.demo.models.db.SubCategory;
import com.example.demo.models.requests.subCategory.CreateRequest;
import com.example.demo.repositories.SubCategoryRepository;
import com.example.demo.services.SubCategoryService;
import com.example.demo.utils.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    public SubCategory create(CreateRequest createRequest) {
        SubCategory subCategory = Utils.convertObject(createRequest, SubCategory.class);
        return subCategoryRepository.save(subCategory);
    }

    public List<SubCategory> getAll() {
        return subCategoryRepository.findAll();
    }
}
