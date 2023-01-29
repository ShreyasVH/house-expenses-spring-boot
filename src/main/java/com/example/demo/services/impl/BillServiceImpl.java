package com.example.demo.services.impl;

import com.example.demo.repositories.BillRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.utils.Utils;

import com.example.demo.services.BillService;
import com.example.demo.models.requests.bill.CreateRequest;
import com.example.demo.models.db.Bill;

import com.example.demo.models.requests.expense.FilterRequest;
import com.example.demo.models.responses.FilterResponse;

import java.util.List;

@Service
public class BillServiceImpl implements BillService {
	@Autowired
	private BillRepository billRepository;

	@Override
	public Bill create(CreateRequest createRequest) {
		Bill bill = Utils.convertObject(createRequest, Bill.class);

		return billRepository.save(bill);
	}

	@Override
	public FilterResponse<Bill> filter(FilterRequest filterRequest) {
		return billRepository.filter(filterRequest);
	}

	@Override
	public Bill get(Long id) {
		return billRepository.findById(id.intValue()).orElse(null);
	}

    @Override
    public List<Bill> get(List<Integer> ids) {
        return billRepository.findAllById(ids);
    }
}