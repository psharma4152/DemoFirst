package com.example.SpringBootA.model;

import com.example.SpringBootA.Views.EmployeeViews;
import com.fasterxml.jackson.annotation.JsonView;
import com.sun.istack.NotNull;
import javax.persistence.*;

@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long employeeId;

    @NotNull
    @Column(name = "name")
    @JsonView({EmployeeViews.TeamLead.class, EmployeeViews.Manager.class, EmployeeViews.HR.class})
    private String employeeName;

    @Column(name = "city")
    @JsonView(EmployeeViews.HR.class)
    private String employeeCity;

    @Column(name="address")
    @JsonView(EmployeeViews.HR.class)
    private String employeeAddress;

    @Column(name="salary")
    @JsonView({EmployeeViews.Manager.class,EmployeeViews.HR.class})
    private int salary;

    @Column(name="position")
    @JsonView({EmployeeViews.TeamLead.class,EmployeeViews.Manager.class})
    private String position;

    public Employee(){

    }

    public Employee(Long employeeId, String employeeName, String employeeCity, String employeeAddress, int salary, String position) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeCity = employeeCity;
        this.employeeAddress = employeeAddress;
        this.salary = salary;
        this.position = position;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeCity() {
        return employeeCity;
    }

    public void setEmployeeCity(String employeeCity) {
        this.employeeCity = employeeCity;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
