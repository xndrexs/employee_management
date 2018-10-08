package de.detim.employeemanagement.employee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    private EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    // Test, ob der Service funktioniert
    @GetMapping
    public Iterable<Employee> index(){
        return service.getEntities();
    }
}
