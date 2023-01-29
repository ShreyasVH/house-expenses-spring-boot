package com.example.demo.repositories;

import com.example.demo.models.db.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer>, BillCustomRepository {
}