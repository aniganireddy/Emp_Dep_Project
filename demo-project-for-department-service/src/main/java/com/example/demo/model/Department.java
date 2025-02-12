package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Random;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "departments")
public class Department {
    @Id
    private String id;
    private String partyId;
    private String departmentCode;
    private String departmentDescription;
    private String departmentName;




    public static String getPartiesId(){
        Random random = new Random();
       int id=1000000000 + random.nextInt(900000000);
       return String.valueOf(id);
    }
}
