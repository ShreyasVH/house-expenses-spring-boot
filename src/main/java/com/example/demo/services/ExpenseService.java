package com.example.demo.services;

import java.util.List;

import com.example.demo.models.requests.expense.CreateRequest;
import com.example.demo.models.requests.expense.FilterRequest;
import com.example.demo.models.db.Expense;
import com.example.demo.models.responses.ExpenseResponse;
import com.example.demo.models.responses.FilterResponse;

public interface ExpenseService {
	Expense create(CreateRequest createRequest);
	FilterResponse<ExpenseResponse> filter(FilterRequest filterRequest);
	List<Expense> getExpenseForBill(Long billId);
}