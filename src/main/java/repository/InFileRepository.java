package repository;
import java.io.IOException;
//import java.util.HashMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import Module.Employee;
import Module.Barber;
import Module.Pedicurist;
import Module.NailPainter;
import com.fasterxml.jackson.core.*;
//import com.fasterxml.jackson.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
//requires com.fasterxml.jackson.core;
//requires com.fasterxml.jackson.databind;
import com.fasterxml.jackson.core.StreamReadConstraints;
//import com.fasterxml.jackson.core.JsonParser$NumberTypeFP;

import Module.HasId;
import com.fasterxml.jackson.databind.node.ObjectNode;

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
//        if (obj.getClass())
//        System.out.println(obj.getClass().getSimpleName());
//        if(obj.getClass().getSimpleName().equals("Barber") || obj.getClass().getSimpleName().equals("Pedicurist") || obj.getClass().getSimpleName().equals("NailPainer")){
//            doInFile(data -> data.putIfAbsent(obj.getId(), Employee.class));
//        }
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
            objectMapper.registerSubtypes(Barber.class,NailPainter.class,Pedicurist.class);
            Map<Integer, Object> map = objectMapper.readValue(new File(file),new TypeReference<LinkedHashMap<Integer, Object>>() {}
            );//;System.out.println(Objects.requireNonNull(map));
            Map<Integer, T> resultMap = new LinkedHashMap<>();
            for (Map.Entry<Integer, Object> entry : map.entrySet()) {
                T value = objectMapper.convertValue(entry.getValue(), clazz); //deserieliaza
//                if (T.Module.Barber.class)
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
//        catch (IllegalArgumentException e){try{///aici trebuie sa scrii cum sa deserializezi service, pt ca are lista de clasa abstracta
//            ObjectMapper objectMapper = new ObjectMapper();
//            Map<Integer, Object> map = objectMapper.readValue(new File(file),new TypeReference<LinkedHashMap<Integer, Object>>() {}
//            );
//            Map<Integer, Module.Service> resultMap = new LinkedHashMap<>();
//            for (Map.Entry<Integer, Object> entry : map.entrySet()) {
//                Module.Service value = objectMapper.convertValue(entry.getValue(), Module.Service.class); //deserieliaza
//                T val=
//                resultMap.put(entry.getKey(), value);
//            }
//            return resultMap;
//        }
//        catch (IOException  i) {
//            return new LinkedHashMap<>();
//        }
//        }

    }
    /**
     * Writes the data to the file.
     *
     * @param data The data to write to the file.
     */
    ///manually adding type to each data.value
    private void writeDataToFile(Map<Integer, T> data) {
        ObjectMapper objmapper = new ObjectMapper();
//        String jsonString = new (data).toString();
        Map<Integer,ObjectNode> serializedData=new HashMap<>();
        try {
            if (data.isEmpty()) {
                objmapper.writeValue(new File(file), "{}"); }
//            serializedData.
            for (Map.Entry<Integer, T> entry : data.entrySet()) {
                ObjectNode node = objmapper.valueToTree(entry.getValue());
                if (entry.getValue() instanceof Barber){
                    node.put("type", "Barber");
                }
                else if (entry.getValue() instanceof NailPainter){
                    node.put("type", "NailPainter");
                }
                else if (entry.getValue() instanceof Pedicurist){
                    node.put("type", "Pedicurist");
                }
                serializedData.put(entry.getKey(), node);
//                if (entry.getValue().getClass().equals(Barber.class)||entry.getValue().getClass().equals(NailPainter.class)|| entry.getValue().getClass().equals(Pedicurist.class)) {
//                    Employee n= new Barber();
//                    entry.getValue();
//                    data.values()

//                    entry.getValue().
//                }
            }
            objmapper.writeValue(new File(file), serializedData);
//            oos.writeObject(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
