package de.detim.employeemanagement.qualification;


import de.detim.employeemanagement.employee.Employee;
import de.detim.employeemanagement.helper.EntityService;

public interface QualificationService extends EntityService<Qualification> {
    void addEmployee(Qualification qualification, Employee employee);
}