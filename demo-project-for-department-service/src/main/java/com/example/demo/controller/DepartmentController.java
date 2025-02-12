package com.example.demo.controller;

import com.example.demo.dto.DepartmentDto;
import com.example.demo.service.DepartmentServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
@Tag(
        name = "CRUD REST APIs for department Resource",
        description = "CRUD REST APIs - Create User, Update User, Get User, Get All Users, Delete User"
)
public class DepartmentController {

    @Autowired
    private DepartmentServiceImpl departmentService;
    @Operation(
            summary = "CRUD REST API",
            description = "This api used to save the record in database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "customer record saved successfully in db"
    )

    @PostMapping("/create")
    public ResponseEntity<DepartmentDto> createNewDepartmentRecord(@RequestBody DepartmentDto departmentDto){
       DepartmentDto dto =departmentService.createDepartment(departmentDto);
       return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @Operation(
            summary = "CRUD REST API",
            description = "This api used to get  the record in database"
    )
    @ApiResponse(
            responseCode = "200",
            description = " record got  successfully in db"
    )
    @GetMapping("/{partyId}")
    public ResponseEntity<DepartmentDto> getDepartmentRecord( @PathVariable String partyId){

        DepartmentDto dto= departmentService.getDepartment(partyId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Operation(
            summary = "CRUD REST API",
            description = "This api used to get all the record in database"
    )
    @ApiResponse(
            responseCode = "200",
            description = " records got  successfully in db"
    )
    @GetMapping("/all")
    public ResponseEntity<List<DepartmentDto>>getAll(){
       List<DepartmentDto> departmentDto= departmentService.getAllDepartments();
       return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }

    @Operation(
            summary = "CRUD REST API",
            description = "This api used to update  the record in database"
    )
    @ApiResponse(
            responseCode = "201",
            description = " record got  updated successfully in db"
    )
    @PutMapping("/update/{partyId}")
    public ResponseEntity<DepartmentDto> updateDepartments(@PathVariable String partyId, @RequestBody DepartmentDto departmentDto){
        departmentDto.setPartyId(partyId);
       DepartmentDto dto= departmentService.updateDepartment(departmentDto);
       return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Operation(
            summary = "CRUD REST API",
            description = "This api used to delete  the record in database"
    )
    @ApiResponse(
            responseCode = "200",
            description = " record got deleted successfully in db"
    )

    @DeleteMapping("/delete/{partyId}")
    public ResponseEntity<String> deletebyParty(@PathVariable String partyId){
        departmentService.deleteDepartment(partyId);
        return new ResponseEntity<>("deleted successfully", HttpStatus.ACCEPTED);

    }
}
