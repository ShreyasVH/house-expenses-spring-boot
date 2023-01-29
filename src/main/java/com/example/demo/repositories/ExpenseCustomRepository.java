package com.example.demo.repositories;

import com.example.demo.models.db.Expense;
import com.example.demo.models.requests.expense.FilterRequest;
import com.example.demo.models.responses.ExpenseResponse;
import com.example.demo.models.responses.FilterResponse;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseCustomRepository {
	FilterResponse<ExpenseResponse> filter(FilterRequest filterRequest);
}
