package APP;

import Module.Barber;
import Module.NailPainter;
import Module.Pedicurist;
import Module.Produce;
import repository.InMemoryRepository;
import repository.Repository;
import Controller.ControllerSalon;
import Module.Service;

import java.awt.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class SalonApp {
//    private final Controller =Controller;
//    ControllerSalon controller = new ControllerSalon();
    public SalonApp() {
//        this.Controller = controller;
    }
    Repository<Barber> repoBarb = new InMemoryRepository<Barber>();
    Repository<NailPainter> repoNail = new InMemoryRepository<NailPainter>();
    Repository<Pedicurist> repoPedi = new InMemoryRepository<Pedicurist>();
    Repository<Produce> repoProduct = new InMemoryRepository<Produce>();
    Repository<Service> repoService = new InMemoryRepository<Service>();
    ControllerSalon controllerSalon = new ControllerSalon(repoBarb,repoNail,repoProduct,repoPedi,repoService);
    public void initialize(){
        repoBarb.create(new Barber("Bob","Wolfcut, Fades, Fringe",1,"Wolfcut",1));
        repoNail.create(new NailPainter("Costel",2,"NailPainting","yes",1));
        repoPedi.create(new Pedicurist("Marcel",1,"Massage, nailpainting","University of Feet",1));
        repoProduct.create(new Produce("Hairdye Blue",15.23,5,1,1));
        repoProduct.create(new Produce("Hairdye Red",15.23,5,1,2));
        repoProduct.create(new Produce("Nail Polish",45.83,15,4,3));
        repoProduct.create(new Produce("Nail gel",5.83,4,4,4));
        repoProduct.create(new Produce("Foot Scrub",25.83,9,3,5));
        repoService.create(new Service(1,"Haircut", Duration.ofMinutes(50),50,1));
        repoService.create(new Service(2,"Finger Nail Painting", Duration.ofMinutes(45),100,4));
        repoService.create(new Service(3,"FootMassage", Duration.ofMinutes(55),120,3));

    }
    public void menu() {
        initialize();
//        Repository<Barber> repoBarb = new InMemoryRepository<Barber>();
//        Repository<NailPainter> repoNail = new InMemoryRepository<NailPainter>();
//        Repository<Pedicurist> repoPedi = new InMemoryRepository<Pedicurist>();
//        Repository<Produce> repoProduct = new InMemoryRepository<Produce>();
//        ControllerSalon controllerSalon = new ControllerSalon(repoBarb,repoNail,repoProduct,repoPedi);
        System.out.println("Welcome to Menu: \n" +
                "1-make appointment\n" +
                "2-admin");
        Scanner scan = new Scanner(System.in);
        int selection = scan.nextInt();
        switch (selection) {
            case 1:
                System.out.println("Please select a service you want to make appointment: \n" );
                List<Service> allServices = controllerSalon.getAllServices();
                for (int i =1;i<allServices.size()+1;i++){
                    System.out.println(i+" "+allServices.get(i-1).getName());
                }
                Scanner scan9 = new Scanner(System.in);
                int services = scan9.nextInt();/// aici decizia de service ar trebui bagata in apointment
                List<Produce> allProduce = controllerSalon.getAllProduce();
                System.out.println("Please select the product that you want the employee to use on you: ");
                for (int i=0;i<allProduce.size();i++){
                    if (allProduce.get(i).getType()==allServices.get(services-1).getType()){
                        System.out.println(i+1+" "+allProduce.get(i).getName()+" "+allProduce.get(i).getPrice()+ " Lei ardelenesti");
                    }
            }
                List<Produce> products=new ArrayList<Produce>() ;
                int choice1=scan9.nextInt();
                products.add(allProduce.get(choice1-1));
                int yes=1;
                while (yes==1) {
                    System.out.println("Want to choose another product?: \n" +
                            "1-yes\n" +
                            "2-no\n");
                    yes = scan9.nextInt();
                    if (yes==1){
                        for (int i=0;i<allProduce.size();i++){
                            if (allProduce.get(i).getType()==allServices.get(services-1).getType()){
                                System.out.println(i+1+" "+allProduce.get(i).getName()+" "+allProduce.get(i).getPrice()+ " Lei ardelenesti");
                            }
                        }
                         choice1=scan9.nextInt();
                        products.add(allProduce.get(choice1-1));
                    }
                }



                ///si de aici pui in apointment si calculezi pretu unde il faci +pretul produselor din products.
//                allServices.forEach(System.out.println(.););
                break;
            case 2:
                System.out.println("1- create\n" +
                        "2- delete");

        Scanner scan1 = new Scanner(System.in);
        int selection1 = scan1.nextInt();
        switch (selection1) {
            case 1:
                System.out.println("1- Barber\n" +
                        "2- NailPainter\n" +
                        "3- Pedicurist\n" +
                        "4- Product");
                Scanner scan2 = new Scanner(System.in);
                int selection2 = scan2.nextInt();
                switch (selection2) {
                    case 1:
//                        Scanner scan3 = new Scanner(System.in);
                        System.out.println("Enter Name");
                        String name = scan2.next();
                        System.out.println("Enter Hairstyles:\n");
                        String hairstyles = scan2.next();
                        System.out.println("Enter how many years of experience:\n");
                        int experience = scan2.nextInt();
                        System.out.println("Enter what he specializes in:\n");
                        String specialize = scan2.next();
                        System.out.println("Enter id: ");
                        Integer id = scan2.nextInt();
                        controllerSalon.enrollBarber(name, hairstyles, experience, specialize,id);
//                        repoBarb.getAll().forEach(System.out::println);
//                        for (int i =0;i<repoBarb.getAll().size();i++){
//                            System.out.println(repoBarb.getAll().get(i).getName());
//                        }
//                        Barber ion = new Barber(name, hairstyles, experience, specialize);
//                        System.out.println(ion.getSizeBarber());
//                        System.out
                        menu();
                        break;
                    case 2:
                        System.out.println("Enter Name");
                        String name1 = scan2.next();
                        System.out.println("Enter the speciality:\n");
                        String speciality = scan2.next();
                        System.out.println("Enter how many years of experience:\n");
                        int experience1 = scan2.nextInt();
                        System.out.println("what kind of experience do you have with gel:\n");
                        String gelExperience = scan2.next();
                        System.out.println("Enter id: ");
                        Integer id2 = scan2.nextInt();
                        controllerSalon.enrollNailPainter(name1,experience1,speciality,gelExperience,id2);
//                        NailPainter ionica = new NailPainter(name1, experience1, speciality, gelExperience);
//                        System.out.println(ionica.getSize());
                        menu();
                        break;
                    case 3:
                        System.out.println("Enter Name");
                        String name2 = scan2.next();
                        System.out.println("Enter the speciality:\n");
                        String speciality3 = scan2.next();
                        System.out.println("Enter how many years of experience:\n");
                        int experience3 = scan2.nextInt();
                        System.out.println("write what kind of Foot Care Speciality you have:\n");
                        String footCare = scan2.next();
                        System.out.println("Enter id: ");
                        Integer id1 = scan2.nextInt();
//                        Pedicurist ionicosul = new Pedicurist(name2, experience3, speciality3, footCare);
//                        System.out.println(ionicosul.getSize());
                        controllerSalon.enrollPedicurist(name2,experience3,speciality3,footCare,id1);
                        menu();
                        break;
                    case 4:
                        System.out.println("Enter the name of the product: ");
                        String productName = scan.next();
                        System.out.println("Write the price you are selling it for:\n");
                        double price = scan.nextDouble();
                        System.out.println("How many do you have: \n");
                        int stock = scan.nextInt();
                        System.out.println("Enter id: ");
                        int id3 = scan.nextInt();
                        System.out.println("Will this be used by: \n" +
                                "1-Barber\n" +
                                "2-NailPainter\n" +
                                "3-Pedicurist\n" +
                                "4-Both NailPainter and Pedicurist");
                        int type = scan.nextInt();
//                        Produce produce = new Produce(productName, price, stock,id3);
                        controllerSalon.addProduct(productName,price,stock,type,id3);
                        menu();
                }
            break;
            case 2:
                System.out.println("What do you want to delete: \n" +
                        "1- Barber\n" +
                        "2- NailPainter\n" +
                        "3- Pedicurist\n" +
                        "4- Product");
                int choise =scan.nextInt();
                switch (choise) {
                    case 1:
                        System.out.println("Enter id");
                        int id = scan.nextInt();
                        controllerSalon.deleteBarber(id);
                        menu();
                        break;
                    case 2:
                        System.out.println("Enter id");
                        int id2 = scan.nextInt();
                        controllerSalon.deleteNailPainter(id2);
                        menu();
                        break;
                    case 3:
                        System.out.println("Enter id");
                        int id3 = scan.nextInt();
                        controllerSalon.deletePedicurist(id3);
                        menu();
                        break;
                    case 4:
                        System.out.println("Enter id");
                        int id4 = scan.nextInt();
                        controllerSalon.deleteProduct(id4);
                        menu();
                        break;
                }

            break;
        }
    }
    }
    public static void main(String[] args) {
//        Repository<Barber> repoBarber =
        SalonApp menu = new SalonApp();
        menu.menu();
    }
//
//
//    public int getSelection() {
//        return selection;
//    }
//    public
//    switch ()
}
