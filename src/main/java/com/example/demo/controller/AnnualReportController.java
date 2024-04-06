package com.example.demo.controller;

import com.example.demo.base_responses.ApiErrorResponse;
import com.example.demo.base_responses.ApiResponse;
import com.example.demo.dtos.annual_report.AnnualReportInfo;
import com.example.demo.dtos.annual_report.AnnualReportResponse;
import com.example.demo.entities.AnnualReport;
import com.example.demo.repositories.IAnnualReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class AnnualReportController {
    @Autowired
    private IAnnualReportRepository iAnnualReportRepository;

    @PostMapping("/reports")
    public ApiResponse<AnnualReportInfo> create(@RequestBody AnnualReport annualReport) {
        try {
            AnnualReport report = iAnnualReportRepository.save(annualReport);
            AnnualReportInfo info = new AnnualReportInfo(report.getId(), report.getStudentGpa(), report.getStudentGrade());
            return new AnnualReportResponse<>(true, "success", info);
        } catch (Exception e) {
            return new ApiErrorResponse<>(e.getMessage());
        }
    }

    @GetMapping("/reports")
    public ApiResponse<List<AnnualReportInfo>> get() {
        try {
            List<AnnualReport> reports = iAnnualReportRepository.findAll();
            List<AnnualReportInfo> annualReportInfos = new LinkedList<AnnualReportInfo>();
            for (AnnualReport i : reports) {
                AnnualReportInfo info = new AnnualReportInfo(i.getId(), i.getStudentGpa(), i.getStudentGrade());
                annualReportInfos.add(info);
            }
            return new AnnualReportResponse<>(true, "Success", annualReportInfos);
        } catch (Exception e) {
            return new ApiErrorResponse<>(e.getMessage());
        }
    }
}
