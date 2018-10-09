package de.detim.employeemanagement.qualification;

import de.detim.employeemanagement.employee.Employee;
import de.detim.employeemanagement.employee.EmployeeRepository;
import de.detim.employeemanagement.exceptions.EmptyEntityException;
import de.detim.employeemanagement.exceptions.EntityNotFoundException;
import de.detim.employeemanagement.exceptions.IdsNotMachtingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class QualificationServiceImpl implements QualificationService {

    private final QualificationRepository qualificationRepository;
    private final EmployeeRepository employeeRepository;

    public QualificationServiceImpl(QualificationRepository qualificationRepository, EmployeeRepository employeeRepository) {
        this.qualificationRepository = qualificationRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Qualification createEntity(Qualification qualification) {
        if (qualification == null) {
            throw new EmptyEntityException();
        } else {
            qualificationRepository.save(qualification);
            log.info("Qualification created: {}", qualification.getName());
        }
        return qualification;
    }

    @Override
    public Qualification findEntity(Long id) {
        return qualificationRepository.findQualificationById(id);
    }

    @Override
    public Qualification updateEntity(Qualification qualification, Long id) {
        Qualification updatedQualification = null;
        if (qualification == null) {
            throw new EmptyEntityException();
        } else if (qualification.getId() == id) {
            throw new IdsNotMachtingException(qualification.getId(), id);
        } else if (!employeeRepository.existsById(id)){
            throw new EntityNotFoundException();
        } else {
            updatedQualification = qualificationRepository.findQualificationById(id);
            updatedQualification.updateQualification(qualification);
            qualificationRepository.save(qualification);
            log.info("Qualification updated: {}", qualification.getName());
        }
        return updatedQualification;
    }

    @Override
    public Long deleteEntityById(Long id) {
        qualificationRepository.deleteById(id);
        log.info("Qualification deleted: {}", id);
        return id;
    }

    @Override
    public Long deleteEntity(Qualification qualification) {
        Long id = qualification.getId();
        qualificationRepository.delete(qualification);
        log.info("Qualification deleted: {}", qualification.getName());
        return id;
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
    public Qualification addEmployee(Qualification qualification, Employee employee) {
        qualification.addEmployee(employee);
        employee.addQualification(qualification);
        qualificationRepository.save(qualification);
        employeeRepository.save(employee);
        log.info("Employee '{}' added to {}.", employee.getLastName(), qualification.getName());
        return qualification;
    }
}