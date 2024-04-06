package com.example.demo.dtos.course;

import com.example.demo.base_responses.ApiResponse;

public class CourseResponse<T> extends ApiResponse<T> {
    public CourseResponse(boolean success, String message, T data) {
        super(success, message, data);
    }
}
