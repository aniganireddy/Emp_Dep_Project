package com.example.demo.repository;

import com.example.demo.model.Department;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DepartmentRepository extends MongoRepository<Department,String> {

    Optional<Department> findByPartyId(String partyId);
   String  deleteByPartyId(String partyId);
}
