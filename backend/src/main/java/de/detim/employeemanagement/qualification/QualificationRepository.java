package de.detim.employeemanagement.qualification;

import org.springframework.data.repository.CrudRepository;

public interface QualificationRepository extends CrudRepository<Qualification, Long> {
    Qualification getByName (String name);
}
