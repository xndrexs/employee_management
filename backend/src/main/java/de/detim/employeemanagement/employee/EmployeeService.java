package de.detim.employeemanagement.employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);
    Employee readEmployee(Long id);
    Employee updateEmployee(Employee employee, Long id);
    void deleteEmployee(Long id);
    Iterable<Employee> getEmployees();
}
