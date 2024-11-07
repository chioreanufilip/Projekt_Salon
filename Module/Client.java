public class Client {
    private int ID;
    private String name;
    private String phoneNumber;
    private String email;

    public Client(int ID, String name, String phoneNumber, String email) {
        this.ID = ID;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}
