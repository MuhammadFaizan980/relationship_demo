package com.example.demo.dtos.course;

import com.example.demo.entities.Student;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record CourseInfo(int id, @JsonProperty("title") String courseTitle,
                         @JsonProperty("students") @JsonIgnoreProperties("courses") List<Student> enrolledStudent) {
}
