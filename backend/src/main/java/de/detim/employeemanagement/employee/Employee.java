package de.detim.employeemanagement.employee;

import de.detim.employeemanagement.helper.BaseEntity;
import de.detim.employeemanagement.qualification.Qualification;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Employee extends BaseEntity {

    private String firstName;
    private String lastName;
    private String citizenship;
    private String degree;
    private String position;

    @ManyToMany(targetEntity = Qualification.class, fetch = FetchType.EAGER)
    private List<Qualification> qualifications;

    public Employee (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.qualifications = new ArrayList<>();
    }
}