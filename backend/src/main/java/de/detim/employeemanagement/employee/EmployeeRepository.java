package de.detim.employeemanagement.employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findEmployeeById(Long id);
    Employee findEmployeeByLastName(String name);
}