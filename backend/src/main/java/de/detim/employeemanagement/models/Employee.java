package de.detim.employeemanagement.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employee extends ModelBase {

    private String firstName;
    private String lastName;
    private String citizenship;
    private String degree;
    private String position;

    @ManyToMany(targetEntity = Qualification.class)
    private List qualifications;

    // he default constructor only exists for the sake of JPA. You won’t use it directly, so it is designated as protected.
    protected Employee() {}
    public Employee (String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.qualifications = new ArrayList();
    }

    @Override
    public String toString(){
        return "Employee: " + firstName + " " + lastName;
    }
}