package de.detim.employeemanagement.qualification;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class QualificationServiceImpl implements QualificationService {

    private QualificationRepository qualificationRepository;

    public QualificationServiceImpl(QualificationRepository qualificationRepository) {
        this.qualificationRepository = qualificationRepository;
    }

    @Override
    public void createEntity(Qualification qualification) {
        qualificationRepository.save(qualification);
        log.info("Qualification created: {}", qualification.getName());
    }

    @Override
    public Qualification readEntity(Long id) {
        return null;
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
}