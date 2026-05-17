package com.mk.springbootapp.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.mk.springbootapp.model.Employee;
import com.mk.springbootapp.model.EmployeeDto;
import com.mk.springbootapp.service.EmployeeService;

@Controller
public class EmployeeGraphQLController {

    private final EmployeeService employeeService;

    public EmployeeGraphQLController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // GET ALL
    @QueryMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // GET BY ID
    @QueryMapping
    public Employee getEmployeeById(@Argument Long id) {
        return employeeService.getEmployeeById(id)
                .orElse(null);
    }

    // CREATE
    @MutationMapping
    public Employee createEmployee(@Argument EmployeeDto employee) {

        Employee emp = new Employee();
        emp.setName(employee.getName());
        emp.setJob(employee.getJob());

        return employeeService.saveEmployee(emp);
    }

    // UPDATE
    @MutationMapping
    public Employee updateEmployee(@Argument EmployeeDto employee) {

        Employee emp = new Employee();
        emp.setId(employee.getId());
        emp.setName(employee.getName());
        emp.setJob(employee.getJob());

        return employeeService.updateEmployee(
                employee.getId(),
                emp
        );
    }

    // DELETE
    @MutationMapping
    public String deleteEmployee(@Argument Long id) {

        employeeService.deleteEmployee(id);
        return "Employee Deleted Successfully";
    }
}