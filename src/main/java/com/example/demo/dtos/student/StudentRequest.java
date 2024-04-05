package com.example.demo.dtos.student;

import com.example.demo.entities.School;
import com.example.demo.entities.Student;
import com.fasterxml.jackson.annotation.JsonProperty;

public record StudentRequest(@JsonProperty("first_name") String firstName, @JsonProperty("last_name") String lastName,
                             @JsonProperty("age") int studentAge, @JsonProperty("school_id") int schoolId) {
    public Student toStudent() {
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setAge(studentAge);

        School school = new School();
        school.setId(schoolId);

        student.setSchool(school);

        return student;
    }
}
