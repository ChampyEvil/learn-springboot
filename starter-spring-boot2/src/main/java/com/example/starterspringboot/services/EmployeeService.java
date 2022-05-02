package com.example.starterspringboot.services;

import com.example.starterspringboot.domians.Employee;
import com.example.starterspringboot.exceptions.UnProcessableException;
import com.example.starterspringboot.repositorys.EmployeeJpaRepository;
import com.example.starterspringboot.repositorys.EmployeeRepository;
import com.example.starterspringboot.responses.EmployeeRepostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeJpaRepository employeeJpaRepositoryRepository;

    public List<Employee> listAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee findById(Integer id) {
        return employeeRepository.findById(id).orElseThrow(() -> new UnProcessableException("Not Found Employee No. : " + id));
    }

    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    public void update(Integer id, Employee employee) {
        Employee employeeEntity = findById(id);

        employeeEntity.setFirstName(employee.getFirstName());
        employeeEntity.setLastName(employee.getLastName());

        employeeRepository.save(employeeEntity);
    }

    public void delete(Integer id) {
        Employee employeeEntity = findById(id);
        employeeRepository.delete(employeeEntity);
    }

    public List<Employee> findByFirstName(String firstName) {
        return employeeRepository.findByFirstName(firstName);
    }

    public List<EmployeeRepostResponse> findByNativeQuery() {
        return employeeJpaRepositoryRepository.findByNativeQuery();
    }
}
