package com.example.demo.models.responses;

import com.example.demo.models.db.Bill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseResponse {
    private Long id;
    private Integer amount;
    private Integer billId;
    private String receipt;
    private LocalDate receiptDate;
    private String payer;
    private String mode;
    private Bill bill;
}
