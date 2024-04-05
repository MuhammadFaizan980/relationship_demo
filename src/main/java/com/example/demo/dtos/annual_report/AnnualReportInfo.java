package com.example.demo.dtos.annual_report;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AnnualReportInfo(int id, @JsonProperty("gpa") Double studentGpa,
                               @JsonProperty("grade") String studentGrads) {
}
