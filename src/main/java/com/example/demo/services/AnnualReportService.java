package com.example.demo.services;

import com.example.demo.base_responses.ApiErrorResponse;
import com.example.demo.base_responses.ApiResponse;
import com.example.demo.dtos.annual_report.AnnualReportInfo;
import com.example.demo.dtos.annual_report.AnnualReportRequest;
import com.example.demo.entities.AnnualReport;
import com.example.demo.mappers.AnnualReportMapper;
import com.example.demo.repositories.IAnnualReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnualReportService {
    @Autowired
    private AnnualReportMapper annualReportMapper;
    @Autowired
    private IAnnualReportRepository iAnnualReportRepository;

    public ApiResponse<AnnualReportInfo> createAnnualReport(AnnualReportRequest annualReportRequest) {
        try {
            AnnualReport annualReport = annualReportMapper.toAnnualReport(annualReportRequest);
            iAnnualReportRepository.save(annualReport);
            return annualReportMapper.toAnnualReportResponse(annualReportMapper.toAnnualReportInfo(annualReport));
        } catch (Exception e) {
            return new ApiErrorResponse<>(e.getMessage());
        }
    }

    public ApiResponse<List<AnnualReportInfo>> getAllAnnualReports() {
        try {
            List<AnnualReport> reports = iAnnualReportRepository.findAll();
            return annualReportMapper.toAnnualReportListResponse(annualReportMapper.toAnnualReportInfosList(reports));
        } catch (Exception e) {
            return new ApiErrorResponse<>(e.getMessage());
        }
    }
}
