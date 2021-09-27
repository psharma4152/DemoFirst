package com.example.SpringBootA.service;

import java.util.List;
import java.util.Optional;

import com.example.SpringBootA.model.Employee;

public interface EmployeeService {
    List<Employee> findAll();
    Optional<Employee> findById(Long id);
    Employee save(Employee emp1);
    void delete(Long id);
}
