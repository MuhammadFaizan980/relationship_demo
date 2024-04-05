package com.example.demo.controller;

import com.example.demo.base_responses.ApiErrorResponse;
import com.example.demo.base_responses.ApiResponse;
import com.example.demo.dtos.student.StudentInfo;
import com.example.demo.dtos.student.StudentRequest;
import com.example.demo.dtos.student.StudentResponse;
import com.example.demo.entities.AnnualReport;
import com.example.demo.entities.School;
import com.example.demo.entities.Student;
import com.example.demo.repositories.IAnnualReportRepository;
import com.example.demo.repositories.ISchoolRepository;
import com.example.demo.repositories.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private IStudentRepository iStudentRepository;
    @Autowired
    private ISchoolRepository iSchoolRepository;
    @Autowired
    private IAnnualReportRepository iAnnualReportRepository;

    @PostMapping("/students")
    public ApiResponse<StudentInfo> create(@RequestBody StudentRequest studentRequest) {
        try {
            Student student = iStudentRepository.save(studentRequest.toStudent());
            School school = iSchoolRepository.findById(student.getSchool().getId()).get();
            AnnualReport annualReport = student.getAnnualReport();
            StudentInfo studentInfo = new StudentInfo(student.getId(), student.getFirstName() + " " + student.getLastName(), school.getId(), school.getSchoolAddress(), null, null);
            return new StudentResponse<>(true, "Student created", studentInfo);
        } catch (Exception e) {
            return new ApiErrorResponse<>(false, e.getMessage());
        }
    }

    @GetMapping("/students")
    public ApiResponse<List<StudentInfo>> getAll() {
        try {
            List<Student> students = iStudentRepository.findAll();
            List<StudentInfo> studentInfoList = new LinkedList<>();
            for (Student i : students) {
                AnnualReport annualReport = i.getAnnualReport();
                StudentInfo info = new StudentInfo(i.getId(), i.getFirstName() + " " + i.getLastName(), i.getSchool().getId(), i.getSchool().getSchoolAddress(), annualReport != null ? annualReport.getStudentGpa() : null, annualReport != null ? annualReport.getStudentGrade() : null);
                studentInfoList.add(info);
            }
            return new StudentResponse<>(true, "success", studentInfoList);
        } catch (Exception e) {
            return new ApiErrorResponse<>(false, e.getMessage());
        }
    }

    @GetMapping("/students/{school_id}")
    public ApiResponse<List<StudentInfo>> getAllForSchool(@PathVariable("school_id") int schoolId) {
        try {
            List<Student> students = iStudentRepository.findAllBySchoolId(schoolId);
            List<StudentInfo> studentInfoList = new LinkedList<>();
            for (Student i : students) {
                AnnualReport annualReport = i.getAnnualReport();
                StudentInfo info = new StudentInfo(i.getId(), i.getFirstName() + " " + i.getLastName(), i.getSchool().getId(), i.getSchool().getSchoolAddress(), annualReport != null ? annualReport.getStudentGpa() : null, annualReport != null ? annualReport.getStudentGrade() : null);
                studentInfoList.add(info);
            }
            return new StudentResponse<>(true, "success", studentInfoList);
        } catch (Exception e) {
            return new ApiErrorResponse<>(false, e.getMessage());
        }
    }

    @PutMapping("/students/{student_id}")
    public ApiResponse<StudentInfo> update(@PathVariable("student_id") int studentId, @RequestParam("report_id") int reportId) {
        try {
            Student student = iStudentRepository.findById(studentId).get();
            AnnualReport annualReport = iAnnualReportRepository.findById(reportId).get();
            student.setAnnualReport(annualReport);
            iStudentRepository.save(student);

            StudentInfo studentInfo = new StudentInfo(student.getId(), student.getFirstName() + " " + student.getLastName(), student.getSchool().getId(), student.getSchool().getSchoolAddress(), student.getAnnualReport().getStudentGpa(), student.getAnnualReport().getStudentGrade());
            return new StudentResponse<>(true, "success", studentInfo);
        } catch (Exception e) {
            return new ApiErrorResponse<>(false, e.getMessage());
        }
    }

    @DeleteMapping("/students/{student_id}")
    public boolean delete(@PathVariable("student_id") int studentId) {
        iStudentRepository.deleteById(studentId);
        return true;
    }
}
