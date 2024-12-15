package Module;

import java.util.List;

/**
 * Represents a service offered in the salon. The service has an ID, a name, a duration, a price, and a type which corresponds
 * to different employee types.
 */
public class Service implements HasId {

    private int ID;
    private String name;
    private String duration;
    private double price;
    private Integer type;  // Type 1 for barber, 2 for Nailpainter, 3 for pedicurist, 4 for both NailPainter and Pedi
   private List<Employee> employees;
    /**
     * Constructs a Service object with the specified details.
     *
     * @param ID       the unique identifier of the service
     * @param name     the name of the service
     * @param duration the duration of the service (e.g., "30 minutes")
     * @param price    the price of the service
//     * @param type     the type of service (1 for barber, 2 for Nailpainter, 3 for pedicurist, 4 for both NailPainter and Pedi)
     */
//    public Service(int ID, String name, String duration, double price, Integer type) {
//        this.ID = ID;
//        this.name = name;
//        this.duration = duration;
//        this.price = price;
//        this.type = type;
//    }
    public Service(int ID, String name, String duration, double price, List<Employee> Employees) {
        this.ID = ID;
        this.name = name;
        this.duration = duration;
        this.price = price;
//        this.type = type;
        this.employees=Employees;
    }

    /**
     * Default constructor for the Service class.
     */
    public Service() {}

    /**
     * Returns the unique identifier of the service.
     *
     * @return the ID of the service
     */
    public Integer getId() {
        return ID;
    }

    /**
     * Returns the name of the service.
     *
     * @return the name of the service
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the duration of the service.
     *
     * @return the duration of the service (e.g., "45 minutes")
     */
    public String getDuration() {
        return duration;
    }

    /**
     * Returns the price of the service.
     *
     * @return the price of the service
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the unique identifier for the service.
     *
     * @param ID the ID to set for the service
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * Sets the name for the service.
     *
     * @param name the name to set for the service
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the duration for the service.
     *
     * @param duration the duration to set for the service
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * Sets the price for the service.
     *
     * @param price the price to set for the service
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Returns the type of service (indicating the employee category).
     *
     * @return the type of the service
     */
//    public Integer getType() {
//        return type;
//    }

    /**
     * Sets the type for the service.
     *
//     * @param type the type to set for the service (1 for barber, 2 for Nailpainter, 3 for pedicurist, 4 for both NailPainter and Pedi)
     */
//    public void setType(Integer type) {
//        this.type = type;
//    }

    public List<Employee> getEmployees() {
        return this.employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
