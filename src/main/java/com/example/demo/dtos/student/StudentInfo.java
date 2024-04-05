package com.example.demo.dtos.student;

import com.fasterxml.jackson.annotation.JsonProperty;

public record StudentInfo(
        @JsonProperty("id") Integer id,
        @JsonProperty("student_name") String studentName,
        @JsonProperty("school_id") Integer schoolId,
        @JsonProperty("school_address") String schoolAddress,
        @JsonProperty("student_gpa") Double studentGpa,
        @JsonProperty("student_grade") String studentGrade
        ) {
}
