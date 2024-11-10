package Module;

import java.time.LocalDateTime;
import java.util.List;

public class Appointment implements Module.HasId {
    private int ID;
    private LocalDateTime dateTime;
    private String status;
    private Client client;
    private Service service;
    private Employee employee;
    private List<Produce> products;
    private Payment payment;


    public Appointment(int ID, LocalDateTime dateTime, Client client, Service service, Employee employee) {
        this.ID = ID;
        this.dateTime = dateTime;
        this.status = status;
        this.client = client;
        this.service = service;
        this.employee = employee;
        this.products = products;
        this.payment = payment;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

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

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Employee getEmployee() {return employee;}

    public void setEmployee(Employee employee) {this.employee = employee;}

    public List<Produce> getProducts() {return products;}

    public void setProducts(List<Produce> products) {this.products = products;}

    public Payment getPayment() {return payment;}

    public void setPayment(Payment payment) {this.payment = payment;}
}
