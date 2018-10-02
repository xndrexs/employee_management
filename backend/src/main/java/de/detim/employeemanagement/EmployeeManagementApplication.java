package de.detim.employeemanagement;

import de.detim.employeemanagement.models.Employee;
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
    public CommandLineRunner test (EmployeeRepository repo ){
        return (args) -> {
            repo.save(new Employee("Andreas", "Pöhler"));
            repo.save(new Employee("Patrick", "Notar"));
        };
    }
}