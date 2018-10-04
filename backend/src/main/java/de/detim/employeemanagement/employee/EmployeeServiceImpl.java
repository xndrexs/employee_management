package de.detim.employeemanagement.employee;

import de.detim.employeemanagement.helper.EmptyEntityException;
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

    /**
     * Erstellt den übergebenen Benutzer in der Datenbank und gibt dieses Objekt zurück
     * @param employee Zu erstellender Benutzer
     * @return Gibt den neu erstellen Benutzer zurück / Null, wenn leer
     */
    @Override
    public Employee createEmployee(Employee employee) {
        Employee newEmployee = null;
        if (employee == null) {
            try {
                throw new EmptyEntityException("Employee is empty");
            } catch (EmptyEntityException e) {
                e.printStackTrace();
            }
        } else {
            newEmployee= employeeRepository.save(employee);
            logger.info("Employee created: %s %s", employee.getFirstName(), employee.getLastName());
        }
        return newEmployee;
    }

    @Override
    public Employee readEmployee(Long id) {
        return employeeRepository.findEmployeeId(id);
    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {
        deleteEmployee(id);
        Employee newEmployee = createEmployee(employee);
        logger.info("Employee updated: %s", employee.getLastName());
        return newEmployee;
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
