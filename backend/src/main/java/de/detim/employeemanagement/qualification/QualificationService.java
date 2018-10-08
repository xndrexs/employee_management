package de.detim.employeemanagement.qualification;


import de.detim.employeemanagement.employee.Employee;
import de.detim.employeemanagement.helper.ServiceEntitiy;

public interface QualificationService extends ServiceEntitiy<Qualification> {
    /**
     * Fügt der Qualifikation einen Mitarbeiter hinzu
     * @param qualification Qualifikation, welcher ein Mitarbeiter hinzugefügt werden soll
     * @param employee Mitarbeiter, welcher der übergebenen Qualifikation hinzugefügt werden soll
     */
    Qualification addEmployee(Qualification qualification, Employee employee);
}