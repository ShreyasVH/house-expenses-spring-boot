package com.example.demo.services;

import com.example.demo.models.db.Bill;
import com.example.demo.models.requests.bill.CreateRequest;
import com.example.demo.models.requests.expense.FilterRequest;
import com.example.demo.models.responses.FilterResponse;
import com.example.demo.models.responses.BillResponse;

import java.util.List;

public interface BillService {
    Bill create(CreateRequest createRequest);
    FilterResponse<Bill> filter(FilterRequest filterRequest);
    Bill get(Long id);
    List<Bill> get(List<Integer> ids);
}