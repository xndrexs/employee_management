package de.detim.employeemanagement.employee;

import de.detim.employeemanagement.exceptions.EmptyEntityException;
import de.detim.employeemanagement.exceptions.EntityNotFoundException;
import de.detim.employeemanagement.exceptions.IdsNotMachtingException;
import de.detim.employeemanagement.qualification.Qualification;
import de.detim.employeemanagement.qualification.QualificationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final QualificationRepository qualificationRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepo, QualificationRepository qualificationRepository){
        this.employeeRepository = employeeRepo;
        this.qualificationRepository = qualificationRepository;
    }

    @Override
    public Employee createEntity(Employee employee) {
        if (employee == null) {
            throw new EmptyEntityException();
        } else {
            employeeRepository.save(employee);
            log.info("Employee created:  {} {}", employee.getFirstName(), employee.getLastName());
        }
        return employee;
    }

    @Override
    public Employee findEntity(Long id) {
        return employeeRepository.findEmployeeById(id);
    }

    @Override
    public Employee updateEntity(Employee employee, Long id) {
        Employee updatedEmployee = null;
        if (employee == null) {
            throw new EmptyEntityException();
        } else if (!employee.getId().equals(id)) {
            throw new IdsNotMachtingException(employee.getId(), id);
        } else if (!employeeRepository.existsById(id)){
            throw new EntityNotFoundException();
        } else {
            updatedEmployee = employeeRepository.findEmployeeById(id);
            updatedEmployee.updateEmployee(employee);
            employeeRepository.save(updatedEmployee);
            log.info("Employee updated: " + employee.getLastName());
        }
        return updatedEmployee;
    }

    @Override
    public Long deleteEntityById(Long id) {
        employeeRepository.deleteById(id);
        log.info("Employee deleted: {}", id);
        return id;
    }

    @Override
    public Long deleteEntity(Employee employee) {
        Long id = employee.getId();
        employeeRepository.delete(employee);
        log.info("Employee deleted: {}", employee.getLastName());
        return id;
    }

    @Override
    public Iterable<Employee> getEntities() {
        return employeeRepository.findAll();
    }

    @Override
    public Long count() {
        return employeeRepository.count();
    }

    @Override
    public Employee displayEmployee(Employee employee) {
        log.info("Employee: {} {}", employee.getFirstName(), employee.getLastName());
        return employee;
    }

    @Override
    public Employee addQualification(Employee employee, Qualification qualification) {
        employee.addQualification(qualification);
        qualification.addEmployee(employee);
        qualificationRepository.save(qualification);
        employeeRepository.save(employee);
        log.info("Qualification '{}' added to {}.", qualification.getName(), employee.getLastName());
        return employee;
    }
}
