package com.example.demo.service;

import com.example.demo.dto.DepartmentDto;
import com.example.demo.exception.DepartmentNotFoundException;
import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService{
@Autowired
    private ModelMapper modelMapper;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        //converting Mongo Dto to Mongo entity
       Department saveddata= modelMapper.map(departmentDto,Department.class );
       saveddata.setPartyId(Department.getPartiesId());
        Department updatedData=departmentRepository.save(saveddata);
        // convert the entity to Dto
       DepartmentDto departmentDto1=modelMapper.map(updatedData, DepartmentDto.class);
       return departmentDto1;



    }

    @Override
    public DepartmentDto getDepartment(String partyId) {
       Department existingDepartment= departmentRepository.findByPartyId(partyId).orElseThrow( () -> new DepartmentNotFoundException("department not found "));

       return modelMapper.map(existingDepartment, DepartmentDto.class);

    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List <Department> savedUsers=departmentRepository.findAll();
        return savedUsers.stream().map(e -> modelMapper.map(e,DepartmentDto.class)).collect(Collectors.toList());
    }

    @Override
    public DepartmentDto updateDepartment(DepartmentDto departmentDto) {
        Optional<Department> existing=departmentRepository.findByPartyId(departmentDto.getPartyId());
        if (!existing.isPresent()){
            throw new DepartmentNotFoundException("Department is not found ");
        }
        existing.get().setDepartmentCode(departmentDto.getDepartmentCode());
        existing.get().setDepartmentName(departmentDto.getDepartmentName());
        existing.get().setDepartmentDescription(departmentDto.getDepartmentDescription());
        Department saveduser =departmentRepository.save(existing.get());
        return modelMapper.map(saveduser, DepartmentDto.class);
    }

    @Override
    public String deleteDepartment(String partyId) {
        Optional<Department> existing=departmentRepository.findByPartyId(partyId);
        if (!existing.isPresent()){
            throw new DepartmentNotFoundException("Department is not found ");
        }
        departmentRepository.deleteByPartyId(partyId);
        return null;

    }
}
