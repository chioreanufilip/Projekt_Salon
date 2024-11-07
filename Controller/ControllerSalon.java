package Controller;

import repository.*;
import Module.*;
public class ControllerSalon {
    private final Repository<Barber> barberRepository;
    private final Repository<NailPainter> nailPainterRepository;
    private final Repository<Produce> produceRepository;
    private final Repository<Pedicurist> pedicuristRepository;

    public ControllerSalon(Repository<Barber> barberRepository, Repository<NailPainter> nailPainterRepository,
                           Repository<Produce> produceRepository, Repository<Pedicurist> pedicuristRepository) {
        this.barberRepository = barberRepository;
        this.nailPainterRepository = nailPainterRepository;
        this.produceRepository = produceRepository;
        this.pedicuristRepository = pedicuristRepository;
    }

//    InMemoryRepository barberrepo = new InMemoryRepository();
    public void enrollBarber(String name, String hairStyle, int experience, String speciality){
        barberRepository.create(new Barber(name,hairStyle,experience,speciality));

    }
    public void enrollNailPainter(){
//        nailPainterRepository.create(new NailPainter());
    }
    public void enrollPedicurist(){

    }
    public void addProduct(){

    }
}
