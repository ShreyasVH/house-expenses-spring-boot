package com.example.demo.controllers;

import com.example.demo.models.db.Bill;
import com.example.demo.models.responses.ExpenseResponse;
import com.example.demo.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.services.ExpenseService;

import com.example.demo.models.db.Expense;
import com.example.demo.models.requests.expense.CreateRequest;
import com.example.demo.models.requests.expense.FilterRequest;
import com.example.demo.models.responses.Response;
import com.example.demo.models.responses.FilterResponse;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @Autowired
    private BillService billService;

    @RequestMapping(value = "/v1/expenses", method = RequestMethod.POST)
    public Response<Expense> create(@RequestBody CreateRequest createRequest) {
        Expense expense = expenseService.create(createRequest);
        return new Response<Expense>(true, expense);
    }
    
    @RequestMapping(value = "/v1/expenses/filter", method = RequestMethod.POST)
    public Response<FilterResponse<ExpenseResponse>> filter(@RequestBody FilterRequest filterRequest) {
        FilterResponse<ExpenseResponse> response = expenseService.filter(filterRequest);
        List<Integer> billIds = response.getList().stream().map(ExpenseResponse::getBillId).collect(Collectors.toList());
        Map<Integer, Bill> billMap = billService.get(billIds).stream(). collect(Collectors.toMap(Bill::getId, bill -> bill));
        response.getList().forEach(expenseResponse -> {
            expenseResponse.setBill(billMap.get(expenseResponse.getBillId()));
        });


        return new Response<>(true, response);
    }
}
