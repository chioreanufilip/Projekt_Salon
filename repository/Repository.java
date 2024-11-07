package repository;
import java.util.List;

public interface Repository <T > {
    void create(T obj);
    void update(T obj);
    void delete(Integer id);
    List<T> getAll();
    T getById(int id);
}
