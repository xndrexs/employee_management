package de.detim.employeemanagement.employee;

import java.util.List;

public interface EmployeeService {
    void createEmployee(Employee employee);
    Employee readEmployee(Long id);
    void updateEmployee(Employee employee, Long id);
    void deleteEmployee(Long id);
    Iterable<Employee> getEmployees();
}
