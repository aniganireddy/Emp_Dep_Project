package com.example.demo.service;

import com.example.demo.dto.DepartmentDto;
import com.example.demo.model.Department;
import jakarta.validation.metadata.ElementDescriptor;

import java.util.List;

public interface DepartmentService  {
    DepartmentDto createDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartment(String partyId);
    List<DepartmentDto> getAllDepartments();
    DepartmentDto updateDepartment(DepartmentDto departmentDto);
    String deleteDepartment(String partyId);
}
