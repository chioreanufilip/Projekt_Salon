package ServiceSalon;
import Controller.ControllerSalon;
import Module.*;
import repository.Repository;

import java.time.Duration;
import java.util.List;

public class ServiceSalon{
    private final Repository<Barber> barberRepository;
    private final Repository<NailPainter> nailPainterRepository;
    private final Repository<Produce> produceRepository;
    private final Repository<Pedicurist> pedicuristRepository;
    private final Repository<Service> serviceRepository;
    private final Repository<Appointment> appointmentRepository;
    private final Repository<Payment> paymentRepository;
    private final Repository<Review> reviewRepository;
    private final Repository<Client> clientRepository;

    public ServiceSalon(Repository<Barber> barberRepository, Repository<NailPainter> nailPainterRepository, Repository<Produce> produceRepository, Repository<Pedicurist> pedicuristRepository, Repository<Service> serviceRepository, Repository<Appointment> appointmentRepository, Repository<Payment> paymentRepository, Repository<Review> reviewRepository, Repository<Client> clientRepository) {
        this.barberRepository = barberRepository;
        this.nailPainterRepository = nailPainterRepository;
        this.produceRepository = produceRepository;
        this.pedicuristRepository = pedicuristRepository;
        this.serviceRepository = serviceRepository;
        this.appointmentRepository = appointmentRepository;
        this.paymentRepository = paymentRepository;
        this.reviewRepository = reviewRepository;
        this.clientRepository = clientRepository;
    }
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
    public void enrollAppointment(Integer id, String time,Client client,List<Service> service) {
        Appointment appointment = new Appointment(id, time,client,service);///////////////////////////////////////////////////////////////////////
        appointmentRepository.create(appointment);
    }
    public void enrollClient(Integer id, String name, String phoneNumber){
        clientRepository.create(new Client(id,name,phoneNumber));
    }
    public List<Client> getAllClients(){
        return clientRepository.getAll();
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
    public void enrollPayment(Integer id,List<Service> services, List<Produce> products) {
        Payment payment = new Payment(id, services, products);
        paymentRepository.create(payment);
    }
    public List<Payment> getAllPayment(){
        return paymentRepository.getAll();
    }
    public Payment getPaymentById(Integer id){
        return paymentRepository.getById(id);
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
    public Client getClientById(int id) {
        return clientRepository.getById(id);
    }
    public  void updateApointmentClient(Appointment apointment, Client newClient) {
        apointment.getClient().setId(newClient.getId());
        appointmentRepository.update(apointment);
    }

    public void applyLoyaltyDiscount(Integer clientId, Integer appointmentId) {

        List<Appointment> allAppointments = appointmentRepository.getAll();

        // Count the number of appointments for the specified client
        long clientAppointmentCount = allAppointments.stream()
                .filter(appointment -> appointment.getClient().getId().equals(clientId))
                .count();

        // Check if the client has more than 3 appointments
        if (clientAppointmentCount > 3) {
            // Retrieve the specific appointment where we want to apply the discount
            Appointment appointment = appointmentRepository.getById(appointmentId);

            if (appointment != null) {
                // Apply a 50% discount to the appointment's payment
                List<Service> services = appointment.getService();
                List<Produce> products = appointment.getProducts();

                // Calculate the total cost of services and products
                double originalAmount = 0.0;
                for (Service service : services) {
                    originalAmount += service.getPrice();
                }
                for (Produce product : products) {
                    originalAmount += product.getPrice();
                }
                // Apply 50% discount
                double discountedAmount = originalAmount * 0.5;

                // Update the payment amount with the discounted value
                Payment payment = appointment.getPayment();
                if (payment != null) {
                    payment.setAmount(discountedAmount);
                    paymentRepository.update(payment); // Update payment in the repository
                } else {
                    // If no payment exists, create a new one with the discounted amount
                    Payment newPayment = new Payment(appointmentId, services, products);
                    newPayment.setAmount(discountedAmount);
                    appointment.setPayment(newPayment);
                    appointmentRepository.update(appointment); // Update the appointment in the repository
                }

//                System.out.println("50% loyalty discount applied to appointment ID: " + appointmentId);
            }
        }
    }
}
