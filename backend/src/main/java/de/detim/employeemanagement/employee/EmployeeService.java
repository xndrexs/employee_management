package de.detim.employeemanagement.employee;

import de.detim.employeemanagement.helper.EntityService;

public interface EmployeeService extends EntityService<Employee> {
    void displayEmployee(Employee employee);
}
