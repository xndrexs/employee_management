package de.detim.employeemanagement.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Qualification extends ModelBase {

    private String name;

    @ManyToMany(targetEntity = Employee.class)
    private List<Employee> employees;

}
