package ServiceSalon;

import repository.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import Module.*;
import Exceptions.*;

/**
 * This class provides services to manage various operations in a salon, including enrolling employees,
 * managing appointments, payments, reviews, and products. It integrates with different repositories
 * to perform CRUD operations on various entities such as barbers, nail painters, pedicurists, clients,
 * services, products, payments, appointments, and reviews.
 */
public class ServiceSalon {

    private final Repository<Barber> barberRepository;
    private final Repository<NailPainter> nailPainterRepository;
    private final Repository<Produce> produceRepository;
    private final Repository<Pedicurist> pedicuristRepository;
    private final Repository<Service> serviceRepository;
    private final Repository<Appointment> appointmentRepository;
    private final Repository<Payment> paymentRepository;
    private final Repository<Review> reviewRepository;
    private final Repository<Client> clientRepository;

    /**
     * Constructor to initialize the ServiceSalon with the required repositories.
     *
     * @param barberRepository the repository for barbers
     * @param nailPainterRepository the repository for nail painters
     * @param produceRepository the repository for products
     * @param pedicuristRepository the repository for pedicurists
     * @param serviceRepository the repository for services
     * @param appointmentRepository the repository for appointments
     * @param paymentRepository the repository for payments
     * @param reviewRepository the repository for reviews
     * @param clientRepository the repository for clients
     */
    public ServiceSalon(Repository<Barber> barberRepository, Repository<NailPainter> nailPainterRepository,
                        Repository<Produce> produceRepository, Repository<Pedicurist> pedicuristRepository,
                        Repository<Service> serviceRepository, Repository<Appointment> appointmentRepository,
                        Repository<Payment> paymentRepository, Repository<Review> reviewRepository,
                        Repository<Client> clientRepository) {
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

    /**
     * Enrolls a new barber in the system.
     *
     * @param name the name of the barber
     * @param hairStyle the barber's hair style
     * @param experience the barber's years of experience
     * @param speciality the barber's speciality
     * @param id the barber's ID
     */
    public void enrollBarber(String name, String hairStyle, int experience, String speciality, Integer id) {
        barberRepository.create(new Barber(name, hairStyle, experience, speciality, id));
    }

    /**
     * Deletes a barber by their ID.
     *
     * @param id the ID of the barber to be deleted
     */
    public void deleteBarber(Integer id) {
        barberRepository.delete(id);
    }

    /**
     * Enrolls a new nail painter in the system.
     *
     * @param name the name of the nail painter
     * @param experience the nail painter's years of experience
     * @param speciality the nail painter's speciality
     * @param gelNailExperience the nail painter's gel nail experience
     * @param id the nail painter's ID
     */
    public void enrollNailPainter(String name, int experience, String speciality, String gelNailExperience, Integer id) {
        nailPainterRepository.create(new NailPainter(name, experience, speciality, gelNailExperience, id));
    }

    /**
     * Deletes a nail painter by their ID.
     *
     * @param id the ID of the nail painter to be deleted
     */
    public void deleteNailPainter(Integer id) {
        nailPainterRepository.delete(id);
    }

    /**
     * Enrolls a new pedicurist in the system.
     *
     * @param name the name of the pedicurist
     * @param experience the pedicurist's years of experience
     * @param speciality the pedicurist's speciality
     * @param FootCareSpecialisation the pedicurist's foot care specialisation
     * @param id the pedicurist's ID
     */
    public void enrollPedicurist(String name, Integer experience, String speciality, String FootCareSpecialisation, Integer id) {
        pedicuristRepository.create(new Pedicurist(name, experience, speciality, FootCareSpecialisation, id));
    }

    /**
     * Deletes a pedicurist by their ID.
     *
     * @param id the ID of the pedicurist to be deleted
     */
    public void deletePedicurist(Integer id) {
        pedicuristRepository.delete(id);
    }

    /**
     * Adds a product to the system.
     *
     * @param name the name of the product
     * @param price the price of the product
     * @param stock the stock of the product
     * @param type the type of the product (1: barber, 2: nail painter, 3: pedicurist, 4: nail painter and pedicurist)
     * @param id the product's ID
     */
    public void addProduct(String name, Double price, Integer stock, Integer type, Integer id) {
        produceRepository.create(new Produce(name, price, stock, type, id));
    }

    /**
     * Deletes a product by its ID.
     *
     * @param id the ID of the product to be deleted
     */
    public void deleteProduct(Integer id) {
        produceRepository.delete(id);
    }

    /**
     * Retrieves a list of all products in the system.
     *
     * @return a list of all products
     */
    public List<Produce> getAllProduce() {
        return produceRepository.getAll();
    }

    /**
     * Adds a service to the system.
     *
     * @param ID the ID of the service
     * @param name the name of the service
     * @param duration the duration of the service
     * @param price the price of the service
//     * @param type the type of the service (1: barber, 2: nail painter, 3: pedicurist, 4: nail painter and pedicurist)
     */
    public void addService(int ID, String name, String duration, double price, List<Employee> list) {
        serviceRepository.create(new Service(ID, name, duration, price, list));
    }

    /**
     * Retrieves a list of all services in the system.
     *
     * @return a list of all services
     */
    public List<Service> getAllServices() {
        return serviceRepository.getAll();
    }

    /**
     * Enrolls a review for a service or appointment.
     *
     * @param id the ID of the review
     * @param comment the comment of the review
     * @param rating the rating of the review
     */
    public void enrollReview(Integer id, String comment, Integer rating,Integer clientID) {
        reviewRepository.create(new Review(id, rating, comment,clientID));
    }

    /**
     * Deletes a review by its ID.
     *
     * @param id the ID of the review to be deleted
     */
    public void deleteReview(Integer id) {
        reviewRepository.delete(id);
    }

    /**
     * Retrieves a list of all reviews in the system.
     *
     * @return a list of all reviews
     */
    public List<Review> getAllReviews() {
        return reviewRepository.getAll();
    }

    /**
     * Retrieves a review by its ID.
     *
     * @param id the ID of the review
     * @return the review with the specified ID
     */
    public Review getReviewById(int id) {
        return reviewRepository.getById(id);
    }

    /**
     * Enrolls a new appointment for a client.
     *
     * @param id the ID of the appointment
     * @param time the time of the appointment
     * @param client the client for the appointment
     * @param service the services included in the appointment
     */
    public void enrollAppointment(Integer id, String time, Client client, List<Service> service,Payment payment) {
        try{
            String[] parts = time.split("-");
            int year = Integer.parseInt(parts[0]);  // yyyy
            int month = Integer.parseInt(parts[1]); // MM
            int day = Integer.parseInt(parts[2]);   // dd
            int hour = Integer.parseInt(parts[3]);
            if(year<LocalDate.now().getYear()||month<LocalDate.now().getMonthValue()||day<LocalDate.now().getDayOfMonth()&&month<LocalDate.now().getMonthValue()){
                throw new BussinessLogicException("The time isn t making sens");
            }
        Appointment appointment = new Appointment(id, time, client, service,payment);
        appointmentRepository.create(appointment);
    }catch (BussinessLogicException e){System.out.println("The Appointment doesn t make sens you have error "+e.getMessage());}
    }

    /**
     * Enrolls a new client in the system.
     *
     * @param id the ID of the client
     * @param name the name of the client
     * @param phoneNumber the phone number of the client
     */
    public void enrollClient(Integer id, String name, String phoneNumber) {
        clientRepository.create(new Client(id, name, phoneNumber));
    }

    /**
     * Retrieves a list of all clients in the system.
     *
     * @return a list of all clients
     */
    public List<Client> getAllClients() {
        return clientRepository.getAll();
    }

    /**
     * Deletes an appointment by its ID.
     *
     * @param id the ID of the appointment to be deleted
     */
    public void deleteAppointment(Integer id) {
        appointmentRepository.delete(id);
    }

    /**
     * Retrieves a list of all appointments in the system.
     *
     * @return a list of all appointments
     */
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.getAll();
    }

    /**
     * Retrieves an appointment by its ID.
     *
     * @param id the ID of the appointment
     * @return the appointment with the specified ID
     */
    public Appointment getAppointmentById(int id) {
        return appointmentRepository.getById(id);
    }

    /**
     * Enrolls a new payment for a list of services and products.
     *
     * @param id the ID of the payment
     * @param services the services in the payment
     * @param products the products in the payment
     */
    public void enrollPayment(Integer id, List<Service> services, List<Produce> products,Integer clientID) {
        Payment payment = new Payment(id, services, products,clientID);
        paymentRepository.create(payment);
    }

    /**
     * Retrieves a list of all payments in the system.
     *
     * @return a list of all payments
     */
    public List<Payment> getAllPayments() {
        return paymentRepository.getAll();
    }

    /**
     * Retrieves a payment by its ID.
     *
     * @param id the ID of the payment
     * @return the payment with the specified ID
     */
    public Payment getPaymentById(Integer id) {
        return paymentRepository.getById(id);
    }

    public Client getClientById(int id){
        return clientRepository.getById(id);
    }

    /**
     * Deletes a payment by its ID.
     *
     * @param id the ID of the payment to be deleted
     */
    public void deletePayment(Integer id) {
        paymentRepository.delete(id);
    }

    /**
     * Updates the client of an appointment.
     *
     * @param apointment the appointment to be updated
     * @param newClient the new client to be assigned to the appointment
     */
    public void updateAppointmentClient(Appointment apointment, Client newClient) {
        apointment.getClient().setId(newClient.getId());
        appointmentRepository.update(apointment);
    }

    /**
     * Applies a loyalty discount to a client's payment if they have more than 3 previous appointments.
     *
     * @param clientId the ID of the client
     * @param appointmentId the ID of the appointment for which the discount should be applied
     */
    public void applyLoyaltyDiscount(Integer clientId, Integer appointmentId) {
        List<Appointment> allAppointments = appointmentRepository.getAll();

        // Count the number of appointments for the specified client
//        long clientAppointmentCount = allAppointments.stream()
//                .filter(appointment -> appointment.getClient().getId().equals(clientId))
//                .count();

        // Check if the client has more than 3 appointments
//        Integer clientAppointmentCount = 0;
//        for (int j = 0; j < controllerSalon.getAllAppointments().size(); j++) {
//            if (controllerSalon.getAllAppointments().get(j).getClient().getName().equals(name) && controllerSalon.getAllAppointments().get(j).getClient().getPhoneNumber().equals(phone)) {
//                clientAppointmentCount++;
//            }
//        }
//        if (clientAppointmentCount > 3) {
            // Retrieve the specific appointment where we want to apply the discount
            Appointment appointment = appointmentRepository.getById(appointmentId);
            appointment.getPayment().setAmount(appointment.getPayment().getAmount()*0.5);
            System.out.println(appointment.getPayment().getAmount());
            paymentRepository.update(appointment.getPayment());
            appointmentRepository.update(appointment);
//            appointment.setPayment(appointment.getPayment().);
//            if (appointment != null) {
//                // Apply a 50% discount to the appointment's payment
//                List<Service> services = appointment.getService();
//                List<Produce> products = appointment.getProducts();
//
//                // Calculate the total cost of services and products
//                double originalAmount = 0.0;
//                for (Service service : services) {
//                    originalAmount += service.getPrice();
//                }
//                for (Produce product : products) {
//                    originalAmount += product.getPrice();
//                }
//                // Apply 50% discount
//                double discountedAmount = originalAmount * 0.5;
//
//                // Update the payment amount with the discounted value
//                Payment payment = appointment.getPayment();
//                if (payment != null) {
//                    payment.setAmount(discountedAmount);
//                    paymentRepository.update(payment); // Update payment in the repository
//                } else {
//                    // If no payment exists, create a new one with the discounted amount
//                    Payment newPayment = new Payment(appointmentId, services, products,clientId);
//                    newPayment.setAmount(discountedAmount);
//                    appointment.setPayment(newPayment);
//                    appointmentRepository.update(appointment); // Update the appointment in the repository
//                }
//            }
//        }
    }

    /**
     * Sorts products by their price in ascending order.
     *
     * @return a list of products sorted by price
     */
    public List<Produce> sortProductsByPrice() {
        List<Produce> unSortedList = new ArrayList<Produce>(produceRepository.getAll());
        Produce temp;
        for (int i = 0; i < unSortedList.size() - 1; i++) {
            for (int j = 0; j < unSortedList.size() - i - 1; j++) {
                if (unSortedList.get(j + 1).getPrice() < unSortedList.get(j).getPrice()) {
                    temp = unSortedList.get(j + 1);
                    unSortedList.set(j + 1, unSortedList.get(j));
                    unSortedList.set(j, temp);
                }
            }
        }
        return unSortedList;
    }

    /**
     * Sorts appointments by their time.
     *
     * @return a list of appointments sorted by time
     */
    public List<Appointment> sortAppointmentsByTime() {
        List<Appointment> toSortedList = new ArrayList<Appointment>(appointmentRepository.getAll());
        toSortedList.sort(Comparator.comparing(Appointment::getDateTime));
        return toSortedList;
    }

    /**
     * Filters reviews based on a specific rating.
     *
     * @param rating the rating to filter by
     * @return a list of reviews that match the given rating
     */
    public List<Review> filterReviewsByRating(Integer rating) {
        List<Review> reviews = new ArrayList<Review>(reviewRepository.getAll());
        reviews = reviews.stream().filter(rat -> rat.getRating() == rating).collect(Collectors.toList());
        return reviews;
    }

    /**
     * Filters payments based on a specific client's ID.
     *
     * @param clientId the client ID to filter by
     * @return a list of payments made by the specified client
     */
    public List<Payment> filterPaymentsByClients(Integer clientId) {
        List<Payment> payments = new ArrayList<Payment>(paymentRepository.getAll());
        payments = payments.stream().filter(clieId -> Objects.equals(clieId.getClientId(), clientId)).toList();
        payments.size();
        return payments;
    }

    /**
     * Calculates the bonuses for barbers, pedicurists, and nail painters for a given month.
     *
     * @param yyyy_mm the month in "yyyy-MM" format to calculate bonuses for
     */
    public void getBonuses(String yyyy_mm) {
        List<Appointment> appointments = appointmentRepository.getAll();
//        Double barberBonus = 0.0, nailPainterBonus = 0.0, pedicuristBonus = 0.0;
        Double bonus=0.0;
        // Calculate bonuses for services performed within the specified month
        for (Appointment appointment : appointments) {
            DateTimeFormatter formatterFull = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String date1 = appointment.getDateTime().substring(0, 10);
            LocalDate parsedDate1 = LocalDate.parse(date1, formatterFull);
            LocalDate parsedDate2 = LocalDate.parse(yyyy_mm + "-01", formatterFull);
            LocalDate parsedDate3 = LocalDate.parse(yyyy_mm + "-31", formatterFull);

            // Check if the appointment date falls within the specified month
            if (parsedDate1.isAfter(parsedDate2) && parsedDate1.isBefore(parsedDate3)) {
                for (Service service : appointment.getService()) {
                    bonus+=0.1*service.getPrice();
//                    if (service.getType() == 1) {
//                        barberBonus += 0.1 * service.getPrice();
//                    }
//                    if (service.getType() == 2) {
//                        nailPainterBonus += 0.1 * service.getPrice();
//                    }
//                    if (service.getType() == 3) {
//                        pedicuristBonus += 0.1 * service.getPrice();
//                    }
//                    if (service.getType() == 4) {
//                        nailPainterBonus += 0.05 * service.getPrice();
//                        pedicuristBonus += 0.05 * service.getPrice();
//                    }
                }
            }
        }

        List<Barber> barbers = barberRepository.getAll();
        List<Pedicurist> pedicurists = pedicuristRepository.getAll();
        List<NailPainter> nailPainters = nailPainterRepository.getAll();

//        System.out.println("The bonus for the month " + yyyy_mm + " is for each:\nbarber: " + barberBonus / barbers.size()
//                + " Leuti\npedicurist: " + pedicuristBonus / pedicurists.size() + " Leuti\nnailPainter: "
//                + nailPainterBonus / nailPainters.size() + " Leuti\n");
        System.out.println("The bonus for the month "+yyyy_mm+" is "+bonus/(barbers.size()+pedicurists.size()+nailPainters.size()));
    }
}
