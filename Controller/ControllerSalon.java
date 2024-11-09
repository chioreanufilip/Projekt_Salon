package Controller;

import repository.*;
import Module.*;

import java.time.Duration;
import java.util.List;

public class ControllerSalon {
    private final Repository<Barber> barberRepository;
    private final Repository<NailPainter> nailPainterRepository;
    private final Repository<Produce> produceRepository;
    private final Repository<Pedicurist> pedicuristRepository;
    private final Repository<Service> serviceRepository;

    public ControllerSalon(Repository<Barber> barberRepository, Repository<NailPainter> nailPainterRepository,
                           Repository<Produce> produceRepository, Repository<Pedicurist> pedicuristRepository,
    Repository<Service> serviceRepository) {
        this.barberRepository = barberRepository;
        this.nailPainterRepository = nailPainterRepository;
        this.produceRepository = produceRepository;
        this.pedicuristRepository = pedicuristRepository;
        this.serviceRepository = serviceRepository;
    }

//    InMemoryRepository barberrepo = new InMemoryRepository();
    public void enrollBarber(String name, String hairStyle, int experience, String speciality,Integer id){
        barberRepository.create(new Barber(name,hairStyle,experience,speciality,id));

    }
    public void deleteBarber(Integer id){
        barberRepository.delete(id);
    }
    public void enrollNailPainter(String name,int experience,String speciality,String gelNailExperience,Integer id){
        nailPainterRepository.create(new NailPainter(name,experience,speciality,gelNailExperience,id));
    }
    public void deleteNailPainter(Integer id){
        nailPainterRepository.delete(id);
    }
    public void enrollPedicurist(String name,Integer experience,String speciality, String FootCareSpecialisation,Integer id){
        pedicuristRepository.create(new Pedicurist(name,experience,speciality,FootCareSpecialisation,id));
    }
    public void deletePedicurist(Integer id){
        pedicuristRepository.delete(id);
    }
    public void addProduct(String name, Double price, Integer stock,Integer type,Integer id){
        produceRepository.create(new Produce(name,price,stock,type, id));
    }
    public void deleteProduct(Integer id){
        produceRepository.delete(id);
    }
    public List<Produce> getAllProduce(){
        return produceRepository.getAll();
    }
    public void addService(int ID, String name, Duration duration, double price, Integer type){
        serviceRepository.create(new Service(ID,name,duration,price,type));
    }
    public List<Service> getAllServices(){
        return serviceRepository.getAll();
    }

}
