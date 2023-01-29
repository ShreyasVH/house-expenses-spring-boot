package com.example.demo.repositories;

import com.example.demo.models.db.Bill;
import com.example.demo.models.requests.expense.FilterRequest;
import com.example.demo.models.responses.FilterResponse;
import org.springframework.stereotype.Repository;

@Repository
public interface BillCustomRepository {
	FilterResponse<Bill> filter(FilterRequest filterRequest);
}
