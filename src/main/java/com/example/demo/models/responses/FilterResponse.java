package com.example.demo.models.responses;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
public class FilterResponse<T> {
	private long totalCount;
	private List<T> list;
}