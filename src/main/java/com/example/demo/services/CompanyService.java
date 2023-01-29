package com.example.demo.services;

import com.example.demo.models.db.Company;
import com.example.demo.models.requests.company.CreateRequest;

import java.util.List;

public interface CompanyService {
    Company create(CreateRequest createRequest);
    List<Company> getAll();
}
