package com.example.demo.dtos.student;

import com.example.demo.base_responses.ApiResponse;

public class StudentResponse<T> extends ApiResponse<T> {

    public StudentResponse(boolean success, String message, T data) {
        super(success, message, data);
    }
}
