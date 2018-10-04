package de.detim.employeemanagement.helper;

import java.util.List;

public interface EntityService {

    // CRUD
    void createEntity(EntityBase entity);
    void readEntity(String id);
    void updateEntity(EntityBase entity, String id);
    void deleteEntity(String id);
    List<EntityBase> getEntities();

}
