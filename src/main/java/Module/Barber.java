package Module;

/**
 * Represents a barber in the salon system.
 * Extends the Employee class and includes additional attributes and methods specific to a barber.
 */
public class Barber extends Employee {
    private String hairStyle;

    /**
     * Retrieves the hair styling specialty of the barber.
     *
     * @return the hairstyle specialty of the barber
     */
    public String getHairStyle() {
        return hairStyle;
    }

    /**
     * Sets the hair styling specialty of the barber.
     *
     * @param hairStyle the hairstyle specialty to set
     */
    public void setHairStyle(String hairStyle) {
        this.hairStyle = hairStyle;
    }

    /**
     * Default constructor for the Barber class.
     */
    public Barber() {}

    /**
     * Constructs a Barber object with specified details.
     *
     * @param name        the name of the barber
     * @param hairStyle   the hair styling specialty of the barber
     * @param experience  the number of years of experience the barber has
     * @param speciality  the speciality area of the barber
     * @param id          the unique identifier of the barber
     */
    public Barber(String name, String hairStyle, int experience, String speciality, Integer id) {
        super(name, experience, speciality, id);
        this.hairStyle = hairStyle;
    }
}
