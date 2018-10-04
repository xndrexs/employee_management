package de.detim.employeemanagement.qualification;


public interface QualificationService {
    void createQualification(Qualification qualification);
    Qualification readQualification(Long id);
    void updateQualification(Qualification qualification, Long id);
    void deleteQualification(Long id);
    Iterable<Qualification> getQualifications();
}