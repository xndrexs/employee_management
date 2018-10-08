package de.detim.employeemanagement.employee;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    List<Employee> findByLastName(String lastName);
    Employee findEmployeeById(Long id);
    // Employee findEmployeeId(Long id); -> Ging nicht ?!
}