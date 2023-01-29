package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.services.BillService;
import com.example.demo.services.ExpenseService;

import com.example.demo.models.db.Bill;
import com.example.demo.models.requests.bill.CreateRequest;
import com.example.demo.models.requests.expense.FilterRequest;
import com.example.demo.models.responses.Response;
import com.example.demo.models.responses.FilterResponse;
import com.example.demo.models.responses.BillResponse;
import com.example.demo.utils.Utils;

@RestController
public class BillController {
    @Autowired
    private BillService billService;

    @Autowired
    private ExpenseService expenseService;

    @RequestMapping(value = "/v1/bills", method = RequestMethod.POST)
    public Response<Bill> create(@RequestBody CreateRequest createRequest) {
        Bill bill = billService.create(createRequest);
        return new Response<Bill>(true, bill);
    }

    @RequestMapping(value = "/v1/bills/filter", method = RequestMethod.POST)
    public Response<FilterResponse<Bill>> create(@RequestBody FilterRequest filterRequest) {
        FilterResponse<Bill> bills = billService.filter(filterRequest);
        return new Response<FilterResponse<Bill>>(true, bills);
    }

    @RequestMapping(value = "/v1/bills/{id}", method = RequestMethod.GET)
    public Response<BillResponse> get(@PathVariable Long id) {
        Bill bill = billService.get(id);
        BillResponse billResponse = Utils.convertObject(bill, BillResponse.class);
        billResponse.setExpenses(expenseService.getExpenseForBill(id));
        return new Response<>(true, billResponse);
    }
}
