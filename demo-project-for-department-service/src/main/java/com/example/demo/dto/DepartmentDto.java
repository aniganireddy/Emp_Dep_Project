package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class DepartmentDto {
    private String id;
    private String partyId;
    private String departmentCode;
    private String departmentDescription;
    private String departmentName;
}
