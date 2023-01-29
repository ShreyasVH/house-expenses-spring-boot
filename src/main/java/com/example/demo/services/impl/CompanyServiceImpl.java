package com.example.demo.services.impl;

import com.example.demo.models.db.Company;
import com.example.demo.models.requests.company.CreateRequest;
import com.example.demo.repositories.CompanyRepository;
import com.example.demo.services.CompanyService;
import com.example.demo.utils.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public Company create(CreateRequest createRequest) {
        Company company = Utils.convertObject(createRequest, Company.class);
        return companyRepository.save(company);
    }

    public List<Company> getAll() {
        return companyRepository.findAll();
    }
}
