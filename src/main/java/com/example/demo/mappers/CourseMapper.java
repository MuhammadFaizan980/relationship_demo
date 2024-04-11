package com.example.demo.mappers;

import com.example.demo.dtos.course.CourseInfo;
import com.example.demo.dtos.course.CourseRequest;
import com.example.demo.dtos.course.CourseResponse;
import com.example.demo.entities.Course;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CourseMapper {

    public CourseResponse<CourseInfo> toCourseResponse(CourseInfo courseInfo) {
        return new CourseResponse<>(true, "Success", courseInfo);
    }

    public CourseResponse<List<CourseInfo>> toCourseListResponse(List<CourseInfo> coursesInfoList) {
        return new CourseResponse<>(true, "Success", coursesInfoList);
    }

    public List<CourseInfo> toCoursesInfoList(List<Course> courseList) {
        List<CourseInfo> coursesInfoList = new LinkedList<>();
        courseList.forEach(course -> {
            CourseInfo info = new CourseInfo(course.getId(), course.getCourseTitle(), course.getStudents());
            coursesInfoList.add(info);
        });
        return coursesInfoList;
    }

    public Course toCourse(CourseRequest courseRequest) {
        Course course = new Course();
        course.setCourseTitle(courseRequest.courseTitle());
        course.setStudents(courseRequest.enrolledStudents());
        return course;
    }

    public CourseInfo toCourseInfo(Course course) {
        return new CourseInfo(course.getId(), course.getCourseTitle(), course.getStudents());
    }

    public List<Course> toCoursesListFromCoursesIdsList(List<Integer> coursesIds) {
        List<Course> courses = new LinkedList<>();
        coursesIds.forEach(courseId -> {
            Course course = new Course();
            course.setId(courseId);
            courses.add(course);
        });
        return courses;
    }
}
