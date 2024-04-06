package com.example.demo.base_responses;

public class ApiErrorResponse<T> extends ApiResponse<T> {

    public ApiErrorResponse(String message) {
        super(false, message, null);
    }
}
