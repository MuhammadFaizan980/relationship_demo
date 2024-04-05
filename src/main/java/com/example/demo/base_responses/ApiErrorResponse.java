package com.example.demo.base_responses;

public class ApiErrorResponse<T> extends ApiResponse<T> {

    public ApiErrorResponse(boolean success, String message) {
        super(success, message, null);
    }
}
