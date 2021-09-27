package com.example.SpringBootA.controller;

import java.util.List;
import java.util.Optional;

import com.example.SpringBootA.model.Employee;
import com.example.SpringBootA.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Optional<Employee> getEmployee(@PathVariable Long id) {
        return employeeService.findById(id);
    }

    @PostMapping("/addEmployee")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(@RequestBody Employee emp1) {
        return employeeService.save(emp1);
    }

    @PutMapping("/employees/{employeeId}")
    public Optional<Employee> updateEmployee(@PathVariable Long employeeId, @Validated @RequestBody Employee emp2) {
        return employeeService.findById(employeeId).map(employee -> {
            employee.setEmployeeId(emp2.getEmployeeId());
            employee.setEmployeeName(emp2.getEmployeeName());
            employee.setEmployeeCity(emp2.getEmployeeCity());
            return employeeService.save(employee);
        });
    }

    @DeleteMapping("/employees/{employeeId}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long employeeId){
        return employeeService.findById(employeeId).map(employee -> {
            employeeService.delete(employee.getEmployeeId());
            return ResponseEntity.ok().build();
        }).get();
    }
}