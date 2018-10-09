package de.detim.employeemanagement.employee;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/employees")
    public List<Employee> listEmployees(){
        return service.getEntities();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable Long id){
        return service.findEntity(id);
    }

    @PostMapping("/employees")
    public Employee newEmployee(@RequestBody Employee newEmployee){
        return service.createEntity(newEmployee);
    }

    @PutMapping("/employees/{id}")
    public Employee editEmployee(@RequestBody Employee employee, @PathVariable Long id){
        return service.updateEntity(employee, id);
    }

    @DeleteMapping("employees/{id}")
    public Long deleteEmployee(@PathVariable Long id){
        return service.deleteEntityById(id);
    }
}
