package de.detim.employeemanagement.qualification;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QualificationRepository extends JpaRepository<Qualification, Long> {
    Qualification findQualificationById(Long id);
}
