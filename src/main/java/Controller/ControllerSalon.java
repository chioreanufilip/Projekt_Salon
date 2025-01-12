package Controller;

import ServiceSalon.ServiceSalon;
import Module.*;
import Exceptions.*;
import ServiceSalon.ServiceSalon;
import java.util.List;

/**
 * ControllerSalon serves as the controller layer for managing salon services and client-related operations.
 */
public class ControllerSalon {
    private final ServiceSalon serviceSalon;

    /**
     * Constructs a ControllerSalon with the specified ServiceSalon instance.
     *
     * @param serviceSalon The ServiceSalon instance to delegate service operations to.
     */
    public ControllerSalon(ServiceSalon serviceSalon) {
        this.serviceSalon = serviceSalon;
    }

        /**
         * Registers a new barber with the provided details.
         *
         * @param name        The name of the barber.
         * @param hairStyle   The barber's hairstyle specialty.
         * @param experience  The barber's years of experience.
         * @param speciality  The barber's specialty.
         * @param id          The unique ID for the barber.
         */
        public void enrollBarber (String name, String hairStyle,int experience, String speciality, Integer id){
            try {
                // Basic input validation
                if (name == null || name.trim().isEmpty()) {
                    throw new ValidationException("Barber name cannot be null or empty.");
                }
                if (experience < 0) {
                    throw new ValidationException("Experience cannot be negative.");
                }
                if (id == null || id <= 0) {
                    throw new ValidationException("ID must be a positive integer.");
                }
                serviceSalon.enrollBarber(name, hairStyle, experience, speciality, id);

            } catch (ValidationException e) {
                System.out.println("Validation Error: " + e.getMessage());
                throw e; // Propagate to Presentation Layer

            }
    }

        /**
         * Deletes an existing barber by their ID.
         *
         * @param id The unique ID of the barber to delete.
         */
        public void deleteBarber (Integer id){
            try {
                // Validate input
                if (id == null || id <= 0) {
                    throw new ValidationException("ID must be a positive integer.");
                }
                serviceSalon.deleteBarber(id);

            } catch (EntityNotFoundException e) {
                System.out.println("Error: Barber not found for ID " + id);
                throw e;

            } catch (ValidationException e) {
                System.out.println("Validation Error: " + e.getMessage());
                throw e;
            }
    }

        /**
         * Registers a new nail painter with the provided details.
         *
         * @param name              The name of the nail painter.
         * @param experience        The nail painter's years of experience.
         * @param speciality        The nail painter's specialty.
         * @param gelNailExperience Gel nail experience description.
         * @param id                The unique ID for the nail painter.
         */
        public void enrollNailPainter (String name,int experience, String speciality, String gelNailExperience, Integer
        id){
            try {
                validateName(name);
                validateExperience(experience);
                validateSpeciality(speciality);

                serviceSalon.enrollNailPainter(name, experience, speciality, gelNailExperience, id);
            }
            catch (ValidationException e) {System.out.println("Validation Error: " + e.getMessage());}
    }

        /**
         * Deletes an existing nail painter by their ID.
         *
         * @param id The unique ID of the nail painter to delete.
         */
        public void deleteNailPainter (Integer id) {
            try {validateId(id);
                serviceSalon.deleteNailPainter(id);
            } catch (EntityNotFoundException e) {System.out.println("Error: Nail painter not found for ID " + id);
            }
        }

        /**
         * Registers a new pedicurist with the provided details.
         *
         * @param name                   The name of the pedicurist.
         * @param experience             The pedicurist's years of experience.
         * @param speciality             The pedicurist's specialty.
         * @param FootCareSpecialisation Description of foot care specialization.
         * @param id                     The unique ID for the pedicurist.
         */
        public void enrollPedicurist (String name, Integer experience, String speciality, String
        FootCareSpecialisation, Integer id){
            try{validateName(name);
            validateExperience(experience);
            validateSpeciality(speciality);
            validateId(id);
        serviceSalon.enrollPedicurist(name, experience, speciality, FootCareSpecialisation, id);}
            catch (ValidationException e) {System.out.println("Validation Error: " + e.getMessage());}
    }

        /**
         * Deletes an existing pedicurist by their ID.
         *
         * @param id The unique ID of the pedicurist to delete.
         */
        public void deletePedicurist (Integer id){
            try{
                validateId(id);
            serviceSalon.deletePedicurist(id);
    }catch (ValidationException e) {System.out.println("Validation Error: " + e.getMessage());}
        }

        /**
         * Adds a new product with the provided details.
         *
         * @param name  The name of the product.
         * @param price The price of the product.
         * @param stock The stock quantity of the product.
         * @param type  The type/category of the product.
         * @param id    The unique ID for the product.
         */
        public void addProduct (String name, Double price, Integer stock, Integer type, Integer id){
        try{validateName(name);
            validatePrice(price);
            validateStock(stock);
            validateId(id);
            serviceSalon.addProduct(name, price, stock, type, id);}
        catch (ValidationException e) {System.out.println("Validation Error: " + e.getMessage());}
    }

        /**
         * Deletes an existing product by its ID.
         *
         * @param id The unique ID of the product to delete.
         */
        public void deleteProduct (Integer id){
            try {
                validateId(id);
                serviceSalon.deleteProduct(id);
            }
            catch (ValidationException e) {System.out.println("Validation Error: " + e.getMessage());}
    }

        /**
         * Retrieves a list of all available products.
         *
         * @return A list of all products.
         */
        public List<Produce> getAllProduce () {
        return serviceSalon.getAllProduce();
        }

        /**
         * Adds a new service with the provided details.
         *
         * @param ID       The unique ID for the service.
         * @param name     The name of the service.
         * @param duration The duration of the service.
         * @param price    The price of the service.
        //     * @param type     The type/category of the service.
         */
        public void addService ( int ID, String name, String duration,double price, List<Employee > employees){
        try {
            validateId(ID);
            validateName(name);
            validatePrice(price);

            serviceSalon.addService(ID, name, duration, price, employees);
        }
        catch (ValidationException e) {System.out.println("Validation Error: " + e.getMessage());}
        }

        /**
         * Retrieves a list of all available services.
         *
         * @return A list of all services.
         */
        public List<Service> getAllServices () {
        return serviceSalon.getAllServices();
    }

        /**
         * Registers a new review with the provided details.
         *
         * @param id      The unique ID for the review.
         * @param comment The comment for the review.
         * @param rating  The rating associated with the review.
         */
        public void enrollReview (Integer id, String comment, Integer rating, Integer clientID){
        try {
            validateId(id);
            serviceSalon.enrollReview(id, comment, rating, clientID);
    }catch (ValidationException e) {System.out.println("Validation Error: " + e.getMessage());}
        }

        /**
         * Deletes an existing review by its ID.
         *
         * @param id The unique ID of the review to delete.
         */
        public void deleteReview (Integer id){
        serviceSalon.deleteReview(id);
    }

        /**
         * Retrieves a list of all reviews.
         *
         * @return A list of all reviews.
         */
        public List<Review> getAllReviews () {
        return serviceSalon.getAllReviews();
    }

        /**
         * Retrieves a review by its ID.
         *
         * @param id The unique ID of the review.
         * @return The review object, if found.
         */
        public Review getReviewById ( int id){
        return serviceSalon.getReviewById(id);
    }

        /**
         * Registers a new appointment with the provided details.
         *
         * @param id      The unique ID for the appointment.
         * @param time    The date and time of the appointment.
         * @param client  The client attending the appointment.
         * @param service The list of services for the appointment.
         */
        public void enrollAppointment (Integer id, String time, Client client, List < Service > service, Payment payment) {
            try {
                validateId(id);
                serviceSalon.enrollAppointment(id, time, client, service, payment);
            }
            catch (ValidationException e) {System.out.println("Validation Error: " + e.getMessage());}
        }

        /**
         * Registers a new client with the provided details.
         *
         * @param id          The unique ID for the client.
         * @param name        The name of the client.
         * @param phoneNumber The phone number of the client.
         */
        public void enrollClient (Integer id, String name, String phoneNumber){
        try {
            validateId(id);
            serviceSalon.enrollClient(id, name, phoneNumber);
    }catch (ValidationException e) {System.out.println("Validation Error: " + e.getMessage());}
        }

        /**
         * Retrieves a list of all clients.
         *
         * @return A list of all clients.
         */
        public List<Client> getAllClients () {
        return serviceSalon.getAllClients();
    }

        /**
         * Deletes an existing appointment by its ID.
         *
         * @param id The unique ID of the appointment to delete.
         */
        public void deleteAppointment (Integer id){
        serviceSalon.deleteAppointment(id);
    }

        /**
         * Retrieves a list of all appointments.
         *
         * @return A list of all appointments.
         */
        public List<Appointment> getAllAppointments () {
        return serviceSalon.getAllAppointments();
    }

        /**
         * Retrieves an appointment by its ID.
         *
         * @param id The unique ID of the appointment.
         * @return The appointment object, if found.
         */
        public Appointment getAppointmentById ( int id){
        return serviceSalon.getAppointmentById(id);
    }

        /**
         * Registers a new payment for the specified services and products.
         *
         * @param id       The unique ID for the payment.
         * @param services The list of services included in the payment.
         * @param products The list of products included in the payment.
         */
        public void enrollPayment (Integer id, List < Service > services, List < Produce > products, Integer clientId){
        try{
            validateId(id);
            serviceSalon.enrollPayment(id, services, products, clientId);
    }catch (ValidationException e) {System.out.println("Validation Error: " + e.getMessage());}
        }

        /**
         * Retrieves a list of all payments.
         *
         * @return A list of all payments.
         */
        public List<Payment> getAllPayment () {
        return serviceSalon.getAllPayments();
    }

        /**
         * Retrieves a payment by its ID.
         *
         * @param id The unique ID of the payment.
         * @return The payment object, if found.
         */
        public Payment getPaymentById (Integer id){
        return serviceSalon.getPaymentById(id);
    }

        /**
         * Deletes an existing payment by its ID.
         *
         * @param id The unique ID of the payment to delete.
         */
        public void deletePayment (Integer id){
        serviceSalon.deletePayment(id);
    }

        /**
         * Retrieves a list of all payments.
         *
         * @return A list of all payments.
         */
        public List<Payment> getAllPayments () {
        return serviceSalon.getAllPayments();
    }

        /**
         * Retrieves a client by their ID.
         *
         * @param id The unique ID of the client.
         * @return The client object, if found.
         */
        public Client getClientById ( int id){
        return serviceSalon.getClientById(id);
    }

        /**
         * Applies a loyalty discount of 50% for clients with more than three appointments.
         *
         * @param clientId      The ID of the client.
         * @param appointmentId The ID of the appointment to apply the discount to.
         */
        public void applyLoyaltyDiscount (Integer clientId, Integer appointmentId){
        serviceSalon.applyLoyaltyDiscount(clientId, appointmentId);
    }
        public List<Produce> sortProductByPrice () {
        return serviceSalon.sortProductsByPrice();
    }
        public List<Appointment> sortByTimeAppointments () {
        return serviceSalon.sortAppointmentsByTime();
    }
        public List<Review> filterByRatingReview (Integer rating){
        return serviceSalon.filterReviewsByRating(rating);
    }
        public List<Payment> filterPaymentByClient (Integer clientId){
        return serviceSalon.filterPaymentsByClients(clientId);
    }
        public void getThemBonuses (String year_month){
            try{
        serviceSalon.getBonuses(year_month);}
            catch (BussinessLogicException e){ System.out.println(e.getMessage());}
    }
    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new ValidationException("Name cannot be null or empty.");
        }
    }

    private void validateExperience(Integer experience) {
        if (experience == null || experience < 0) {
            throw new ValidationException("Experience must be a positive number.");
        }
    }

    private void validateSpeciality(String speciality) {
        if (speciality == null || speciality.trim().isEmpty()) {
            throw new ValidationException("Speciality cannot be null or empty.");
        }
    }

    private void validateId(Integer id) {
        if (id == null || id <= 0) {
            throw new ValidationException("ID must be a positive number.");
        }
    }

    private void validatePrice(Double price) {
        if (price == null || price <= 0) {
            throw new ValidationException("Price must be a positive number.");
        }
    }

    private void validateStock(Integer stock) {
        if (stock == null || stock < 0) {
            throw new ValidationException("Stock must be a non-negative number.");
        }
    }
    public List<Employee> getAllEmployees() {
            return serviceSalon.getAllEmployees();
    }
}
