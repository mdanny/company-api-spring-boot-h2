package com.example.demo.controllers;

import com.example.demo.entities.EmployeeEntity;
import com.example.demo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CompanyController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeEntity>> getAllEmployees(
            @RequestParam(required = false, value = "dateOfBirth")
            @DateTimeFormat(pattern = "yyyy-MM-dd")
            Date dateOfBirth,
            @RequestParam(required = false, value = "departmentId")
            Integer departmentId
            ) {
        try {
            List<EmployeeEntity> employees = new ArrayList<>();

            if (dateOfBirth == null && departmentId == null)
                employees.addAll(employeeRepository.findAll());
            else if (dateOfBirth != null) {
                employees.addAll(employeeRepository.findByDateOfBirth(dateOfBirth));
            }
            else {
                employees.addAll(employeeRepository.findByDepartmentId(departmentId));
            }
            if (employees.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(employees, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
