package APP;
import repository.DBRepo.*;
import repository.Repository;
import  Module.Barber;
import Module.Pedicurist;
import Module.NailPainter;
import Module.Produce;
import Module.Client;
import Module.Review;
import Module.Service;
import Module.Employee;
import Module.Payment;
import Module.Appointment;

import java.util.ArrayList;
import java.util.List;

public class SalonAppDB {
    public static void main(String[] args) {
        String DBUrl ="jdbc:sqlserver://Romana_mobile;Database=BarberShop;trustServerCertificate=true;user=barbershop;password=12345;";
//        String DBUrl ="jdbc:sqlserver://localhost:1434;database=BarberShop;";
//        String DBUrl = "jdbc:sqlserver://Romana_mobile:1433;databaseName=BarberShop;encrypt=true;trustServerCertificate=true;integratedSecurity=true;";

        Repository<Barber> repoBarb =new BarberDBRepo(DBUrl);
        Repository<Pedicurist> repoPedi = new PedicuristDBRepo(DBUrl);
        Repository<NailPainter> repoNail = new NailPainterDBRepo(DBUrl);
        Repository<Produce> repoProduce = new ProductDBRepo(DBUrl);
        Repository<Client> repoClient = new ClientDBRepo(DBUrl);
        Repository<Review> repoReview = new ReviewDBRepo(DBUrl);
        Repository<Service> repoService = new ServiceDBRepo(DBUrl);
        Repository<Payment> repoPayment = new PaymentDBRepo(DBUrl);
        Repository<Appointment> repoAppointment = new AppointmentDBRepo(DBUrl);
        Barber m = new Barber("Yunus","Fade",3,"fade",5);
        Barber n = new Barber("Yunus","Fade",3,"fade",4);
        Pedicurist m1 = new Pedicurist("Bula",5,"apa","Matrix",1);
        Pedicurist n1 = new Pedicurist("Bula",5,"apa","Matrix",2);
        NailPainter m2 = new NailPainter("Hrusca",5,"apa","Matrix",1);
        NailPainter n2 = new NailPainter("Hrusca",5,"apa","Matrix",2);
        Produce m3 = new Produce("Shaorma",12.35,3,1,1);
        Produce n3 = new Produce("Shaorma",12.35,3,1,2);
        Client m4 = new Client(1,"Viorel","0757");
        Client n4 = new Client(2,"Viorel","0757");
        Review m5 = new Review(1,1,"haha",1);
        Review n5 = new Review(2,1,"haha",2);
        List<Employee> list=new ArrayList<>();
        List<Employee> list1=new ArrayList<>();
        list.add(m);
        list.add(m1);
        list1.add(m2);
        list1.add(n);
        Service m6 = new Service(1,"Shaorma","10 Min",65,list);
        Service n6 = new Service(2,"Shaorma","10 Min",65,list1);
        List<Service> list2=new ArrayList<>();
        list2.add(m6);
        list2.add(n6);
        List<Produce> list3=new ArrayList<>();
        list3.add(m3);
        list3.add(n3);
        Payment m7 = new Payment(1,list2,list3,1);
        Payment n7 = new Payment(2,list2,list3,1);
        Appointment m8 = new Appointment(1,"50-50-50-50",m4,list2,m7);
        Appointment n8 = new Appointment(2,"50-50-50-60",n4,list2,n7);
        repoBarb.create(m);
        repoBarb.create(n);
        repoPedi.create(m1);
        repoPedi.create(n1);
        repoNail.create(m2);
        repoNail.create(n2);
        repoProduce.create(m3);
        repoProduce.create(n3);
        repoClient.create(m4);
        repoClient.create(n4);
        repoReview.create(m5);
        repoReview.create(n5);
        repoService.create(m6);
        repoService.create(n6);
        repoPayment.create(m7);
        repoPayment.create(n7);
        repoAppointment.create(m8);
        repoAppointment.create(n8);

//        m.setExperience(4);
//        m1.setExperience(3);
//        m2.setExperience(3);
//        m3.setStock(69);
//        m4.setName("Ciob");
//        m5.setRating(2);
//        m6.setPrice(50);
//        m7.setClientId(2);
//        m8.setDateTime("70");
//        repoPedi.update(m1);
//        repoNail.update(m2);
//        repoProduce.update(m3);
//        repoClient.update(m4);
//        repoReview.update(m5);
//        repoService.update(m6);
//        repoPayment.update(m7);
//        repoAppointment.update(m8);
//        repoPedi.delete(1);
//        repoNail.delete(1);
////        repoClient.delete(2);
//        repoProduce.delete(2);
//        repoService.delete(2);
//        repoPayment.delete(2);
//        repoAppointment.delete(2);
//List<Service> barb =repoService.getAll();
//for(Service b:barb) {
//    System.out.println(b.getEmployees().getFirst().getName());
//}
//        List<Service> allServices = repoService.getAll();
//System.out.println(allServices.get(0).getEmployees().size());

//        System.out.println(repoBarb.getById(1).getName());
//        System.out.println(repoAppointment.getById(1).getClient().getName());
//        System.out.println(repoAppointment.getById(1).getClient().getName());
//        try {
//            throw new EntityNotFoundException ();
//        }
//        catch (EntityNotFoundException e){System.out.println(e.getCause()+"Still here");}
//System.out.println(repoAppointment.getAll().getLast().getPayment().getAmount());
        Appointment appointment = repoAppointment.getById(repoAppointment.getAll().size()-1);
        appointment.getPayment().setAmount(appointment.getPayment().getAmount()*0.5);
        System.out.println(appointment.getPayment().getAmount());
        repoPayment.update(appointment.getPayment());
        System.out.println(repoPayment.getById(repoPayment.getAll().size()-1).getAmount());
        repoAppointment.update(appointment);
        System.out.println(repoAppointment.getById(repoAppointment.getAll().size()-1).getPayment().getAmount());

    }
}
