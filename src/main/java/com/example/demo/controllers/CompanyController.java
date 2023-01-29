package com.example.demo.controllers;

import com.example.demo.models.db.Company;
import com.example.demo.models.requests.company.CreateRequest;
import com.example.demo.services.CompanyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/v1/companies", method = RequestMethod.POST)
    public Company create(@RequestBody CreateRequest createRequest) {
        return companyService.create(createRequest);
    }

    @RequestMapping(value = "/v1/companies", method = RequestMethod.GET)
    public List<Company> getAll() {
        return companyService.getAll();
    }
}
