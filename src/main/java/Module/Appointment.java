package Module;

import java.util.List;

/**
 * Represents an appointment in the salon system.
 * Includes details such as date, time, status, client, services, employee, products, and payment.
 */
public class Appointment implements HasId {
    private Integer ID;
    private String dateTime;
    private String status;
    private Client client;
    private List<Service> service;
    private Employee employee;
    private List<Produce> products;
    private Payment payment;
    private Appointment type;

    /**
     * Default constructor for the Appointment class.
     */
    public Appointment() {}

    /**
     * Constructs an Appointment with specified details.
     *
     * @param ID        the unique identifier of the appointment
     * @param dateTime  the date and time of the appointment
     * @param client    the client associated with the appointment
     * @param service   the list of services for the appointment
     */
    public Appointment(Integer ID, String dateTime, Client client, List<Service> service,Payment payment) {
        this.ID = ID;
        this.dateTime = dateTime;
        this.status = status;
        this.client = client;
        this.service = service;
        this.employee = employee;
        this.products = products;
        this.payment = payment;
    }

    /**
     * Sets the unique identifier of the appointment.
     *
     * @param ID the unique identifier
     */
    public void setID(Integer ID) {
        this.ID = ID;
    }

    /**
     * Retrieves the date and time of the appointment.
     *
     * @return the date and time of the appointment
     */
    public String getDateTime() {
        return dateTime;
    }

    /**
     * Sets the date and time of the appointment.
     *
     * @param dateTime the date and time to set
     */
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * Retrieves the current status of the appointment.
     *
     * @return the status of the appointment
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the appointment.
     *
     * @param status the status to set (e.g., "scheduled", "completed")
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Retrieves the client associated with the appointment.
     *
     * @return the client of the appointment
     */
    public Client getClient() {
        return client;
    }

    /**
     * Sets the client associated with the appointment.
     *
     * @param client the client to associate with the appointment
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Retrieves the list of services for the appointment.
     *
     * @return the list of services
     */
    public List<Service> getService() {
        return service;
    }

    /**
     * Retrieves the employee assigned to the appointment.
     *
     * @return the employee associated with the appointment
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * Sets the employee for the appointment.
     *
     * @param employee the employee to assign
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * Retrieves the list of products used during the appointment.
     *
     * @return the list of products
     */
    public List<Produce> getProducts() {
        return products;
    }

    /**
     * Sets the list of products for the appointment.
     *
     * @param products the list of products to set
     */
    public void setProducts(List<Produce> products) {
        this.products = products;
    }

    /**
     * Retrieves the payment details associated with the appointment.
     *
     * @return the payment details
     */
    public Payment getPayment() {
        return this.payment;
    }

    /**
     * Sets the payment details for the appointment.
     *
     * @param payment the payment details to associate
     */
    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    /**
     * Retrieves the unique identifier of the appointment.
     *
     * @return the unique identifier of the appointment
     */
    public Integer getId() {
        return ID;
    }

//    public void setPayment(Payment payment) {
//        this.payment = payment;
//    }
}
