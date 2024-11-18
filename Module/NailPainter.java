package Module;
import java.util.Vector;

/**
 * Represents a Nail Painter employee specializing in nail care services.
 * This class extends the {@link Employee} class and includes additional attributes
 * specific to nail painting, such as gel nail experience.
 */
public class NailPainter extends Employee {
    private String gelNailExperience;

    /**
     * Constructs a NailPainter object with the specified attributes.
     *
     * @param name              the name of the nail painter
     * @param experience        the years of experience the nail painter has
     * @param speciality        the specialty or expertise of the nail painter
     * @param gelNailExperience the level of experience or expertise in gel nail services
     * @param id                the unique identifier for the nail painter
     */
    public NailPainter(String name, int experience, String speciality, String gelNailExperience, Integer id) {
        super(name, experience, speciality, id);
        this.gelNailExperience = gelNailExperience;
    }

    /**
     * Default constructor for the NailPainter class.
     */
    public NailPainter() {}
}
