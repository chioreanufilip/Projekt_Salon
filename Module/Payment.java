public class Payment {

    private int ID;
    private String method;
    private double amount;

    public Payment(int ID, String method, double amount) {
        this.ID = ID;
        this.method = method;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public String getMethod() {
        return method;
    }

    public int getID() {
        return ID;
    }


}
