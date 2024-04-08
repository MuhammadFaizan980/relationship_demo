package com.example.demo.services;

import com.example.demo.base_responses.ApiErrorResponse;
import com.example.demo.base_responses.ApiResponse;
import com.example.demo.dtos.school.SchoolInfo;
import com.example.demo.dtos.school.SchoolRequest;
import com.example.demo.dtos.school.SchoolResponse;
import com.example.demo.entities.School;
import com.example.demo.mappers.SchoolMapper;
import com.example.demo.repositories.ISchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {
    @Autowired
    private ISchoolRepository iSchoolRepository;
    @Autowired
    private SchoolMapper schoolMapper;

    public ApiResponse<SchoolInfo> saveSchool(SchoolRequest schoolRequest) {
        try {
            School school = iSchoolRepository.save(schoolMapper.toSchool(schoolRequest));
            return new SchoolResponse<>(true, "success", schoolMapper.toSchoolInfo(school));
        } catch (Exception e) {
            return new ApiErrorResponse<>(e.getMessage());
        }
    }

    public ApiResponse<List<SchoolInfo>> getAllSchools() {
        try {
            List<School> schools = iSchoolRepository.findAll();
            return schoolMapper.toSchoolListResponse(schoolMapper.toSchoolInfosList(schools));
        } catch (Exception e) {
            return new ApiErrorResponse<>(e.getMessage());
        }
    }

    public boolean deleteSchool(int schoolId) {
        iSchoolRepository.deleteById(schoolId);
        return true;
    }
}
