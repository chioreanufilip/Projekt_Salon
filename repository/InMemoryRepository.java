package repository;

import Module.HasId;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;

/**
 * In-memory repository that implements the {@link Repository} interface for storing and managing objects of type T,
 * where T is any class that implements the {@link HasId} interface. This repository uses a {@link LinkedHashMap}
 * to store objects, allowing access, creation, updating, and deletion of objects based on their ID.
 *
 * @param <T> the type of objects managed by this repository, which must implement the {@link HasId} interface
 */
public class InMemoryRepository<T extends HasId> implements Repository<T> {

    private final Map<Integer, T> data = new LinkedHashMap<>();

    /**
     * Creates a new object in the repository.
     * If the object with the same ID already exists, it will not be added.
     *
     * @param object the object to be created in the repository
     */
    @Override
    public void create(T object) {
        data.putIfAbsent(object.getId(), object);
    }

    /**
     * Updates an existing object in the repository.
     * If the object does not exist, it will be added.
     *
     * @param object the object to be updated in the repository
     */
    @Override
    public void update(T object) {
        data.replace(object.getId(), object);
    }

    /**
     * Deletes an object from the repository by its ID.
     *
     * @param id the ID of the object to be deleted
     */
    @Override
    public void delete(Integer id) {
        data.remove(id);
    }

    /**
     * Retrieves all objects stored in the repository as a list.
     *
     * @return a list of all objects in the repository
     */
    @Override
    public List<T> getAll() {
        return data.values().stream().toList();
    }

    /**
     * Retrieves an object from the repository by its ID.
     *
     * @param id the ID of the object to retrieve
     * @return the object with the specified ID, or null if not found
     */
    @Override
    public T getById(Integer id) {
        return data.get(id);
    }
}
