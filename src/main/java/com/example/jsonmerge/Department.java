package com.example.jsonmerge;

import com.fasterxml.jackson.annotation.JsonMerge;
import lombok.Data;

import java.util.List;

@Data
public class Department {

    private String departmentName;
    private Person manager;
    private int numberOfEmployees;
//    @JsonMerge
    private List<Department> relatedDepartments;
}
