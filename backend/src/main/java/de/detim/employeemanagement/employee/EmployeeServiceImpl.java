package de.detim.employeemanagement.employee;

import de.detim.employeemanagement.helper.EmptyEntityException;
import de.detim.employeemanagement.qualification.Qualification;
import de.detim.employeemanagement.qualification.QualificationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final QualificationRepository qualificationRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepo, QualificationRepository qualificationRepository){
        this.employeeRepository = employeeRepo;
        this.qualificationRepository = qualificationRepository;
    }

    @Override
    public void createEntity(Employee employee) {
        if (employee == null) {
            try {
                throw new EmptyEntityException("Employee is empty");
            } catch (EmptyEntityException e) {
                e.printStackTrace();
            }
        } else {
            employeeRepository.save(employee);
            log.info("Employee created:  {} {}", employee.getFirstName(), employee.getLastName());
        }
    }

    @Override
    public Employee readEntity(Long id) {
        return employeeRepository.findEmployeeById(id);
    }

    @Override
    public void updateEntity(Employee employee, Long id) {
        deleteEntityById(id);
        createEntity(employee);
        log.info("Employee updated: %s", employee.getLastName());
    }

    @Override
    public void deleteEntityById(Long id) {
        employeeRepository.deleteById(id);
        log.info("Employee deleted: {}", id);
    }

    @Override
    public void deleteEntity(Employee employee) {
        employeeRepository.delete(employee);
        log.info("Employee deleted: {}", employee.getLastName());
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
    public void displayEmployee(Employee employee) {
        log.info("Employee: {} {}", employee.getFirstName(), employee.getLastName());
    }

    @Override
    public void addQualification(Employee employee, Qualification qualification) {
        employee.addQualification(qualification);
        qualification.addEmployee(employee);
        qualificationRepository.save(qualification);
        employeeRepository.save(employee);
    }
}
