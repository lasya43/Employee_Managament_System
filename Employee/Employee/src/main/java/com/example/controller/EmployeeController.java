package com.example.controller;

import com.example.entity.Employee;
import com.example.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public Employee createEmmployee(@RequestBody Employee e){

        return employeeService.createEmployee(e);
    }

    @GetMapping
    public List<Employee> getEmployee(){
        return employeeService.getEmployee();
    }
    @PutMapping
    public  Employee updateEmployee(@RequestBody Employee e){
        return employeeService.updateEmployee(e);
    }
    @DeleteMapping("/{id}")
    public String deleteMapping(@PathVariable Long id){
        return employeeService.deleteMapping(id);
    }


}
