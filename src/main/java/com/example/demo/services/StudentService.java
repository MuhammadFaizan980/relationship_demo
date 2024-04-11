package com.example.demo.services;

import com.example.demo.base_responses.ApiErrorResponse;
import com.example.demo.base_responses.ApiResponse;
import com.example.demo.dtos.student.StudentInfo;
import com.example.demo.dtos.student.StudentRequest;
import com.example.demo.dtos.student.StudentResponse;
import com.example.demo.entities.AnnualReport;
import com.example.demo.entities.Course;
import com.example.demo.entities.Student;
import com.example.demo.mappers.CourseMapper;
import com.example.demo.mappers.StudentMapper;
import com.example.demo.repositories.IAnnualReportRepository;
import com.example.demo.repositories.ISchoolRepository;
import com.example.demo.repositories.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private IStudentRepository iStudentRepository;
    @Autowired
    private ISchoolRepository iSchoolRepository;
    @Autowired
    private IAnnualReportRepository iAnnualReportRepository;

    public ApiResponse<StudentInfo> createNewStudent(StudentRequest studentRequest) {
        try {
            Student student = iStudentRepository.save(studentMapper.toStudent(studentRequest));
            return studentMapper.toStudentResponse(studentMapper.toStudentInfo(student));
        } catch (Exception e) {
            return new ApiErrorResponse<>(e.getMessage());
        }
    }

    public ApiResponse<List<StudentInfo>> getAllStudents() {
        try {
            List<Student> students = iStudentRepository.findAll();
            return studentMapper.toStudentListResponse(studentMapper.toStudentsInfoList(students));
        } catch (Exception e) {
            return new ApiErrorResponse<>(e.getMessage());
        }
    }

    public ApiResponse<List<StudentInfo>> getAllStudentsForSchool(int schoolId) {
        try {
            List<Student> students = iStudentRepository.findAllBySchoolId(schoolId);
            return studentMapper.toStudentListResponse(studentMapper.toStudentsInfoList(students));
        } catch (Exception e) {
            return new ApiErrorResponse<>(e.getMessage());
        }
    }

    public ApiResponse<StudentInfo> updateStudentReport(int studentId, int reportId) {
        try {
            Student student = iStudentRepository.findById(studentId).get();
            AnnualReport annualReport = new AnnualReport();
            annualReport.setId(reportId);
            student.setAnnualReport(annualReport);
            iStudentRepository.save(student);

            return studentMapper.toStudentResponse(studentMapper.toStudentInfo(student));
        } catch (Exception e) {
            return new ApiErrorResponse<>(e.getMessage());
        }
    }

    public ApiResponse<StudentInfo> updateStudentCourses(int studentId, List<Integer> coursesIds) {
        try {
            Student student = iStudentRepository.findById(studentId).get();
            List<Course> courses = courseMapper.toCoursesListFromCoursesIdsList(coursesIds);
            student.setCourses(courses);
            iStudentRepository.save(student);

            return studentMapper.toStudentResponse(studentMapper.toStudentInfo(student));
        } catch (Exception e) {
            return new ApiErrorResponse<>(e.getMessage());
        }
    }

    public ApiResponse<StudentInfo> deleteStudent(int studentId) {
        try {
            iStudentRepository.deleteById(studentId);
            return new StudentResponse<>(true, "Student deleted successfully", null);
        } catch (Exception e) {
            return new ApiErrorResponse<>(e.getMessage());
        }
    }
}
