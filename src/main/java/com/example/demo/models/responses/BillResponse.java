package com.example.demo.models.responses;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.models.db.Expense;

@Data
@NoArgsConstructor
public class BillResponse {
    private Long id;
    private String name;
    private Integer amount;
    private String billDoc;
    private LocalDate billDate;
    private Integer categoryId;
    private Integer subCategoryId;
    private Integer companyId;
    private List<Expense> expenses;
}
