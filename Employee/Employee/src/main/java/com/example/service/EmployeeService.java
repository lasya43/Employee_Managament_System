package com.example.service;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    EmployeeRepository  employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee createEmployee(Employee e) {
       return  employeeRepository.save(e);
    }

    public List<Employee> getEmployee() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee e) {

        Employee s = employeeRepository.findById(e.getEid()).orElse(null);

        if (s != null) {
            s.setEname(e.getEname());
            return employeeRepository.save(s);
        }

        return null;
    }

    public String deleteMapping(Long id) {
        employeeRepository.deleteById(id);
        return "Deleted";
    }
}
