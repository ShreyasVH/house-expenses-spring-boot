package com.example.demo.services;

import com.example.demo.models.db.SubCategory;
import com.example.demo.models.requests.subCategory.CreateRequest;

import java.util.List;

public interface SubCategoryService {
    SubCategory create(CreateRequest createRequest);
    List<SubCategory> getAll();
}
