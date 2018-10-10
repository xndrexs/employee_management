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
}
