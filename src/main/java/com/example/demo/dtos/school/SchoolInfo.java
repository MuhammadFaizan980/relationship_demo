package com.example.demo.dtos.school;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SchoolInfo(@JsonProperty("id") int id,
                         @JsonProperty("school_address") String schoolAddress,
                         @JsonProperty("school_phone") String schoolPhoneNumber) {
}
