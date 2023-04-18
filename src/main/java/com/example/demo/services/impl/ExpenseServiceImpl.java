package com.example.demo.services.impl;

import java.util.List;

import com.example.demo.models.requests.expense.FilterRequest;
import com.example.demo.models.responses.ExpenseResponse;
import com.example.demo.models.responses.FilterResponse;
import com.example.demo.repositories.ExpenseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.utils.Utils;

import com.example.demo.services.ExpenseService;
import com.example.demo.models.requests.expense.CreateRequest;
import com.example.demo.models.db.Expense;

@Service
public class ExpenseServiceImpl implements ExpenseService {
	@Autowired
	private ExpenseRepository expenseRepository;

	@Override
	public Expense create(CreateRequest createRequest) {
		Expense expense = Utils.convertObject(createRequest, Expense.class);

		return expenseRepository.save(expense);
	}

	@Override
	public FilterResponse<ExpenseResponse> filter(FilterRequest filterRequest) {
		return expenseRepository.filter(filterRequest);
	}

	@Override
	public List<Expense> getExpenseForBill(Long billId) {
		return expenseRepository.findAllByBillIdOrderByReceiptDateDesc(billId);
	}
}