package Controller;

import ServiceSalon.ServiceSalon;
import repository.*;
import Module.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class ControllerSalon {
    private final ServiceSalon serviceSalon;

    public ControllerSalon(ServiceSalon serviceSalon) {

        this.serviceSalon = serviceSalon;
    }
    //    InMemoryRepository barberrepo = new InMemoryRepository();
    public void enrollBarber(String name, String hairStyle, int experience, String speciality, Integer id) {
//        barberRepository.create(new Barber(name, hairStyle, experience, speciality, id));
        serviceSalon.enrollBarber(name, hairStyle, experience, speciality, id);
    }
//
    public void deleteBarber(Integer id) {
//        barberRepository.delete(id);
        serviceSalon.deleteBarber(id);
    }
//
    public void enrollNailPainter(String name, int experience, String speciality, String gelNailExperience, Integer id) {
//        nailPainterRepository.create(new NailPainter(name, experience, speciality, gelNailExperience, id))
        serviceSalon.enrollNailPainter(name, experience, speciality, gelNailExperience, id);
    }
//
    public void deleteNailPainter(Integer id) {
//        nailPainterRepository.delete(id);
        serviceSalon.deleteNailPainter(id);
    }
//
    public void enrollPedicurist(String name, Integer experience, String speciality, String FootCareSpecialisation, Integer id) {
//        pedicuristRepository.create(new Pedicurist(name, experience, speciality, FootCareSpecialisation, id));
        serviceSalon.enrollPedicurist(name, experience, speciality, FootCareSpecialisation, id);
    }
//
    public void deletePedicurist(Integer id) {
//        pedicuristRepository.delete(id);
        serviceSalon.deletePedicurist(id);
    }
//
    public void addProduct(String name, Double price, Integer stock, Integer type, Integer id) {
//        produceRepository.create(new Produce(name, price, stock, type, id));
        serviceSalon.addProduct(name, price, stock, type, id);
    }
//
    public void deleteProduct(Integer id) {
//        produceRepository.delete(id);
        serviceSalon.deleteProduct(id);
    }
//
    public List<Produce> getAllProduce() {
//        return produceRepository.getAll();
        return serviceSalon.getAllProduce();
    }
//
    public void addService(int ID, String name, Duration duration, double price, Integer type) {
//        serviceRepository.create(new Service(ID, name, duration, price, type));
        serviceSalon.addService(ID, name, duration, price, type);
    }
//
    public List<Service> getAllServices() {
//        return serviceRepository.getAll();
    return serviceSalon.getAllServices();
    }
//
//    //Review
    public void enrollReview(Integer id, String comment, int rating) {
//        reviewRepository.create(new Review(id, rating, comment));////////////////////////////////////////////////////////////////////////////
    serviceSalon.enrollReview(id, comment, rating);
    }
//
    public void deleteReview(Integer id) {
//        reviewRepository.delete(id);
    serviceSalon.deleteReview(id);
    }
//
    public List<Review> getAllReviews() {
//        return reviewRepository.getAll();

  return serviceSalon.getAllReviews();
    }
//
    public Review getReviewById(int id) {
//        return reviewRepository.getById(id);
    return serviceSalon.getReviewById(id);
    }
//
//    // Appointment
    public void enrollAppointment(Integer id, String time,Client client,List<Service> service) {
    serviceSalon.enrollAppointment(id, time, client, service);
    }
    public void enrollClient(Integer id, String name, String phoneNumber){
    serviceSalon.enrollClient(id, name, phoneNumber);
    }
    public List<Client> getAllClients(){
    return serviceSalon.getAllClients();
    }
    public void deleteAppointment(Integer id) {
    serviceSalon.deleteAppointment(id);
    }
//
    public List<Appointment> getAllAppointments() {
    return serviceSalon.getAllAppointments();
    }
//
    public Appointment getAppointmentById(int id) {
    return serviceSalon.getAppointmentById(id);
    }

    public void enrollPayment(Integer id,List<Service> services, List<Produce> products) {
    serviceSalon.enrollPayment(id, services, products);
    }
    public List<Payment> getAllPayment(){
    return serviceSalon.getAllPayment();
    }
    public Payment getPaymentById(Integer id){
    return serviceSalon.getPaymentById(id);
    }
    public void deletePayment(Integer id) {
    serviceSalon.deletePayment(id);
    }
//
    public List<Payment> getAllPayments() {
    return serviceSalon.getAllPayments();
    }
    public Payment getPaymentById(int id) {
    return serviceSalon.getPaymentById(id);
    }
    public Client getClientById(int id) {
    return serviceSalon.getClientById(id);
    }
//    public  void updateReview(Review review) {
//    serviceSalon.updateReview(review);
//    }

}
