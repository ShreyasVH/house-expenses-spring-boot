package com.example.demo.models.db;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table
@Entity
@NoArgsConstructor
@Data
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String name;

    @Column
    private Integer amount;

    @Column
    private String billDoc;

    @Column
    private LocalDate billDate;

    @Column
    private Integer categoryId;

    @Column
    private Integer subCategoryId;

    @Column
    private Integer companyId;
}
