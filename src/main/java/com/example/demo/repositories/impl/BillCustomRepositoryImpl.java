package com.example.demo.repositories.impl;

import com.example.demo.models.db.Bill;
import com.example.demo.models.requests.expense.FilterRequest;
import com.example.demo.models.responses.FilterResponse;
import com.example.demo.repositories.BillCustomRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;

public class BillCustomRepositoryImpl implements BillCustomRepository {
	@PersistenceContext
    private EntityManager entityManager;


	@Override
	public FilterResponse<Bill> filter(FilterRequest filterRequest) {
		String countQuery = "SELECT count(*) as count from Bill";
		long totalCount = (long) entityManager.createQuery(countQuery).getSingleResult();

		String query = "from Bill order by billDate desc, id desc";
		List<Bill> list = (List<Bill>) entityManager.createQuery(query).getResultList();

		FilterResponse<Bill> response = new FilterResponse<>();
		response.setTotalCount(totalCount);
		response.setList(list);

		return response;
	}
}