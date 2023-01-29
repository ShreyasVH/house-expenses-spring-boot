package com.example.demo.models.responses;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Response<T> {
    private boolean success;
    private T data;
    private String message;

    public Response(boolean success, T data) {
        this.success = success;
        this.data = data;
    }
}
