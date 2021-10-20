package com.example.SpringBootA.service;

import com.example.SpringBootA.model.Employee;
import com.example.SpringBootA.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee save(Employee emp1) {
        return employeeRepository.save(emp1);
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }
}
