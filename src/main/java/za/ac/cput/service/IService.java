package za.ac.cput.service;

import java.util.List;
import java.util.Optional;

/**
 * Generic service interface for CRUD operations
 * This is the main building block of Domain Driven Design service layer
 * 
 * @param <T> The entity type
 * @param <ID> The identifier type
 */
public interface IService<T, ID> {
    
    /**
     * Create a new entity
     * @param entity the entity to create
     * @return the created entity
     */
    T create(T entity);
    
    /**
     * Read an entity by ID
     * @param id the entity ID
     * @return optional containing entity if found
     */
    Optional<T> read(ID id);
    
    /**
     * Update an existing entity
     * @param entity the entity to update
     * @return the updated entity
     * @throws IllegalArgumentException if entity doesn't exist
     */
    T update(T entity);
    
    /**
     * Delete an entity by ID
     * @param id the entity ID to delete
     * @return true if deleted, false if not found
     */
    boolean delete(ID id);
    
    /**
     * Get all entities
     * @return list of all entities
     */
    List<T> getAll();
}
