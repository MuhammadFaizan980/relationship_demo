package com.example.demo.dtos.school;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SchoolRequest(@JsonProperty("school_address") String schoolAddress,
                            @JsonProperty("school_phone") String schoolPhoneNumber) {
}
