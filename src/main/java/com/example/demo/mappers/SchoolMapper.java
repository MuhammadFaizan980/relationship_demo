package com.example.demo.mappers;

import com.example.demo.dtos.school.SchoolInfo;
import com.example.demo.dtos.school.SchoolRequest;
import com.example.demo.dtos.school.SchoolResponse;
import com.example.demo.entities.School;

import java.util.LinkedList;
import java.util.List;

public class SchoolMapper {

    public SchoolInfo toSchoolInfo(School school) {
        return new SchoolInfo(school.getId(), school.getSchoolAddress(), school.getSchoolPhoneNumber());
    }

    public SchoolResponse<List<SchoolInfo>> toSchoolListResponse(List<SchoolInfo> shoolsInfoList) {
        return new SchoolResponse<>(true, "Success", shoolsInfoList);
    }

    public List<SchoolInfo> toSchoolInfosList(List<School> schoolList) {
        List<SchoolInfo> schoolsInfoList = new LinkedList<>();
        schoolList.forEach(school -> {
            SchoolInfo info = new SchoolInfo(school.getId(), school.getSchoolAddress(), school.getSchoolPhoneNumber());
            schoolsInfoList.add(info);
        });
        return schoolsInfoList;
    }

    public School toSchool(SchoolRequest schoolRequest) {
        School school = new School();
        school.setSchoolAddress(schoolRequest.schoolAddress());
        school.setSchoolPhoneNumber(schoolRequest.schoolPhoneNumber());
        return school;
    }
}
