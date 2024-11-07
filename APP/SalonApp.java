package APP;

import Module.Barber;
import Module.NailPainter;
import Module.Pedicurist;
import Module.Produce;
import repository.InMemoryRepository;
import repository.Repository;
import Controller.ControllerSalon;

import java.awt.*;
import java.util.Scanner;
public class SalonApp {
//    private final Controller =Controller;
//    ControllerSalon controller = new ControllerSalon();
    public SalonApp() {
//        this.Controller = controller;
    }

    public void menu() {
        Repository<Barber> repoBarb = new InMemoryRepository<Barber>();
        Repository<NailPainter> repoNail = new InMemoryRepository<NailPainter>();
        Repository<Pedicurist> repoPedi = new InMemoryRepository<Pedicurist>();
        Repository<Produce> repoProduct = new InMemoryRepository<Produce>();
        ControllerSalon controllerSalon = new ControllerSalon(repoBarb,repoNail,repoProduct,repoPedi);
        System.out.println("Welcome to Menu.Menu: \n" +
                "1-make appointment\n" +
                "2-admin");
        Scanner scan = new Scanner(System.in);
        int selection = scan.nextInt();
        switch (selection) {
            case 1:
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
                        controllerSalon.enrollBarber(name, hairstyles, experience, specialize);
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
                        NailPainter ionica = new NailPainter(name1, experience1, speciality, gelExperience);
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
                        Pedicurist ionicosul = new Pedicurist(name2, experience3, speciality3, footCare);
//                        System.out.println(ionicosul.getSize());
                        menu();
                        break;
                    case 4:
                        System.out.println("Enter the name of the product: ");
                        String productName = scan.next();
                        System.out.println("Write the price you are selling it for:\n");
                        double price = scan.nextDouble();
                        System.out.println("How many do you have: \n");
                        int stock = scan.nextInt();
                        Produce produce = new Produce(productName, price, stock);
                        menu();
                }
            break;
            case 2:
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
