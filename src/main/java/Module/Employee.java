package Module;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Barber.class, name = "Barber"),
        @JsonSubTypes.Type(value = NailPainter.class, name = "NailPainter"),
        @JsonSubTypes.Type(value = Pedicurist.class, name = "Pedicurist")
})
/**
 * Represents an abstract employee in the system.
 * This class serves as a base for specific employee types, storing shared attributes
 * such as name, experience, specialty, and unique identifier.
 */
public abstract class Employee implements HasId {
    protected Integer id;
    protected String name;
    protected Integer experience;
    protected String speciality;

    /**
     * Default constructor for the Employee class.
     */
    protected Employee() {}

    /**
     * Constructs an Employee object with the specified attributes.
     *
     * @param name       the name of the employee
     * @param experience the years of experience the employee has
     * @param speciality the specialty or expertise of the employee
     * @param id         the unique identifier for the employee
     */
    protected Employee(String name, Integer experience, String speciality, Integer id) {
        this.name = name;
        this.experience = experience;
        this.speciality = speciality;
        this.id = id;
    }

    /**
     * Retrieves the unique identifier for the employee.
     *
     * @return the unique identifier of the employee
     */
    public Integer getId() {
        return id;
    }

    /**
     * Retrieves the name of the employee.
     *
     * @return the name of the employee
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the employee.
     *
     * @param name the name to set for the employee
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the years of experience the employee has.
     *
     * @return the experience of the employee in years
     */
    public Integer getExperience() {
        return experience;
    }

    /**
     * Sets the years of experience for the employee.
     *
     * @param experience the experience to set for the employee
     */
    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    /**
     * Retrieves the specialty or area of expertise of the employee.
     *
     * @return the specialty of the employee
     */
    public String getSpeciality() {
        return speciality;
    }

    /**
     * Sets the specialty or area of expertise for the employee.
     *
     * @param speciality the specialty to set for the employee
     */
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
