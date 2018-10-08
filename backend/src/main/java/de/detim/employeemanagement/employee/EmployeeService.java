package de.detim.employeemanagement.employee;

import de.detim.employeemanagement.helper.EntityService;
import de.detim.employeemanagement.qualification.Qualification;

public interface EmployeeService extends EntityService<Employee> {
    void displayEmployee(Employee employee);
    void addQualification(Employee employee, Qualification qualification);
}
