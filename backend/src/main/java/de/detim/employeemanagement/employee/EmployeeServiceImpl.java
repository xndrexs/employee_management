package de.detim.employeemanagement.employee;

import de.detim.employeemanagement.exceptions.EntityNotFoundException;
import de.detim.employeemanagement.qualification.Qualification;
import de.detim.employeemanagement.qualification.QualificationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        checkEntityNotNull(employee);
        employeeRepository.save(employee);
        log.info("Employee created:  {} {}", employee.getFirstName(), employee.getLastName());
        return employee;
    }

    @Override
    public Employee findEntity(Long id) {
        return employeeRepository.findEmployeeById(id);
    }

    @Override
    public Employee updateEntity(Employee employee, Long id) {
        checkEntityNotNull(employee);
        checkEntityIdMatch(employee, id);
        if (!employeeRepository.existsById(id)){
            throw new EntityNotFoundException();
        }
        Employee updatedEmployee = updateEmployee(employee, id);
        employeeRepository.save(updatedEmployee);
        log.info("Employee updated: " + updatedEmployee.getLastName());
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
    public List<Employee> getEntities() {
        return employeeRepository.findAll();
    }

    @Override
    public Long count() {
        return employeeRepository.count();
    }

    /**
     * Adds and qualification to the list of the employee
     * @param employee Mitarbeiter, dem eine Qualifikation hinzugefügt werden soll
     * @param qualification Qualfikation, welche dem übergebenen Mitarbeiter hinzugefügt werden soll
     * @return
     */
    @Override
    public Employee addQualification(Employee employee, Qualification qualification) {
        addQualificationToEmployee(qualification, employee);
        log.info("Qualification '{}' added to {}.", qualification.getName(), employee.getLastName());
        return employee;
    }

    /**
     * Private method to help update the employee
     * @param employee
     * @param id
     * @return updated employee
     */
    private Employee updateEmployee(Employee employee, Long id) {
        Employee updatedEmployee = employeeRepository.findEmployeeById(id);
        updatedEmployee.setFirstName(employee.getFirstName());
        updatedEmployee.setLastName(employee.getLastName());
        updatedEmployee.setCitizenship(employee.getCitizenship());
        updatedEmployee.setDegree(employee.getDegree());
        updatedEmployee.setPosition(employee.getPosition());
        updatedEmployee.setQualifications(new ArrayList<>(employee.getQualifications()));
        return updatedEmployee;
    }

    /**
     * private method to set the elements into the lists
     * @param qualification
     * @param employee
     */
    private void addQualificationToEmployee(Qualification qualification, Employee employee) {
        List<Qualification> qualificationList = employee.getQualifications();
        qualificationList.add(qualification);
        employee.setQualifications(qualificationList);

        List<Employee> employeeList = qualification.getEmployees();
        employeeList.add(employee);
        qualification.setEmployees(employeeList);

        qualificationRepository.save(qualification);
        employeeRepository.save(employee);
    }
}
