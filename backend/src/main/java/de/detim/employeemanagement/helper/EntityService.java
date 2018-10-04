package de.detim.employeemanagement.helper;


import java.util.Map;

public interface EntityService {

    // CRUD
    void createEntity(EntityBase entity);
    EntityBase readEntity(Long id);
    void updateEntity(EntityBase entity, Long id);
    void deleteEntity(Long id);
    Map<Long, EntityBase> getEntities();

}
