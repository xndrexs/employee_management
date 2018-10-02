package de.detim.employeemanagement.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Employee extends ModelBase {

    private String firstName;
    private String lastName;
    private String citizenship;
    private String degree;
    private String position;

    @ManyToMany(targetEntity = Qualification.class)
    private List<Qualification> qualifications;

    public Employee (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.qualifications = new ArrayList<>();
    }

    @Override
    public String toString(){
        return "Employee: " + firstName + " " + lastName;
    }
}