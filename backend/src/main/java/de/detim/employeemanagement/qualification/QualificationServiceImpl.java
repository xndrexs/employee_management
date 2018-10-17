package de.detim.employeemanagement.qualification;

import de.detim.employeemanagement.employee.Employee;
import de.detim.employeemanagement.employee.EmployeeRepository;
import de.detim.employeemanagement.exceptions.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        checkEntityNotNull(qualification);
        qualificationRepository.save(qualification);
        log.info("Qualification created: {}", qualification.getName());
        return qualification;
    }

    @Override
    public Qualification findEntity(Long id) {
        return qualificationRepository.findQualificationById(id);
    }

    @Override
    public Qualification findEntityByName(String name) {
        return qualificationRepository.findQualificationByName(name);
    }

    @Override
    public Qualification updateEntity(Qualification qualification, Long id) {
        checkEntityNotNull(qualification);
        checkEntityIdMatch(qualification, id);
        if (!qualificationRepository.existsById(id)){
            throw new EntityNotFoundException();
        }
        Qualification updatedQualification = updateQualification(qualification, id);
        qualificationRepository.save(updatedQualification);
        log.info("Qualification updated: {}", updatedQualification.getName());
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
    public List<Qualification> findAll() {
        return qualificationRepository.findAll();
    }

    @Override
    public Long count() {
        return qualificationRepository.count();
    }

    /**
     * Add an employee to the qualification
     * @param qualification Qualifikation, welcher ein Mitarbeiter hinzugefügt werden soll
     * @param employee Mitarbeiter, welcher der übergebenen Qualifikation hinzugefügt werden soll
     * @return
     */
    @Override
    public Qualification addEmployee(Qualification qualification, Employee employee) {
        addEmployeeToQualification(qualification, employee);
        log.info("Qualification '{}' added to {}.", employee.getLastName(), qualification.getName());
        return qualification;
    }

    /**
     * Private method for setting the elements into the lists
     * @param qualification
     * @param employee
     */
    private void addEmployeeToQualification(Qualification qualification, Employee employee) {
        qualification.getEmployees().add(employee);
        employee.getQualifications().add(qualification);
        qualificationRepository.save(qualification);
        employeeRepository.save(employee);
    }

    /**
     * Private method to help update the qualification
     * @param qualification
     * @param id
     * @return
     */
    private Qualification updateQualification(Qualification qualification, Long id) {
        Qualification updatedQualification = qualificationRepository.findQualificationById(id);
        updatedQualification.setName(qualification.getName());
        updatedQualification.setEmployees(new ArrayList<>(qualification.getEmployees()));
        qualificationRepository.save(qualification);
        return updatedQualification;
    }
}