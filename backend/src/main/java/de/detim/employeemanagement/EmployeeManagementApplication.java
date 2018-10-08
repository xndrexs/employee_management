package de.detim.employeemanagement;

import de.detim.employeemanagement.employee.EmployeeRepository;
import de.detim.employeemanagement.employee.Employee;
import de.detim.employeemanagement.qualification.Qualification;
import de.detim.employeemanagement.qualification.QualificationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class EmployeeManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementApplication.class, args);
    }

    /*
    Testdaten für Mitarbeiter erstellen
     */
    @Bean
    public CommandLineRunner createDummyEmployees (EmployeeRepository repo) {
        return (args) -> {
            log.info("Create User: " + repo.save(new Employee("Andreas", "Pöhler")));
            log.info("Create User: " + repo.save(new Employee("Patrick", "Notar")));
            log.info("Create User: " + repo.save(new Employee("Fabian", "Junkert")));
        };
    }

    /*
    Testdaten für Qualifikationen erstellen
     */
    @Bean
    public CommandLineRunner createDummyQualifications (QualificationRepository repo) {
        return (args) -> {
            repo.save(new Qualification("Java"));
            repo.save(new Qualification("Angular"));
        };
    }

}