package Module;

/**
 * Represents a pedicurist, a type of employee who specializes in foot care.
 * This class extends the {@link Employee} class and adds a specific specialization in foot care.
 */
public class Pedicurist extends Employee {

    private String FootCareSpecialisation;

    /**
     * Constructs a Pedicurist object with the specified name, experience, specialty, foot care specialization, and ID.
     *
     * @param name                  the name of the pedicurist
     * @param experience            the years of experience the pedicurist has
     * @param speciality            the general specialty of the pedicurist
     * @param FootCareSpecialisation the specific specialization of the pedicurist in foot care
     * @param id                    the unique identifier of the pedicurist
     */
    public Pedicurist(String name, Integer experience, String speciality, String FootCareSpecialisation, Integer id) {
        super(name, experience, speciality, id);
        this.FootCareSpecialisation = FootCareSpecialisation;
    }
    public String getFootCareSpecialisation() {
        return FootCareSpecialisation;
    }

    public void setFootCareSpecialisation(String footCareSpecialisation) {
        FootCareSpecialisation = footCareSpecialisation;
    }

    /**
     * Default constructor for the Pedicurist class.
     */
    public Pedicurist() {}
}
