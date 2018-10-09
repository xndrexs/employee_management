package de.detim.employeemanagement.qualification;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import de.detim.employeemanagement.employee.Employee;
import de.detim.employeemanagement.helper.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Qualification extends BaseEntity {

    private String name;

    @ManyToMany(targetEntity = Employee.class, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("qualifications")
    private List<Employee> employees;

    public Qualification (String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }
}
