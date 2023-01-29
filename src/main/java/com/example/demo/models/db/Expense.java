package com.example.demo.models.db;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Table
@Entity
@NoArgsConstructor
@Data
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    
    @Column
    private Integer amount;

    @Column
    private Integer billId;

    @Column
    private String receipt;

    @Column
    private LocalDate receiptDate;

    @Column
    private String payer;

    @Column
    private String mode;
}
