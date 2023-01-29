package com.example.demo.models.requests.expense;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FilterRequest {
	private int offset;
	private int count;
}