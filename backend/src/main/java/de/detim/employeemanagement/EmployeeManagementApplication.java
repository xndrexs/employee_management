package de.detim.employeemanagement;

import de.detim.employeemanagement.employee.Employee;
import de.detim.employeemanagement.employee.EmployeeService;
import de.detim.employeemanagement.helper.BaseEntity;
import de.detim.employeemanagement.qualification.Qualification;
import de.detim.employeemanagement.qualification.QualificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class EmployeeManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementApplication.class, args);
    }

    @Bean
    public CommandLineRunner createDummyEntities(EmployeeService employeeService, QualificationService qualificationService) {
        return (args) -> {
            /*
            Testdaten für Mitarbeiter erstellen
            */
            employeeService.createEntity(new Employee("Andreas", "Pöhler"));
            employeeService.createEntity(new Employee("Patrick", "Notar"));
            employeeService.createEntity(new Employee("Fabian", "Junkert"));

            qualificationService.createEntity(new Qualification("Java"));
            qualificationService.createEntity(new Qualification("Angular"));
            qualificationService.createEntity(new Qualification("MySQL"));
            qualificationService.createEntity(new Qualification("Scrum"));

            Employee entity = employeeService.findEntity(1L);
            entity.setPosition("Praktikant");
            entity.setCitizenship("German");
            entity.setDegree("Bachelor");
            employeeService.addQualification(entity, qualificationService.findEntityByName("Java"));
            employeeService.addQualification(entity, qualificationService.findEntityByName("Angular"));
            employeeService.addQualification(entity, qualificationService.findEntityByName("MySQL"));
        };
    }
}