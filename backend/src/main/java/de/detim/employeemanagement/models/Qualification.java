package de.detim.employeemanagement.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Qualification extends ModelBase {

    private String name;

    @ManyToMany(targetEntity = Employee.class)
    private List employees;

}
