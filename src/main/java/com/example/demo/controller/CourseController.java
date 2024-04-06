package com.example.demo.controller;

import com.example.demo.base_responses.ApiErrorResponse;
import com.example.demo.base_responses.ApiResponse;
import com.example.demo.dtos.course.CourseInfo;
import com.example.demo.dtos.course.CourseRequest;
import com.example.demo.dtos.course.CourseResponse;
import com.example.demo.entities.Course;
import com.example.demo.repositories.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private ICourseRepository iCourseRepository;

    @PostMapping("/courses")
    public ApiResponse<CourseInfo> create(@RequestBody CourseRequest courseRequest) {
        try {
            Course course = iCourseRepository.save(courseRequest.toCourse());
            CourseInfo courseInfo = new CourseInfo(course.getId(), course.getCourseTitle(), course.getStudents());
            return new CourseResponse<>(true, "Course created successfully", courseInfo);
        } catch (Exception e) {
            return new ApiErrorResponse<>(e.getMessage());
        }
    }

    @GetMapping("/courses")
    public ApiResponse<List<CourseInfo>> get() {
        try {
            List<Course> courseList = iCourseRepository.findAll();
            List<CourseInfo> courseInfos = new LinkedList<>();
            courseList.forEach(course -> {
                CourseInfo info = new CourseInfo(course.getId(), course.getCourseTitle(), course.getStudents());
                courseInfos.add(info);
            });
            return new CourseResponse<>(true, "Success", courseInfos);
        } catch (Exception e) {
            return new ApiErrorResponse<>(e.getMessage());
        }
    }
}
