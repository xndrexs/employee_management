package de.detim.employeemanagement;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;

    // he default constructor only exists for the sake of JPA. You won’t use it directly, so it is designated as protected.
    protected Employee() {}
    public Employee (String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
}