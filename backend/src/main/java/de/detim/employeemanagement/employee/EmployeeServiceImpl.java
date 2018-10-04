package de.detim.employeemanagement.employee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepo){
        this.employeeRepository = employeeRepo;
    }

    @Override
    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
        logger.info("Employee created: %s %s", employee.getFirstName(), employee.getLastName());
    }

    @Override
    public Employee readEmployee(Long id) {
        return null;
    }

    @Override
    public void updateEmployee(Employee employee, Long id) {
        deleteEmployee(id);
        createEmployee(employee);
        logger.info("Employee updated: %s", employee.getLastName());
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
        logger.info("Employee deleted: %s", id);
    }

    @Override
    public Iterable<Employee> getEmployees() {
        return employeeRepository.findAll();
    }
}
