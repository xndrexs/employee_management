package de.detim.employeemanagement.qualification;

import de.detim.employeemanagement.employee.Employee;
import de.detim.employeemanagement.employee.EmployeeRepository;
import de.detim.employeemanagement.helper.EmptyEntityException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class QualificationServiceImpl implements QualificationService {

    private final QualificationRepository qualificationRepository;
    private final EmployeeRepository employeeRepository;

    public QualificationServiceImpl(QualificationRepository qualificationRepository, EmployeeRepository employeeRepository, EmployeeRepository employeeRepository1) {
        this.qualificationRepository = qualificationRepository;
        this.employeeRepository = employeeRepository1;
    }

    @Override
    public void createEntity(Qualification qualification) {
        if (qualification == null) {
            try {
                throw new EmptyEntityException("Entity must not be empty");
            } catch (EmptyEntityException e) {
                e.printStackTrace();
            }
        } else {
            qualificationRepository.save(qualification);
            log.info("Qualification created: {}", qualification.getName());
        }
    }

    @Override
    public Qualification readEntity(Long id) {
        return qualificationRepository.findQualificationById(id);
    }

    @Override
    public void updateEntity(Qualification qualification, Long id) {
        deleteEntityById(id);
        createEntity(qualification);
        log.info("Qualification updated: {}", qualification.getName());
    }

    @Override
    public void deleteEntityById(Long id) {
        qualificationRepository.deleteById(id);
        log.info("Qualification deleted: {}", id);
    }

    @Override
    public void deleteEntity(Qualification qualification) {
        qualificationRepository.delete(qualification);
        log.info("Qualification deleted: {}", qualification.getName());
    }

    @Override
    public Iterable<Qualification> getEntities() {
        return qualificationRepository.findAll();
    }

    @Override
    public Long count() {
        return qualificationRepository.count();
    }

    @Override
    public void addEmployee(Qualification qualification, Employee employee) {
        qualification.addEmployee(employee);
        employee.addQualification(qualification);
        qualificationRepository.save(qualification);
        employeeRepository.save(employee);

    }
}