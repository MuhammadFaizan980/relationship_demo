package com.example.demo.controller;

import com.example.demo.base_responses.ApiResponse;
import com.example.demo.dtos.student.StudentInfo;
import com.example.demo.dtos.student.StudentRequest;
import com.example.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/students")
    public ApiResponse<StudentInfo> create(@RequestBody StudentRequest studentRequest) {
        return studentService.createNewStudent(studentRequest);
    }

    @GetMapping("/students")
    public ApiResponse<List<StudentInfo>> get() {
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{school_id}")
    public ApiResponse<List<StudentInfo>> getAllForSchool(@PathVariable("school_id") int schoolId) {
        return studentService.getAllStudentsForSchool(schoolId);
    }

    @PutMapping("/students/{student_id}")
    public ApiResponse<StudentInfo> update(@PathVariable("student_id") int studentId, @RequestParam("report_id") int reportId) {
        return studentService.updateStudentReport(studentId, reportId);
    }

    @PutMapping("/students/courses/{student_id}")
    public ApiResponse<StudentInfo> update(@PathVariable("student_id") int studentId, @RequestBody List<Integer> coursesIds) {
        return studentService.updateStudentCourses(studentId, coursesIds);
    }

    @DeleteMapping("/students/{student_id}")
    public ApiResponse<StudentInfo> delete(@PathVariable("student_id") int studentId) {
        return studentService.deleteStudent(studentId);
    }
}
