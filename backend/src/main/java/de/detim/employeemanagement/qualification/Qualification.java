package de.detim.employeemanagement.qualification;

import de.detim.employeemanagement.employee.Employee;
import de.detim.employeemanagement.helper.BaseEntity;
import lombok.*;

import javax.persistence.*;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Qualification extends BaseEntity {

    private String name;

    @ManyToMany(targetEntity = Employee.class, fetch = FetchType.EAGER)
    private List<Employee> employees;

    public Qualification (String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    /**
     * Updates the values with the given qualification
     * @param qualification values of the qualification
     */
    public void updateQualification(Qualification qualification) {
        name = qualification.getName();
        employees = new ArrayList<>(qualification.getEmployees());
    }

}
