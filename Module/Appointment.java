package Module;

import java.time.LocalDateTime;

public class Appointment {
    private int ID;
    private LocalDateTime dateTime;
    private String status;
    private Client client;
    private Service service;

    public Appointment(int ID, LocalDateTime dateTime, Client client, Service service) {
        this.ID = ID;
        this.dateTime = dateTime;
        this.status = status;
        this.client = client;
        this.service = service;
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

}
