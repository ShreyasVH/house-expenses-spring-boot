package com.example.demo.models.db;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Data;

@Table(name = "category")
@Entity
@Data
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;
}
