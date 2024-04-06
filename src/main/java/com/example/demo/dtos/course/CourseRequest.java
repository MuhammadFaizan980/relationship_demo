package com.example.demo.dtos.course;

import com.example.demo.entities.Course;
import com.example.demo.entities.Student;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record CourseRequest(@JsonProperty("title") String courseTitle,
                            @JsonProperty("students") List<Student> enrolledStudents) {

    public Course toCourse() {
        Course course = new Course();
        course.setCourseTitle(courseTitle);
        course.setStudents(enrolledStudents);
        return course;
    }
}
