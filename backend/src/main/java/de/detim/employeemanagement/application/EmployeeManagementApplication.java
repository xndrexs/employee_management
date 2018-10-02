package de.detim.employeemanagement.application;

import de.detim.employeemanagement.employee.EmployeeRepository;
import de.detim.employeemanagement.employee.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementApplication.class, args);
    }

    @Bean
    public CommandLineRunner createDummyEmployees (EmployeeRepository repo ){
        return (args) -> {
            repo.save(new Employee("Andreas", "Pöhler"));
            repo.save(new Employee("Patrick", "Notar"));
            repo.save(new Employee("Fabian", "Junkert"));
        };
    }
}