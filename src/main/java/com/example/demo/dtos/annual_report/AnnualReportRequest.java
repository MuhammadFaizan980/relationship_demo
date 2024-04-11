package com.example.demo.dtos.annual_report;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AnnualReportRequest(@JsonProperty("grade") String studentGrade, @JsonProperty("gpa") double studentGpa) {
}
