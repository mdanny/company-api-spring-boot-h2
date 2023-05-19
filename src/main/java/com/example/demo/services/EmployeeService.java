package com.example.demo.services;

import com.example.demo.models.Employee;
import com.example.demo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
//    public List<Employee> getEmployees() {
//        List<Employee> employeeList = employeeRepository.findAllEmployeesBasedOnCondition(params);
//        Map<Long, List<Employee>> result = new HashMap<>();
//        for (Employee employee: employeeList) {
//            if (!result.containsKey(employee.departmentId)) {
//                List<Employee> employees = new ArrayList<>();
//                result.put(employee.departmentId, employees);
//            }
////            result.put(employee.departmentId, employeeList.);
//            result.get(employee.departmentId).add(employee);
//        }
//        return result;
//    }
}
