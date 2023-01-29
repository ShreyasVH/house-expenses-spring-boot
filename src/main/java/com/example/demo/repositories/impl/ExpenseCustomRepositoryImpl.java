package com.example.demo.repositories.impl;

import com.example.demo.models.db.Expense;
import com.example.demo.models.requests.expense.FilterRequest;
import com.example.demo.models.responses.ExpenseResponse;
import com.example.demo.models.responses.FilterResponse;
import com.example.demo.repositories.ExpenseCustomRepository;
import com.example.demo.utils.Utils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;

public class ExpenseCustomRepositoryImpl implements ExpenseCustomRepository {
	@PersistenceContext
    private EntityManager entityManager;


	@Override
	public FilterResponse<ExpenseResponse> filter(FilterRequest filterRequest) {
		// CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		// CriteriaQuery<Expense> query = cb.createQuery(Expense.class);
		// Root<Expense> expense = query.from(Expense.class);
		// query.select(expense);

		String countQuery = "SELECT count(*) as count from Expense";
		long totalCount = (long) entityManager.createQuery(countQuery).getSingleResult();

		// List<Expense> list = entityManager.createQuery(query).getResultList();

		String query = "from Expense order by receiptDate desc, id desc";
		// String query = "from Expense";
		List<Expense> list = (List<Expense>) entityManager.createQuery(query).getResultList();

		FilterResponse<ExpenseResponse> response = new FilterResponse<>();
		response.setTotalCount(totalCount);
		response.setList(Utils.convertObjectList(list, ExpenseResponse.class));

		return response;
	}
}