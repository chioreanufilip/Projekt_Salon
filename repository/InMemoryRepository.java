package repository;

import Module.HasId;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class InMemoryRepository<T extends HasId> implements Repository<T> {
    private final Map<Integer, T> data = new HashMap<>();


    @Override
public void create(T object) {
    data.putIfAbsent(object.getId(), object);
//    System.out.println(data.get(object.getId()));
    }
    @Override
public void update(T object) {
    data.replace(object.getId(), object);
}
@Override
public void delete(Integer id) {
    data.remove(id);
}
@Override
public List<T> getAll() {
    return data.values().stream().toList();
}
@Override
public T getById(int id) {
    return data.get(id);
}


}
