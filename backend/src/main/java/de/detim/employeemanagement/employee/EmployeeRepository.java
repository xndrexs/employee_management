package de.detim.employeemanagement.employee;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    /**
     * Gibt einen Mitarbeiter zurück
     * @param id ID des Mitarbeiters
     * @return Mitarbeiter der übergebenen ID
     */
    Employee findEmployeeById(Long id);
}