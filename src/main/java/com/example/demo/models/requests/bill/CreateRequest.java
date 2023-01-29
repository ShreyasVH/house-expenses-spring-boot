package com.example.demo.models.requests.bill;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

@Data
@NoArgsConstructor
public class CreateRequest {
    private Long id;

    private String name;

    private Integer amount;

    private String billDoc;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate billDate;

    private Integer categoryId;

    private Integer subCategoryId;

    private Integer companyId;
}