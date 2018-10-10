package de.detim.employeemanagement.employee;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/employees")
@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService service) {
        this.employeeService = service;
    }

    @GetMapping("/")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/{employeeId}")
    public Employee findEntity(@PathVariable Long employeeId){
        return employeeService.findEntity(employeeId);
    }

    @PostMapping("/")
    public Employee createEntity(@RequestBody Employee newEmployee){
        return employeeService.createEntity(newEmployee);
    }

    @PutMapping("/{employeeId}")
    public Employee updateEntity(@RequestBody Employee employee, @PathVariable Long employeeId){
        return employeeService.updateEntity(employee, employeeId);
    }

    @DeleteMapping("/{employeeId}")
    public Long deleteEntity(@PathVariable Long employeeId){
        return employeeService.deleteEntityById(employeeId);
    }
}
