import java.time.Duration;

public class Service {
    private int ID;
    private String name;
    private Duration duration;
    private double price;

    public Service(int ID, String name, Duration duration, double price) {
        this.ID = ID;
        this.name = name;
        this.duration = duration;
        this.price = price;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public Duration getDuration() {
        return duration;
    }

    public double getPrice() {
        return price;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
