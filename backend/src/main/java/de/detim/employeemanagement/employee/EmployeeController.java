package de.detim.employeemanagement.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    private EmployeeServiceImpl employeeServiceImpl;

    @Autowired // Injection
    public EmployeeController(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    // Test, ob der Service funktioniert
    @GetMapping
    public Iterable<Employee> index(){
        return employeeServiceImpl.getEmployees();
    }
}
