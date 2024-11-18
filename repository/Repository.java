package repository;

import java.util.List;

/**
 * A generic interface for a repository that defines basic CRUD (Create, Read, Update, Delete) operations
 * for managing objects of type T.
 *
 * @param <T> the type of objects this repository will manage
 */
public interface Repository<T> {

    /**
     * Creates a new object in the repository.
     *
     * @param obj the object to be created
     */
    void create(T obj);

    /**
     * Updates an existing object in the repository.
     * If the object does not exist, it will be added.
     *
     * @param obj the object to be updated
     */
    void update(T obj);

    /**
     * Deletes an object from the repository by its ID.
     *
     * @param id the ID of the object to be deleted
     */
    void delete(Integer id);

    /**
     * Retrieves all objects stored in the repository.
     *
     * @return a list of all objects in the repository
     */
    List<T> getAll();

    /**
     * Retrieves an object from the repository by its ID.
     *
     * @param id the ID of the object to retrieve
     * @return the object with the specified ID, or null if not found
     */
    T getById(Integer id);
}
