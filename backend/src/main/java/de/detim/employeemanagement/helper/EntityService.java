package de.detim.employeemanagement.helper;

/*
Service-Interface mit CRUD-Operationen
 */
public interface EntityService<T extends EntityBase> {

    void createEntity(T t);
    T readEntity(Long id);
    void updateEntity(T t, Long id);
    void deleteEntityById(Long id);
    void deleteEntity(T t);
    Iterable<T> getEntities();
    Long count();
}
