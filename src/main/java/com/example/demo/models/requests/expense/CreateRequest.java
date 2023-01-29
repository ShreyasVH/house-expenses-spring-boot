package com.example.demo.models.requests.expense;

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
    
    private Integer amount;

    private Integer billId;

    private String receipt;

	@JsonFormat(pattern = "yyyy-MM-dd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate receiptDate;

    private String payer;

    private String mode;
}