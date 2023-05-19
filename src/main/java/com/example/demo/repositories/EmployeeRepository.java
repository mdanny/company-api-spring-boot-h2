package com.example.demo.repositories;

import com.example.demo.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public
interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    List<EmployeeEntity> findByDateOfBirth(Date date);

    List<EmployeeEntity> findByDepartmentId(Integer id);
}
