package com.example.demo.dtos.school;

import com.example.demo.entities.School;
import com.fasterxml.jackson.annotation.JsonProperty;

public record SchoolRequest(@JsonProperty("school_address") String schoolAddress,
                            @JsonProperty("school_phone") String schoolPhoneNumber) {

    public School toSchool() {
        School school = new School();
        school.setSchoolAddress(schoolAddress);
        school.setSchoolPhoneNumber(schoolPhoneNumber);
        return school;
    }
}
