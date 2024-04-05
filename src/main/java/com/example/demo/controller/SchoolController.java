package com.example.demo.controller;

import com.example.demo.base_responses.ApiErrorResponse;
import com.example.demo.base_responses.ApiResponse;
import com.example.demo.dtos.school.SchoolInfo;
import com.example.demo.dtos.school.SchoolRequest;
import com.example.demo.dtos.school.SchoolResponse;
import com.example.demo.entities.School;
import com.example.demo.repositories.ISchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
public class SchoolController {
    @Autowired
    private ISchoolRepository iSchoolRepository;

    @PostMapping("/schools")
    public ApiResponse<SchoolInfo> create(@RequestBody SchoolRequest schoolRequest) {
        try {
            School school = iSchoolRepository.save(schoolRequest.toSchool());
            SchoolInfo schoolInfo = new SchoolInfo(school.getId(), school.getSchoolAddress(), school.getSchoolPhoneNumber());
            return new SchoolResponse<>(true, "New school added", schoolInfo);
        } catch (Exception e) {
            return new ApiErrorResponse<>(false, e.getMessage());
        }
    }

    @GetMapping("/schools")
    public ApiResponse<List<SchoolInfo>> getAll() {
        try {
            List<School> schools = iSchoolRepository.findAll();
            List<SchoolInfo> schoolsInfoList = new LinkedList<SchoolInfo>();
            schools.forEach(school -> {
                SchoolInfo schoolinfo = new SchoolInfo(school.getId(), school.getSchoolAddress(), school.getSchoolPhoneNumber());
                schoolsInfoList.add(schoolinfo);
            });
            return new SchoolResponse<List<SchoolInfo>>(true, "Success", schoolsInfoList);
        } catch (Exception e) {
            return new ApiErrorResponse<>(false, e.getMessage());
        }
    }

    @DeleteMapping("/schools/{school_id}")
    public boolean delete(@PathVariable("school_id") int schoolId) {
        iSchoolRepository.deleteById(schoolId);
        return true;
    }
}
