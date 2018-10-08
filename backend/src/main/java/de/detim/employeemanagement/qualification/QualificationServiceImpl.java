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
    public void createQualification(Qualification qualification) {
        qualificationRepository.save(qualification);
        log.info("Qualification created %s: ", qualification.getName());
    }

    @Override
    public Qualification readQualification(Long id) {
        return null;
    }

    @Override
    public void updateQualification(Qualification qualification, Long id) {
        deleteQualification(id);
        createQualification(qualification);
        log.info("Qualification updated: %s", qualification.getName());
    }

    @Override
    public void deleteQualification(Long id) {
        qualificationRepository.deleteById(id);
        log.info("Qualification deleted: %s", id);
    }

    @Override
    public Iterable<Qualification> getQualifications() {
        return qualificationRepository.findAll();
    }
}