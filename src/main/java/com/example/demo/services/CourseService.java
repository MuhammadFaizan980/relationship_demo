package com.example.demo.services;

import com.example.demo.base_responses.ApiErrorResponse;
import com.example.demo.base_responses.ApiResponse;
import com.example.demo.dtos.course.CourseInfo;
import com.example.demo.dtos.course.CourseRequest;
import com.example.demo.entities.Course;
import com.example.demo.mappers.CourseMapper;
import com.example.demo.repositories.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private ICourseRepository iCourseRepository;
    @Autowired
    private CourseMapper courseMapper;

    public ApiResponse<CourseInfo> saveCourse(CourseRequest courseRequest) {
        try {
            Course course = iCourseRepository.save(courseMapper.toCourse(courseRequest));
            return courseMapper.toCourseResponse(courseMapper.toCourseInfo(course));
        } catch (Exception e) {
            return new ApiErrorResponse<>(e.getMessage());
        }
    }

    public ApiResponse<List<CourseInfo>> getAllCourses() {
        try {
            List<Course> courseList = iCourseRepository.findAll();
            return courseMapper.toCourseListResponse(courseMapper.toCoursesInfoList(courseList));
        } catch (Exception e) {
            return new ApiErrorResponse<>(e.getMessage());
        }
    }
}
