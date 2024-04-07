package com.example.demo.controller;

import com.example.demo.base_responses.ApiResponse;
import com.example.demo.dtos.course.CourseInfo;
import com.example.demo.dtos.course.CourseRequest;
import com.example.demo.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/courses")
    public ApiResponse<CourseInfo> create(@RequestBody CourseRequest courseRequest) {
        return courseService.saveCourse(courseRequest);
    }

    @GetMapping("/courses")
    public ApiResponse<List<CourseInfo>> get() {
        return courseService.getAllCourses();
    }
}
