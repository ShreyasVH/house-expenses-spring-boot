package com.example.demo.repositories;

import java.util.List;

import com.example.demo.models.db.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long>, ExpenseCustomRepository {
	List<Expense> findAllByBillIdOrderByReceiptDateDesc(Long billId);
}