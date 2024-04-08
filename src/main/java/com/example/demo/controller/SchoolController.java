package com.example.demo.controller;

import com.example.demo.base_responses.ApiResponse;
import com.example.demo.dtos.school.SchoolInfo;
import com.example.demo.dtos.school.SchoolRequest;
import com.example.demo.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @PostMapping("/schools")
    public ApiResponse<SchoolInfo> create(@RequestBody SchoolRequest schoolRequest) {
        return schoolService.saveSchool(schoolRequest);
    }

    @GetMapping("/schools")
    public ApiResponse<List<SchoolInfo>> getAll() {
        return schoolService.getAllSchools();
    }

    @DeleteMapping("/schools/{school_id}")
    public boolean delete(@PathVariable("school_id") int schoolId) {
        return schoolService.deleteSchool(schoolId);
    }
}
