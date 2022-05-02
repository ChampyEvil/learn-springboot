package com.example.starterspringboot.repositorys;

import com.example.starterspringboot.domians.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

//    @Query("select o from Employee o where o.firstName = ?1")
    @Query(value = "select * from employee where first_name = ?1", nativeQuery = true)
    List<Employee> findByFirstName(String firstName);

}
