package de.detim.employeemanagement.employee;

import de.detim.employeemanagement.helper.ServiceEntity;
import de.detim.employeemanagement.qualification.Qualification;

public interface EmployeeService extends ServiceEntity<Employee> {
    /**
     * Fügt dem Mitarbeiter eine Qualifikation hinzu
     * @param employee Mitarbeiter, dem eine Qualifikation hinzugefügt werden soll
     * @param qualification Qualfikation, welche dem übergebenen Mitarbeiter hinzugefügt werden soll
     */
    Employee addQualification(Employee employee, Qualification qualification);
}
