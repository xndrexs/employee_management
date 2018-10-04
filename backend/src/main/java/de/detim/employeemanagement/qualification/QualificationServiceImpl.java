package de.detim.employeemanagement.qualification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class QualificationServiceImpl implements QualificationService {

    private Logger logger = LoggerFactory.getLogger(QualificationServiceImpl.class);
    private QualificationRepository qualificationRepository;

    @Override
    public void createQualification(Qualification qualification) {
        qualificationRepository.save(qualification);
        logger.info("Qualification created %s: ", qualification.getName());
    }

    @Override
    public Qualification readQualification(Long id) {
        return null;
    }

    @Override
    public void updateQualification(Qualification qualification, Long id) {
        deleteQualification(id);
        createQualification(qualification);
        logger.info("Qualification updated: %s", qualification.getName());
    }

    @Override
    public void deleteQualification(Long id) {
        qualificationRepository.deleteById(id);
        logger.info("Qualification deleted: %s", id);
    }

    @Override
    public Iterable<Qualification> getQualifications() {
        return qualificationRepository.findAll();
    }
}