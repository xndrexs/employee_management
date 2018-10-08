package de.detim.employeemanagement.employee;

import de.detim.employeemanagement.helper.BaseEntity;
import de.detim.employeemanagement.qualification.Qualification;
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
public class Employee extends BaseEntity {

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

    /**
     * Fügt dem Mitarbeiter eine Qualifikation hinzu
     * @param qualification Qualifikation, welche hinzugefügt werden soll
     */
    public void addQualification(Qualification qualification){
        qualifications.add(qualification);
    }

    /**
     * Aktualisiert die Werte des übergebenen Benutzers
     * @param employee Benutzer, dessen Werte übernommen werden sollen
     */
    public void updateEmployee(Employee employee){
        firstName = employee.getFirstName();
        lastName = employee.getLastName();
        citizenship = employee.getCitizenship();
        degree = employee.getDegree();
        position = employee.getPosition();
        qualifications = new ArrayList<>(employee.getQualifications());
    }
}