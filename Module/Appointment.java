package Module;

import java.time.LocalDateTime;
import java.util.List;
import Module.HasId;

public class Appointment implements HasId {
    private Integer ID;
    private String dateTime;
    private String status;
    private Client client;
    private List<Service> service;
    private Employee employee;
    private List<Produce> products;
    private Payment payment;

    /**
     * constructor
     *
     * @param ID
     * @param dateTime
     * @param client
     * @param service
     */
    public Appointment(Integer ID, String dateTime, Client client, List<Service> service) {
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
     * gets id
     * @return
     */
    public int getID() {
        return ID;
    }

    /**
     * sets id
     * @param ID
     */
    public void setID(Integer ID) {
        this.ID = ID;
    }

    /**
     * gets date time
     * @return
     */
    public String getDateTime() {
        return dateTime;
    }

    /**
     * sets date time
     * @param dateTime
     */
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    /**
     *
     * @return
     */
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Service> getService() {
        return service;
    }

//    public void setService(Service service) {
//        this.service = service;
//    }

    public Employee getEmployee() {return employee;}

    public void setEmployee(Employee employee) {this.employee = employee;}

    public List<Produce> getProducts() {return products;}

    public void setProducts(List<Produce> products) {this.products = products;}

    public Payment getPayment() {return payment;}

    public void setPayment(Payment payment) {this.payment = payment;}
    public Integer getId(){
        return ID;
    }
}
