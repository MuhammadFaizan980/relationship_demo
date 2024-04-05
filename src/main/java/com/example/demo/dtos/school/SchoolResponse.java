package com.example.demo.dtos.school;

import com.example.demo.base_responses.ApiResponse;

public class SchoolResponse<T> extends ApiResponse<T> {
    public SchoolResponse(boolean success, String message, T data) {
        super(success, message, data);
    }
}
