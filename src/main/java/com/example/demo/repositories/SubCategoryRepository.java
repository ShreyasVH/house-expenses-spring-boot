package com.example.demo.repositories;

import com.example.demo.models.db.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoryRepository  extends JpaRepository<SubCategory, Long> {
}
