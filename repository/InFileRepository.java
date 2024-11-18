package repository;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
//import Module.Barber;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;

import repository.Repository;
import Module.HasId;

import java.io.File;

public class InFileRepository<T extends HasId> implements Repository<T> {
    private final String file;
    private final Class<T> clazz;


public InFileRepository(String file,Class<T> clazz) {
this.file = file;
this.clazz = clazz;
}

/**
* *  {@inheritDoc}
*/
    @Override
    public void create(T obj) {
        doInFile(data -> data.putIfAbsent(obj.getId(), obj));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T getById(Integer id) {
        return readDataFromFile().get(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(T obj) {
        doInFile(data -> data.replace(obj.getId(), obj));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Integer id) {
        doInFile(data -> data.remove(id));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<T> getAll() {
        return readDataFromFile().values().stream().toList();
    }

    /**
     * Performs an operation on the data stored in the file.
     *
     * @param function The function to apply to the data.
     */
    private void doInFile(Consumer<Map<Integer, T>> function) {
        Map<Integer, T> data = readDataFromFile();
        function.accept(data);//System.out.println(data.size());
//        if (data.isEmpty()){
//            System.out.println("Empty file");
//        }
        writeDataToFile(data);
    }
    /**
     * Reads the data from the file.
     *
     * @return The  data stored in the file, or an empty map if the file is empty or does not exist.
     */
    private Map<Integer, T> readDataFromFile() {
        try {//(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<Integer, Object> map = objectMapper.readValue(new File(file),new TypeReference<LinkedHashMap<Integer, Object>>() {}
            );//;System.out.println(Objects.requireNonNull(map));
            Map<Integer, T> resultMap = new LinkedHashMap<>();
            for (Map.Entry<Integer, Object> entry : map.entrySet()) {
                T value = objectMapper.convertValue(entry.getValue(), clazz); //deserieliaza
                resultMap.put(entry.getKey(), value);
            }
            return  resultMap;
//            return (Map<Integer, T>) ois.readObject();
        }
//        catch (IOExc  e ) {
//            return new LinkedHashMap<>();
//        }
//        catch (JsonMappingException | JsonParseException e) {
//            return new LinkedHashMap<>();
//        }
//        } catch (JsonParseException e) {
//            return new LinkedHashMap<>();
//        }
        catch (IOException  e) {
            return new LinkedHashMap<>();
        }

    }
    /**
     * Writes the data to the file.
     *
     * @param data The data to write to the file.
     */
    private void writeDataToFile(Map<Integer, T> data) {
        ObjectMapper objmapper = new ObjectMapper();
//        String jsonString = new (data).toString();
        try {
            if (data.isEmpty()) {
                objmapper.writeValue(new File(file), "{}"); }
            objmapper.writeValue(new File(file), data);
//            oos.writeObject(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
