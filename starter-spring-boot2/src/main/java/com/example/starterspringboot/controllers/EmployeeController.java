package com.example.starterspringboot.controllers;

import com.example.starterspringboot.domians.Employee;
import com.example.starterspringboot.responses.EmployeeRepostResponse;
import com.example.starterspringboot.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> findAll() {

        return employeeService.listAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Integer id) {

        Employee employee = employeeService.findById(id);
        return employee;
    }

    @PostMapping
    public Employee create(@RequestBody Employee employee) {

        employeeService.save(employee);
        return employee;
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Integer id, @RequestBody Employee employee) {

        employeeService.update(id, employee);
        return employee;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        employeeService.delete(id);
    }

    @GetMapping("/firstName/{firstName}")
    public List<Employee> findByFirstName(@PathVariable String firstName) {

        return employeeService.findByFirstName(firstName);
    }

    @GetMapping("/nativeQuery")
    public List<EmployeeRepostResponse> findByNativeQuery() {
        return employeeService.findByNativeQuery();
    }
}
