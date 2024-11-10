package Controller;

import repository.*;
import Module.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class ControllerSalon {
    private final Repository<Barber> barberRepository;
    private final Repository<NailPainter> nailPainterRepository;
    private final Repository<Produce> produceRepository;
    private final Repository<Pedicurist> pedicuristRepository;
    private final Repository<Service> serviceRepository;
    private final Repository<Appointment> appointmentRepository;
    private final Repository<Payment> paymentRepository;
    private final Repository<Review> reviewRepository;

    public ControllerSalon(Repository<Barber> barberRepository, Repository<NailPainter> nailPainterRepository,
                           Repository<Produce> produceRepository, Repository<Pedicurist> pedicuristRepository,
                           Repository<Service> serviceRepository, Repository<Appointment> appointmentRepository, Repository<Payment> paymentRepository,
                           Repository<Review> reviewRepository) {
        this.barberRepository = barberRepository;
        this.nailPainterRepository = nailPainterRepository;
        this.produceRepository = produceRepository;
        this.pedicuristRepository = pedicuristRepository;
        this.serviceRepository = serviceRepository;
        this.appointmentRepository = appointmentRepository;
        this.paymentRepository = paymentRepository;
        this.reviewRepository = reviewRepository;
    }

    //    InMemoryRepository barberrepo = new InMemoryRepository();
    public void enrollBarber(String name, String hairStyle, int experience, String speciality, Integer id) {
        barberRepository.create(new Barber(name, hairStyle, experience, speciality, id));

    }

    public void deleteBarber(Integer id) {
        barberRepository.delete(id);
    }

    public void enrollNailPainter(String name, int experience, String speciality, String gelNailExperience, Integer id) {
        nailPainterRepository.create(new NailPainter(name, experience, speciality, gelNailExperience, id));
    }

    public void deleteNailPainter(Integer id) {
        nailPainterRepository.delete(id);
    }

    public void enrollPedicurist(String name, Integer experience, String speciality, String FootCareSpecialisation, Integer id) {
        pedicuristRepository.create(new Pedicurist(name, experience, speciality, FootCareSpecialisation, id));
    }

    public void deletePedicurist(Integer id) {
        pedicuristRepository.delete(id);
    }

    public void addProduct(String name, Double price, Integer stock, Integer type, Integer id) {
        produceRepository.create(new Produce(name, price, stock, type, id));
    }

    public void deleteProduct(Integer id) {
        produceRepository.delete(id);
    }

    public List<Produce> getAllProduce() {
        return produceRepository.getAll();
    }

    public void addService(int ID, String name, Duration duration, double price, Integer type) {
        serviceRepository.create(new Service(ID, name, duration, price, type));
    }

    public List<Service> getAllServices() {
        return serviceRepository.getAll();
    }

    //Review
    public void enrollReview(Integer id, String comment, int rating) {
        reviewRepository.create(new Review(id, rating, comment));////////////////////////////////////////////////////////////////////////////
    }

    public void deleteReview(Integer id) {
        reviewRepository.delete(id);
    }

    public List<Review> getAllReviews() {
        return reviewRepository.getAll();
    }

    public Review getReviewById(int id) {
        return reviewRepository.getById(id);
    }

    // Appointment
    public void enrollAppointment(int id, LocalDateTime time,Client client,Service service, Employee employee) {
        Appointment appointment = new Appointment(id, time,client,service, employee);///////////////////////////////////////////////////////////////////////
        appointmentRepository.create(appointment);
    }

    public void deleteAppointment(Integer id) {
        appointmentRepository.delete(id);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.getAll();
    }

    public Appointment getAppointmentById(int id) {
        return appointmentRepository.getById(id);
    }

    // Payment
    public void enrollPayment(Integer id, Double amount, String method) {
        Payment payment = new Payment(id, method, amount);
        paymentRepository.create(payment);
    }
    public void deletePayment(Integer id) {
        paymentRepository.delete(id);
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.getAll();
    }
    public Payment getPaymentById(int id) {
        return paymentRepository.getById(id);
    }
}
