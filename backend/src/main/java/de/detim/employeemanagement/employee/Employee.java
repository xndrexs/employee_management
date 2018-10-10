package de.detim.employeemanagement.employee;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import de.detim.employeemanagement.helper.BaseEntity;
import de.detim.employeemanagement.qualification.Qualification;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Employee extends BaseEntity {

    private String firstName;
    private String lastName;
    private String citizenship;
    private String degree;
    private String position;

    @ManyToMany(targetEntity = Qualification.class, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("employees")
    private List<Qualification> qualifications = new ArrayList<>();;

    public Employee (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}