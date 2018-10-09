package de.detim.employeemanagement.helper;

import com.fasterxml.jackson.databind.ser.Serializers;
import de.detim.employeemanagement.exceptions.EmptyEntityException;
import de.detim.employeemanagement.exceptions.IdsNotMatchingException;

import java.util.List;

/**
 * Service-Interface mit CRUD-Operationen
 * @param <T>
 */
public interface ServiceEntity<T extends BaseEntity> {
    default void checkEntityNotNull(T t) {
        if (t == null) {
            throw new EmptyEntityException();
        }
    }

    default void checkEntityIdMatch(T t, Long id) {
        if (!t.getId().equals(id)) {
            throw new IdsNotMatchingException(t.getId(), id);
        }
    }
    /**
     * Creates a new Entity
     * @param t Entity to create
     * @return the created entity
     */
    T createEntity(T t);

    /**
     * Find an Entity with the given ID
     * @param id ID for the Entity
     * @return
     */
    T findEntity(Long id);
    T updateEntity(T t, Long id);

    /**
     * Deletes an entity with the give id
     * @param id id for entity to delete
     * @return id of the deleted entity
     */
    Long deleteEntityById(Long id);

    /**
     * Deletes the entity
     * @param t entity to delete
     * @return id of the deleted entity
     */
    Long deleteEntity(T t);

    /**
     * Returns all entities
     * @return An iterable of entities found
     */
    List<T> getEntities();

    /**
     * Counts the entities
     * @return Amount of entities found
     */
    Long count();
}
