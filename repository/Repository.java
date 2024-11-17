package repository;
import java.util.List;

public interface Repository <T > {
    void create(T obj);
    void update(T obj);
    void delete(Integer id);
    List<T> getAll();
    T getById(Integer id);

//    /**
//     * Retrieves an object from the repository by its ID.
//     *
//     * @param id The unique identifier of the object to retrieve.
//     * @return The object with the specified ID, or null if not found.
//     */
//    T get(Integer id);
}
