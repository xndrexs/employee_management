package de.detim.employeemanagement;

import de.detim.employeemanagement.employee.Employee;
import de.detim.employeemanagement.employee.EmployeeServiceImpl;
import de.detim.employeemanagement.qualification.Qualification;
import de.detim.employeemanagement.qualification.QualificationService;
import de.detim.employeemanagement.qualification.QualificationServiceImpl;
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
    public CommandLineRunner createDummyEmployees (EmployeeServiceImpl service) {
        // Hier würde ich eigentlich gerne den Service nutzen, weil das Loggin darun schon integriert ist, aber mir fehlen die Methoden des Repos?!
        return (args) -> {
            service.createEntity(new Employee("Andreas", "Pöhler"));
            service.createEntity(new Employee("Patrick", "Notar"));
            service.createEntity(new Employee("Fabian", "Junkert"));

            // Testing
            log.info("Entities found for Employee: " + service.count());
            for (Employee employee : service.getEntities()) {
                service.displayEmployee(employee);
            }
        };
    }

    /*
    Testdaten für Qualifikationen erstellen
    */
    @Bean
    public CommandLineRunner createDummyQualifications (QualificationServiceImpl service) {
        return (args) -> {
            service.createEntity(new Qualification("Java"));
            service.createEntity(new Qualification("Angular"));
        };
    }
}