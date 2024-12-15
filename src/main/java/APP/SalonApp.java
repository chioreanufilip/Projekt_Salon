package APP;

import Exceptions.ValidationException;
import Module.Barber;
import Module.NailPainter;
import Module.Pedicurist;
import Module.Produce;
import repository.DBRepo.*;
import repository.Repository;
import Controller.ControllerSalon;
import Module.Service;
import Module.Review;
import Module.Appointment;
import Module.Client;
import Module.Payment;
import ServiceSalon.ServiceSalon;
import Module.Employee;
//import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
//import  org.json.simple.JSONObject;

public class SalonApp {
//    private final Controller =Controller;
//    ControllerSalon controller = new ControllerSalon();
    public SalonApp() {
//        this.Controller = controller;
    }///creates all the necesery repositories
//    Repository<Barber> repoBarb = new InMemoryRepository<Barber>();
//    Repository<NailPainter> repoNail = new InMemoryRepository<NailPainter>();
//    Repository<Pedicurist> repoPedi = new InMemoryRepository<Pedicurist>();
//    Repository<Produce> repoProduct = new InMemoryRepository<Produce>();
//    Repository<Service> repoService = new InMemoryRepository<Service>();
//    Repository<Payment> repoPayment = new InMemoryRepository<Payment>();
//    Repository<Review> repoReview = new InMemoryRepository<Review>();
//    Repository<Appointment> repoAppointment = new InMemoryRepository<Appointment>();
//    Repository<Client> repoClient = new InMemoryRepository<Client>();

    String DBUrl ="jdbc:sqlserver://Romana_mobile;Database=BarberShop;trustServerCertificate=true;user=barbershop;password=12345;";
    Repository<Barber> repoBarb =new BarberDBRepo(DBUrl);
    Repository<Pedicurist> repoPedi = new PedicuristDBRepo(DBUrl);
    Repository<NailPainter> repoNail = new NailPainterDBRepo(DBUrl);
    Repository<Produce> repoProduct = new ProductDBRepo(DBUrl);
    Repository<Client> repoClient = new ClientDBRepo(DBUrl);
    Repository<Review> repoReview = new ReviewDBRepo(DBUrl);
    Repository<Service> repoService = new ServiceDBRepo(DBUrl);
    Repository<Payment> repoPayment = new PaymentDBRepo(DBUrl);
    Repository<Appointment> repoAppointment = new AppointmentDBRepo(DBUrl);
//    Repository<Barber> repoBarb = new InFileRepository<Barber>("C:\\Users\\chior\\IdeaProjects\\Projekt_Salon\\jsonFiles\\barbers.json",Barber.class);
//    Repository<NailPainter> repoNail = new InFileRepository<NailPainter>("C:\\Users\\chior\\IdeaProjects\\Projekt_Salon\\jsonFiles\\nailPainters.json",NailPainter.class);
//    Repository<Pedicurist> repoPedi = new InFileRepository<Pedicurist>("C:\\Users\\chior\\IdeaProjects\\Projekt_Salon\\jsonFiles\\pedicurist.json",Pedicurist.class);
//    Repository<Produce> repoProduct = new InFileRepository<Produce>("C:\\Users\\chior\\IdeaProjects\\Projekt_Salon\\jsonFiles\\products.json",Produce.class);
//    Repository<Service> repoService = new InFileRepository<Service>("C:\\Users\\chior\\IdeaProjects\\Projekt_Salon\\jsonFiles\\service.json",Service.class);
//    Repository<Payment> repoPayment = new InFileRepository<Payment>("C:\\Users\\chior\\IdeaProjects\\Projekt_Salon\\jsonFiles\\Payment.json",Payment.class);
//    Repository<Review> repoReview = new InFileRepository<Review>("C:\\Users\\chior\\IdeaProjects\\Projekt_Salon\\jsonFiles\\review.json",Review.class);
//    Repository<Appointment> repoAppointment = new InFileRepository<Appointment>("C:\\Users\\chior\\IdeaProjects\\Projekt_Salon\\jsonFiles\\appointment.json",Appointment.class);
//    Repository<Client> repoClient = new InFileRepository<Client>("C:\\Users\\chior\\IdeaProjects\\Projekt_Salon\\jsonFiles\\client.json",Client.class);
    ServiceSalon serviceSalon = new ServiceSalon(repoBarb,repoNail,repoProduct,repoPedi,repoService,repoAppointment,repoPayment,repoReview,repoClient);
    ControllerSalon controllerSalon = new ControllerSalon(serviceSalon);
    public void initialize(){
        Barber m =new Barber("Bob","Wolfcut, Fades, Fringe",1,"Wolfcut",Integer.valueOf(1));
        repoBarb.create(m);
        NailPainter n = new NailPainter("Costel",2,"NailPainting","yes",Integer.valueOf(1));
        repoNail.create(n);
        Pedicurist p = new Pedicurist("Marcel",Integer.valueOf(1),"Massage, nailpainting","University of Feet",Integer.valueOf(1));
        repoPedi.create(p);
        repoProduct.create(new Produce("Hairdye Blue",Double.valueOf(15.23),Integer.valueOf(4),Integer.valueOf(1),Integer.valueOf(1)));
        repoProduct.create(new Produce("Hairdye Red",Double.valueOf(15.23),Integer.valueOf(4),Integer.valueOf(1),Integer.valueOf(2)));
        repoProduct.create(new Produce("Nail Polish",Double.valueOf(45.83),Integer.valueOf(15),Integer.valueOf(4),Integer.valueOf(3)));
        repoProduct.create(new Produce("Nail gel",Double.valueOf(5.83),Integer.valueOf(4),Integer.valueOf(4),Integer.valueOf(4)));
        repoProduct.create(new Produce("Foot Scrub",Double.valueOf(25.83),Integer.valueOf(9),Integer.valueOf(3),Integer.valueOf(5)));
//        repoService.create(new Service(1,"Haircut", String.valueOf(50),50,Integer.valueOf(1)));
        List<Employee> haircut= new ArrayList<>();
        haircut.add(m);
        List<Employee> fingerPainting = new ArrayList<>();
        fingerPainting.add(n);
        List<Employee> footRub = new ArrayList<>();
        footRub.add(p);
        footRub.add(n);
        repoService.create(new Service(1,"Haircut", String.valueOf(50),50,haircut));
        repoService.create(new Service(2,"Finger Nail Painting", "45 Minutes",100,fingerPainting));
        repoService.create(new Service(3,"FootMassage", "55 minutes",120,footRub));


    }
    public void menu() {
        try {
            initialize();
            ///The main menu from where you can delete employees or add appointments or make reviews
            System.out.println("Welcome to Menu: \n" +
                    "1 - make appointment\n" +
                    "2 - admin\n" +
                    "3 - make review\n" +
                    "4 - exit");
            Scanner scan = new Scanner(System.in);
            int selection = scan.nextInt();
            switch (selection) {
                case 1:
                    List<Service> chosenService = new ArrayList<>();
                    System.out.println("Please select a service you want to make appointment: \n");
                    List<Service> allServices = controllerSalon.getAllServices();
                    for (int i = 1; i < allServices.size() + 1; i++) {
                        System.out.println(i + " " + allServices.get(i - 1).getName());
                    }
                    Scanner scan9 = new Scanner(System.in);

                    int services = scan9.nextInt();
                    if (services<=0||services>allServices.size()) {
                        throw new ValidationException("You have given a number which is incorect");
                    }
//                    if

                    chosenService.add(allServices.get(services - 1));
//                List<Produce> allProduce = controllerSalon.getAllProduce();
                    List<Produce> allProduce = controllerSalon.sortProductByPrice();
                    System.out.println("Please select the product that you want the employee to use on you: ");
                    List<Integer> forException = new ArrayList<>();
                    for (int i = 0; i < allProduce.size(); i++) {
//                    if (allProduce.get(i).getType()==allServices.get(services-1).getType()){
//                        System.out.println(i+1+" "+allProduce.get(i).getName()+" "+allProduce.get(i).getPrice()+ " Lei ardelenesti");
//                    }
//                    boolean m=all
//                    System.out.println(allServices.get(services-1).getEmployees().size());
//                    System.out.println(allServices.get(services-1).getName());
//                    for (int j =0;j<allServices.get(services-1).getEmployees().size();j++){
//                        System.out.println(allServices.get(j).getEmployees().get(j));
//                    }
                        if (allProduce.get(i).getType() == 1 && allServices.get(services - 1).getEmployees().stream().anyMatch(employee -> employee instanceof Barber)) {
                            System.out.println(i + 1 + " " + allProduce.get(i).getName() + " " + allProduce.get(i).getPrice() + " Lei ardelenesti");
                            forException.add(i+1);
                        } else if (allProduce.get(i).getType() == 2 && allServices.get(services - 1).getEmployees().stream().anyMatch(employee -> employee instanceof NailPainter)) {
                            System.out.println(i + 1 + " " + allProduce.get(i).getName() + " " + allProduce.get(i).getPrice() + " Lei ardelenesti");
                            forException.add(i+1);
                        } else if (allProduce.get(i).getType() == 3 && allServices.get(services - 1).getEmployees().stream().anyMatch(employee -> employee instanceof Pedicurist)) {
                            System.out.println(i + 1 + " " + allProduce.get(i).getName() + " " + allProduce.get(i).getPrice() + " Lei ardelenesti");
                            forException.add(i+1);
                        } else if (allProduce.get(i).getType() == 4 && allServices.get(services - 1).getEmployees().stream().anyMatch(employee -> employee instanceof NailPainter) || allProduce.get(i).getType() == 4 && allServices.get(services - 1).getEmployees().stream().anyMatch(employee -> employee instanceof Pedicurist)) {
                            System.out.println(i + 1 + " " + allProduce.get(i).getName() + " " + allProduce.get(i).getPrice() + " Lei ardelenesti");
                            forException.add(i+1);
                        }
                    }

                    List<Produce> products = new ArrayList<Produce>();
                    int choice1 = scan9.nextInt();
                    if (!forException.contains(choice1)) {
                        throw new ValidationException("You have given a number which is incorect");
                    }
                    products.add(allProduce.get(choice1 - 1));

                    int yes = 1;
                    while (yes == 1) {
                        System.out.println("Want to choose another product?: \n" +
                                "1-yes\n" +
                                "2-no\n");
                        yes = scan9.nextInt();
                        if (yes == 1) {
                            for (int i = 0; i < allProduce.size(); i++) {
//                            if (allProduce.get(i).getType()==allServices.get(services-1).getType()){
//                                System.out.println(i+1+" "+allProduce.get(i).getName()+" "+allProduce.get(i).getPrice()+ " Lei ardelenesti");
//                            }
                                if (allProduce.get(i).getType() == 1 && allServices.get(services - 1).getEmployees().stream().anyMatch(employee -> employee instanceof Barber)) {
                                    System.out.println(i + 1 + " " + allProduce.get(i).getName() + " " + allProduce.get(i).getPrice() + " Lei ardelenesti");
                                    forException.add(i+1);
                                } else if (allProduce.get(i).getType() == 2 && allServices.get(services - 1).getEmployees().stream().anyMatch(employee -> employee instanceof NailPainter)) {
                                    System.out.println(i + 1 + " " + allProduce.get(i).getName() + " " + allProduce.get(i).getPrice() + " Lei ardelenesti");
                                    forException.add(i+1);
                                } else if (allProduce.get(i).getType() == 3 && allServices.get(services - 1).getEmployees().stream().anyMatch(employee -> employee instanceof Pedicurist)) {
                                    System.out.println(i + 1 + " " + allProduce.get(i).getName() + " " + allProduce.get(i).getPrice() + " Lei ardelenesti");
                                    forException.add(i+1);
                                } else if (allProduce.get(i).getType() == 4 && allServices.get(services - 1).getEmployees().stream().anyMatch(employee -> employee instanceof NailPainter) || allProduce.get(i).getType() == 4 && allServices.get(services - 1).getEmployees().stream().anyMatch(employee -> employee instanceof Pedicurist)) {
                                    System.out.println(i + 1 + " " + allProduce.get(i).getName() + " " + allProduce.get(i).getPrice() + " Lei ardelenesti");
                                    forException.add(i+1);
                                }
                            }
                            choice1 = scan9.nextInt();
                            if(!forException.contains(choice1)) {
                                throw new ValidationException("You have given a number which is incorect");
                            }
                            products.add(allProduce.get(choice1 - 1));
                        }
                    }
                    ///checks if the appointmets have the same time
                    boolean time = Boolean.TRUE;
                    String time1 = null;
                    while (time == Boolean.TRUE) {
                        System.out.println("Please enter the time for the appointment like this yyyy-MM-dd-hh: ");
                        time1 = scan.next();
                        if (!isValidDateTime(time1)){
                            throw new ValidationException("You have given an invalid date");
                        }
                        if (controllerSalon.getAllAppointments().isEmpty()) {
                            time = Boolean.FALSE;
                        }
                        for (int i = 0; i < controllerSalon.getAllAppointments().size(); i++) {
                            String timeToCompare = controllerSalon.getAllAppointments().get(i).getDateTime();
                            if (!Objects.equals(timeToCompare, time1)) {
//                        System.out.println(controllerSalon.getAllAppointments().get(i).getDateTime());
                                time = Boolean.FALSE;
                            } else {
                                System.out.println("Sorry that time is taken\n");
                                break;
                            }
                        }
                    }
                    System.out.println("Is it your first appointment?: \n" +
                            "1- yes\n" +
                            "2-no\n" +
                            "3- I have more than 3 appointments");
                    int choise1 = scan.nextInt();
                    if (choise1!=1&&choise1!=2&&choise1!=3){
                        throw new ValidationException("You haven t chosen a valid option");
                    }
                    Integer clientId = 0;
                    Integer clientId1 = 0;
                    boolean discount = false;
                    switch (choise1) {
                        case 1:
                            scan.nextLine();
                            System.out.println("Enter your name: \n");
                            String name = scan.nextLine();
                            System.out.println("Enter your phonenumber: \n");
                            String phone = scan.next();
                            if (!phoneNumber(phone)){
                                throw new ValidationException("The phoneNumber is not valid");
                            }
                            if (controllerSalon.getAllClients().isEmpty()) {
                                controllerSalon.enrollClient(1, name, phone);
                            } else {
                                controllerSalon.enrollClient(controllerSalon.getAllClients().getLast().getId() + 1, name, phone);
                            }
                            controllerSalon.getAllClients().size();
                            clientId = controllerSalon.getAllClients().size() - 1;
                            clientId1 = controllerSalon.getAllClients().size();
                            break;
                        case 2:
                            System.out.println("Enter your name: \n");
                            name = scan.next();
                            System.out.println("Enter your phonenumber: \n");
                            phone = scan.next();
                            if (!phoneNumber(phone)){
                                throw new ValidationException("The phoneNumber is not valid");
                            }
                            for (int i = 0; i < controllerSalon.getAllClients().size(); i++) {
//                            System.out.println(controllerSalon.getAllClients().get(i).getPhoneNumber()+"\n"+controllerSalon.getAllClients().get(i).getName());
                                if (Objects.equals(controllerSalon.getAllClients().get(i).getPhoneNumber(), phone) && Objects.equals(controllerSalon.getAllClients().get(i).getName(), name)) {
                                    clientId = i;
                                    clientId1 = i + 1;
                                }
                                if (i == controllerSalon.getAllClients().size() - 1) {
                                    if (clientId != i) {
                                        if (controllerSalon.getAllClients().isEmpty()) {
                                            controllerSalon.enrollClient(1, name, phone);
//                                        clientId=i+1;
                                            clientId1 = 1;
                                        } else {
                                            controllerSalon.enrollClient(controllerSalon.getAllClients().getLast().getId() + 1, name, phone);
                                            clientId1 = controllerSalon.getAllClients().size();
                                        }
                                        controllerSalon.getAllClients().size();
                                        clientId = controllerSalon.getAllClients().size() - 1;

                                    }
                                    clientId1 = controllerSalon.getAllClients().size();
                                }
                            }
//                        clientId1=controllerSalon.getAllClients().size();
                            break;
                        case 3:
                            // Client with more than 3 appointments
                            System.out.println("Enter your name: \n");
                            name = scan.next();
                            System.out.println("Enter your phone number: \n");
                            phone = scan.next();
                            if (!phoneNumber(phone)){
                                throw new ValidationException("The phoneNumber is not valid");
                            }
                            for (int i = 0; i < controllerSalon.getAllClients().size(); i++) {
                                if (controllerSalon.getAllClients().get(i).getPhoneNumber().equals(phone) && controllerSalon.getAllClients().get(i).getName().equals(name)) {
                                    clientId = i;
                                    clientId1 = i;
//                                Client existingClient = controllerSalon.getAllClients().get(clientId+1);

                                    // Count the number of appointments for this client
//                                long clientAppointmentCount = controllerSalon.getAllAppointments().stream()
//                                        .filter(appointment -> appointment.getClient().equals(existingClient))
//                                        .count();
                                    Integer clientAppointmentCount = 0;
                                    for (int j = 0; j < controllerSalon.getAllAppointments().size(); j++) {
                                        if (controllerSalon.getAllAppointments().get(j).getClient().getName().equals(name) && controllerSalon.getAllAppointments().get(j).getClient().getPhoneNumber().equals(phone)) {
                                            clientAppointmentCount++;
                                        }
                                    }

                                    if (clientAppointmentCount > 3) {
                                        // Inform the client that they have more than 3 appointments
                                        System.out.println("Welcome back, " + name + "! You have more than 3 appointments.");
                                        // Call the method to apply the loyalty discount
                                        System.out.println("Do you want to apply your 50% loyalty discount? (yes/no)");
                                        String applyDiscount = scan.next();
                                        if (applyDiscount.equalsIgnoreCase("yes")) {
                                            // Assuming you have appointmentId available for the client
//                                            System.out.println("Enter your appointment ID to apply the discount:");
//                                            Integer appointmentId = scan.nextInt();
                                            discount=true;
//                                            controllerSalon.applyLoyaltyDiscount(clientId + 1, appointmentId);
                                            System.out.println("50% loyalty discount applied!");
                                        }
                                    } else {
                                        System.out.println("You do not qualify for the loyalty discount yet.");
                                    }
                                    break;
                                }
                            }
                            break;
                    }

                    if (controllerSalon.getAllPayment().isEmpty()) {
                        controllerSalon.enrollPayment(1, chosenService, products, clientId1);
                    } else {
                        controllerSalon.enrollPayment(controllerSalon.getAllPayments().getLast().getId() + 1, chosenService, products, clientId1);

                    }
//                    System.out.println("You have to pay :\n" +
//                            controllerSalon.getPaymentById(controllerSalon.getAllPayment().getLast().getId()).getAmount());
                    Payment payment1 = controllerSalon.getPaymentById(controllerSalon.getAllPayment().getLast().getId());
                    double totalPrice = chosenService.get(0).getPrice();
                    for (Produce product : products) {
                        totalPrice += product.getPrice(); // Add price of products to total price
                    }

                    if (controllerSalon.getAllAppointments().isEmpty()) {
                        controllerSalon.enrollAppointment(1, time1, controllerSalon.getAllClients().get(clientId), chosenService, payment1);
                    } else {
                        controllerSalon.enrollAppointment(controllerSalon.getAllAppointments().getLast().getId() + 1, time1, controllerSalon.getAllClients().get(clientId), chosenService, payment1);
                        if (discount){
                            controllerSalon.applyLoyaltyDiscount(clientId,controllerSalon.getAllAppointments().getLast().getId());
                        }
                    }
                    System.out.println("You have to pay :\n" +
                            controllerSalon.getPaymentById(controllerSalon.getAllAppointments().getLast().getPayment().getId()).getAmount()/2);
                    menu();
                    break;

                case 3:
                    makeReview();
                    break;

                case 4:
                    System.out.println("Exiting the application. Thank you for using SalonApp!");
                    break;

                case 2:
                    System.out.println("1- create\n" +
                            "2- delete\n" +
                            "3- view appointments\n" +
                            "4- view Payments made by a specific Client\n" +
                            "5- view bonuses\n");

                    Scanner scan1 = new Scanner(System.in);
                    int selection1 = scan1.nextInt();
                    if (selection1!=1&&selection1!=2&&selection1!=3&&selection1!=4&&selection1!=5) {
                        throw new ValidationException("You haven t selected a valid option");
                    }
                    switch (selection1) {
                        case 1:
                            System.out.println("1- Barber\n" +
                                    "2- NailPainter\n" +
                                    "3- Pedicurist\n" +
                                    "4- Product");
                            Scanner scan2 = new Scanner(System.in);
                            int selection2 = scan2.nextInt();
                            if (selection2!=1&&selection2!=2&&selection2!=3&&selection2!=4) {
                                throw new ValidationException("You haven t selected a valid option");
                            }
                            switch (selection2) {
                                case 1:
                                    System.out.println("Enter Name");
                                    String name = scan2.next();
                                    System.out.println("Enter Hairstyles:\n");
                                    String hairstyles = scan2.next();
                                    System.out.println("Enter how many years of experience:\n");
                                    int experience = scan2.nextInt();
                                    System.out.println("Enter what he specializes in:\n");
                                    String specialize = scan2.next();
                                    System.out.println("Enter id: ");
                                    Integer id = (Integer) scan2.nextInt();
                                    controllerSalon.enrollBarber(name, hairstyles, experience, specialize, id);
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
                                    Integer id2 = (Integer) scan2.nextInt();
                                    controllerSalon.enrollNailPainter(name1, experience1, speciality, gelExperience, id2);
                                    menu();
                                    break;
                                case 3:
                                    System.out.println("Enter Name");
                                    String name2 = scan2.next();
                                    System.out.println("Enter the speciality:\n");
                                    String speciality3 = scan2.next();
                                    System.out.println("Enter how many years of experience:\n");
                                    Integer experience3 = (Integer) scan2.nextInt();
                                    System.out.println("write what kind of Foot Care Speciality you have:\n");
                                    String footCare = scan2.next();
                                    System.out.println("Enter id: ");
                                    Integer id1 = (Integer) scan2.nextInt();
                                    controllerSalon.enrollPedicurist(name2, experience3, speciality3, footCare, id1);
                                    menu();
                                    break;
                                case 4:
                                    System.out.println("Enter the name of the product: ");
                                    String productName = scan.next();
                                    System.out.println("Write the price you are selling it for:\n");
                                    Double price = (Double) scan.nextDouble();
                                    System.out.println("How many do you have: \n");
                                    Integer stock = (Integer) scan.nextInt();
                                    System.out.println("Enter id: ");
                                    Integer id3 = (Integer) scan.nextInt();
                                    System.out.println("Will this be used by: \n" +
                                            "1-Barber\n" +
                                            "2-NailPainter\n" +
                                            "3-Pedicurist\n" +
                                            "4-Both NailPainter and Pedicurist");
                                    Integer type = (Integer) scan.nextInt();
                                    if (type!=1&&type!=2&&type!=3&&type!=4) {
                                        throw new ValidationException("You haven t selected a valid option");
                                    }
//                        Produce produce = new Produce(productName, price, stock,id3);
                                    controllerSalon.addProduct(productName, price, stock, type, id3);
                                    menu();
                                    break;

                            }
                            break;
                        case 2:
                            System.out.println("What do you want to delete: \n" +
                                    "1- Barber\n" +
                                    "2- NailPainter\n" +
                                    "3- Pedicurist\n" +
                                    "4- Product");
                            int choise = scan.nextInt();
                            if(choise==1&&choise==2&&choise==3&&choise==4) {
                                throw new ValidationException("You haven t selected a valid option");
                            }
                            switch (choise) {
                                case 1:
                                    System.out.println("Enter id");
                                    int id = scan.nextInt();
                                    controllerSalon.deleteBarber(Integer.valueOf(id));
                                    menu();
                                    break;
                                case 2:
                                    System.out.println("Enter id");
                                    int id2 = scan.nextInt();
                                    controllerSalon.deleteNailPainter(Integer.valueOf(id2));
                                    menu();
                                    break;
                                case 3:
                                    System.out.println("Enter id");
                                    int id3 = scan.nextInt();
                                    controllerSalon.deletePedicurist(Integer.valueOf(id3));
                                    menu();
                                    break;
                                case 4:
                                    System.out.println("Enter id");
                                    int id4 = scan.nextInt();
                                    controllerSalon.deleteProduct(Integer.valueOf(id4));
                                    menu();
                                    break;
                            }

                            break;
                        case 3:
                            for (Appointment apointment : controllerSalon.sortByTimeAppointments()) {
                                System.out.println("Name: " + apointment.getClient().getName() + " Date: " + apointment.getDateTime() + " ");
                                for (Service service : apointment.getService()) {
                                    System.out.println(service.getName() + " ");
                                }
                            }
                            menu();
                            break;
                        case 4:
                            System.out.println("Enter client id:\n");
                            int id5 = scan.nextInt();
                            for (Payment payment : controllerSalon.filterPaymentByClient(id5)) {
                                System.out.println("The Payment with the id " + payment.getId() + " and the amouny " + payment.getAmount() + " lei ardelenesti was paid by Client " + controllerSalon.getClientById(id5).getName() + "\n");
                            }
                            menu();
                            break;
                        case 5:
                            System.out.println("Enter the year and month you want to obtain the bonus for (yyyy-MM): \n");
                            String year = scan.next();
                            controllerSalon.getThemBonuses(year);
                            menu();
                            break;
                    }
            }
        }
        catch (ValidationException e){System.out.println(e.getMessage());
            menu();
        }
    }

    private void makeReview() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Review Menu: \n" +
                "1 - Add a Review\n" +
                "2 - View All Reviews\n" +
                "3 - View Review with a specific rating\n");
        int reviewOption = scanner.nextInt();
        if (reviewOption!=1&&reviewOption!=2&&reviewOption!=3){
            throw new ValidationException("You havent selected a valid option");
        }

        switch (reviewOption) {
            case 1:
                // Adding a new review
                System.out.print("Enter your Client ID: ");
                int clientId = scanner.nextInt();

                Client client = controllerSalon.getClientById(clientId);
                if (client == null) {
                    System.out.println("Client not found. Please make sure the Client ID is correct.");
                    return;
                }

                System.out.print("Enter Review ID: ");
                int reviewId = scanner.nextInt();

                System.out.print("Enter Rating (1-5): ");
                int rating = scanner.nextInt();

                scanner.nextLine();  // Consume newline
                System.out.print("Enter Comment: ");
                String comment = scanner.nextLine();

//                Review review = new Review(reviewId, rating, comment,clientId);
//                review.setClientId(clientId);
                controllerSalon.enrollReview(reviewId, comment,Integer.valueOf(rating),clientId);
                System.out.println("Thank you, " + client.getName() + ", for your review!");
                break;

            case 2:
                List<Review> allReviews = controllerSalon.getAllReviews();
                if (allReviews.isEmpty()) {
                    System.out.println("No reviews available.");
                } else {
                    System.out.println("All Reviews:");
                    for (Review reviewItem : allReviews) {
                        System.out.println("ID: " + reviewItem.getId() + ", Rating: " + reviewItem.getRating() + ", Comment: " + reviewItem.getComment());
                    }
                }
                break;

            case 3:
                System.out.print("Enter the Rating (1-5): ");
                int rating1 = scanner.nextInt();
                if (rating1<1||rating1>5){
                    throw new ValidationException("You need to enter a rating between 1-5");
                }
                List<Review> reviews = controllerSalon.filterByRatingReview(Integer.valueOf(rating1));
                if (reviews.isEmpty()) {
                    System.out.println("No reviews available.");
                } else {
                    System.out.println("All Reviews:");
                    for (Review reviewItem : reviews) {
                        System.out.println("ID: " + reviewItem.getId() + ", Rating: " + reviewItem.getRating() + ", Comment: " + reviewItem.getComment());
                    }
                }
        }
        menu();
    }

    public static void main(String[] args) {
        SalonApp menu = new SalonApp();
        menu.menu();
    }
    private static boolean isValidDateTime(String input) {
        // Regular expression to match the general format yyyy-MM-dd-hh
        String regex = "\\d{4}-\\d{2}-\\d{2}-\\d{2}";

        // Check if input matches the format
        if (!input.matches(regex)) {
            return false;
        }

        // Split the input into components
        String[] parts = input.split("-");

        try {
            int year = Integer.parseInt(parts[0]);  // yyyy
            int month = Integer.parseInt(parts[1]); // MM
            int day = Integer.parseInt(parts[2]);   // dd
            int hour = Integer.parseInt(parts[3]);  // hh

            // Validate ranges for month, day, and hour
            if (month < 1 || month > 12) {
                return false;
            }
            if (day < 1 || day > 31) {
                return false;
            }
            if (hour < 0 || hour > 24) {
                return false;
            }

            // Optional: Validate day range for specific months
            // (e.g., February max 28/29, April max 30)
            if (!isValidDayForMonth(year, month, day)) {
                return false;
            }

        } catch (NumberFormatException e) {
            // If any part is not a valid integer
            return false;
        }

        return true; // Passes all checks
    }
    private static boolean isValidDayForMonth(int year, int month, int day) {
        // Array representing the maximum days in each month
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // Adjust for leap year in February
        if (month == 2 && isLeapYear(year)) {
            return day <= 29;
        }

        return day <= daysInMonth[month - 1];
    }

    private static boolean isLeapYear(int year) {
        // A leap year is divisible by 4 but not by 100, unless also divisible by 400
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    private boolean phoneNumber(String input){
        boolean valid = true;
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                valid = false;
                break;
            }
        }
        return valid;
    }
}
