package com.example.demo.controller;

import com.example.demo.base_responses.ApiResponse;
import com.example.demo.dtos.annual_report.AnnualReportInfo;
import com.example.demo.dtos.annual_report.AnnualReportRequest;
import com.example.demo.services.AnnualReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnnualReportController {
    @Autowired
    private AnnualReportService annualReportService;

    @PostMapping("/reports")
    public ApiResponse<AnnualReportInfo> create(@RequestBody AnnualReportRequest annualReportRequest) {
        return annualReportService.createAnnualReport(annualReportRequest);
    }

    @GetMapping("/reports")
    public ApiResponse<List<AnnualReportInfo>> get() {
        return annualReportService.getAllAnnualReports();
    }
}
