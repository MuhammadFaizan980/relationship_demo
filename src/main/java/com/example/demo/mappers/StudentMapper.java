package com.example.demo.mappers;

import com.example.demo.dtos.student.StudentInfo;
import com.example.demo.dtos.student.StudentRequest;
import com.example.demo.dtos.student.StudentResponse;
import com.example.demo.entities.AnnualReport;
import com.example.demo.entities.School;
import com.example.demo.entities.Student;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class StudentMapper {

    public StudentResponse<List<StudentInfo>> toStudentListResponse(List<StudentInfo> studentInfoList) {
        return new StudentResponse<>(true, "Success", studentInfoList);
    }

    public List<StudentInfo> toStudentsInfoList(List<Student> students) {
        List<StudentInfo> studentInfoList = new LinkedList<>();
        for (Student i : students) {
            AnnualReport annualReport = i.getAnnualReport();
            StudentInfo info = new StudentInfo(i.getId(), i.getFirstName() + " " + i.getLastName(), i.getSchool().getId(), i.getSchool().getSchoolAddress(), annualReport != null ? annualReport.getStudentGpa() : null, annualReport != null ? annualReport.getStudentGrade() : null, i.getCourses());
            studentInfoList.add(info);
        }
        return studentInfoList;
    }

    public StudentResponse<StudentInfo> toStudentResponse(StudentInfo studentInfo) {
        return new StudentResponse<>(true, "Success", studentInfo);
    }

    public StudentInfo toStudentInfo(Student student) {
        AnnualReport annualReport = student.getAnnualReport();
        School school = student.getSchool();
        return new StudentInfo(student.getId(), student.getFirstName() + " " + student.getLastName(), school.getId(), school.getSchoolAddress(), annualReport != null ? annualReport.getStudentGpa() : null, annualReport != null ? annualReport.getStudentGrade() : null, student.getCourses());
    }

    public Student toStudent(StudentRequest studentRequest) {
        Student student = new Student();
        student.setFirstName(studentRequest.firstName());
        student.setLastName(studentRequest.lastName());
        student.setAge(studentRequest.studentAge());

        School school = new School();
        school.setId(studentRequest.schoolId());

        student.setSchool(school);

        return student;
    }
}
