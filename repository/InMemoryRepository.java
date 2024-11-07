package repository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Module.HasId;


public class InMemoryRepository<T extends HasId> implements Repository<T> {
    private final Map<Integer, T> data = new HashMap<>();
    @Override
public void create(T object) {
    data.putIfAbsent(object.getId(), object);
    }
public void update(T object) {
    data.replace(object.getId(), object);
}
public void delete(Integer id) {
    data.remove(id);
}
public List<T> getAll() {
    return data.values().stream().toList();
}
public T getById(int id) {
    return data.get(id);
}
}
