package com.example.demo.dtos.annual_report;

import com.example.demo.base_responses.ApiResponse;

public class AnnualReportResponse<T> extends ApiResponse<T> {
    public AnnualReportResponse(boolean success, String message, T data) {
        super(success, message, data);
    }
}
