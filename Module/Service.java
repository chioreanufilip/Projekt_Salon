package Module;

//import java.time.Duration;

public class Service implements HasId{
    private int ID;
    private String name;
    private String duration;
    private double price;
    private Integer type;///1 will be for barber, 2 for Nailpainter,3 for pedicurist,4 for NailPainter and Pedi


    public Service(int ID, String name, String duration, double price,Integer type) {
        this.ID = ID;
        this.name = name;
        this.duration = duration;
        this.price = price;
        this.type=type;
    }
    public Service() {}
    public Integer getId() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getDuration() {
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

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
