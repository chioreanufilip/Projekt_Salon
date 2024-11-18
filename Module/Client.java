package Module;
import Module.HasId;

/**
 * Represents a client in the salon system.
 * Stores the client's personal details such as name, phone number, email, and unique identifier.
 */
public class Client implements HasId {
    private Integer id;
    private String name;
    private String phoneNumber;
    private String email;

    /**
     * Constructs a Client object with the specified details.
     *
     * @param id          the unique identifier for the client
     * @param name        the name of the client
     * @param phoneNumber the phone number of the client
     */
    public Client(Integer id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    /**
     * Default constructor for the Client class.
     */
    public Client() {}

    /**
     * Retrieves the client's name.
     *
     * @return the name of the client
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the client's phone number.
     *
     * @return the phone number of the client
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Retrieves the client's email address.
     *
     * @return the email address of the client
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the unique identifier for the client.
     *
     * @param id the unique identifier to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Sets the client's name.
     *
     * @param name the name to set for the client
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the client's phone number.
     *
     * @param phoneNumber the phone number to set for the client
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Sets the client's email address.
     *
     * @param email the email address to set for the client
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retrieves the unique identifier for the client.
     *
     * @return the unique identifier of the client
     */
    @Override
    public Integer getId() {
        return id;
    }
}
