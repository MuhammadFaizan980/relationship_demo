package com.example.demo.dtos.student;

import com.example.demo.entities.School;
import com.example.demo.entities.Student;
import com.fasterxml.jackson.annotation.JsonProperty;

public record StudentRequest(@JsonProperty("first_name") String firstName, @JsonProperty("last_name") String lastName,
                             @JsonProperty("age") int studentAge, @JsonProperty("school_id") int schoolId) {
}
