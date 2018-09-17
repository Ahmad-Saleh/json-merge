package com.example.jsonmerge;

import com.fasterxml.jackson.annotation.JsonMerge;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Person {

    private String name;
    private String title;
    private String hight;
    private LocalDate dateOfBirth;
    @JsonMerge
    private Department department;
}
