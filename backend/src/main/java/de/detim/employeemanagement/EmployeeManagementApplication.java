package de.detim.employeemanagement;

import de.detim.employeemanagement.employee.Employee;
import de.detim.employeemanagement.employee.EmployeeService;
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

    /*
    Testdaten für Mitarbeiter erstellen
    */
    @Bean
    public CommandLineRunner createDummyEmployees (EmployeeService service) {
        return (args) -> {
            service.createEntity(new Employee("Andreas", "Pöhler"));
            service.createEntity(new Employee("Patrick", "Notar"));
            service.createEntity(new Employee("Fabian", "Junkert"));

            service.addQualification(service.findEntity((long)1), new Qualification("C#"));
            service.addQualification(service.findEntity((long)2), new Qualification("C++"));
            service.addQualification(service.findEntity((long)3), new Qualification("Python"));
        };
    }

    /*
    Testdaten für Qualifikationen erstellen
    */
    @Bean
    public CommandLineRunner createDummyQualifications (QualificationService service) {
        return (args) -> {
            service.createEntity(new Qualification("Java"));
            service.createEntity(new Qualification("Angular"));
            service.createEntity(new Qualification("MySQL"));
            service.createEntity(new Qualification("Scrum"));
        };
    }
}