package com.example.demo.mappers;

import com.example.demo.dtos.annual_report.AnnualReportInfo;
import com.example.demo.dtos.annual_report.AnnualReportRequest;
import com.example.demo.dtos.annual_report.AnnualReportResponse;
import com.example.demo.entities.AnnualReport;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class AnnualReportMapper {
    public AnnualReportResponse<List<AnnualReportInfo>> toAnnualReportListResponse(List<AnnualReportInfo> annualReportInfos) {
        return new AnnualReportResponse<>(true, "Success", annualReportInfos);
    }

    public AnnualReportResponse<AnnualReportInfo> toAnnualReportResponse(AnnualReportInfo annualReportInfo) {
        return new AnnualReportResponse<>(true, "Success", annualReportInfo);
    }

    public List<AnnualReportInfo> toAnnualReportInfosList(List<AnnualReport> annualReports) {
        List<AnnualReportInfo> annualReportInfos = new LinkedList<AnnualReportInfo>();
        for (AnnualReport i : annualReports) {
            AnnualReportInfo info = new AnnualReportInfo(i.getId(), i.getStudentGpa(), i.getStudentGrade());
            annualReportInfos.add(info);
        }
        return annualReportInfos;
    }

    public AnnualReportInfo toAnnualReportInfo(AnnualReport annualReport) {
        return new AnnualReportInfo(annualReport.getId(), annualReport.getStudentGpa(), annualReport.getStudentGrade());
    }

    public AnnualReport toAnnualReport(AnnualReportRequest annualReportRequest) {
        AnnualReport annualReport = new AnnualReport();
        annualReport.setStudentGrade(annualReportRequest.studentGrade());
        annualReport.setStudentGpa(annualReportRequest.studentGpa());
        return annualReport;
    }
}
