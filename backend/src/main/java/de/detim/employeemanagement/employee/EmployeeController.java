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

    @GetMapping("/{id}")
    public Employee findEntity(@PathVariable Long id){
        return employeeService.findEntity(id);
    }

    @PostMapping("/")
    public Employee createEntity(@RequestBody Employee newEmployee){
        return employeeService.createEntity(newEmployee);
    }

    @PutMapping("/{id}")
    public Employee updateEntity(@RequestBody Employee employee, @PathVariable Long id){
        return employeeService.updateEntity(employee, id);
    }

    @DeleteMapping("/{id}")
    public Long deleteEntity(@PathVariable Long id){
        return employeeService.deleteEntityById(id);
    }
}
