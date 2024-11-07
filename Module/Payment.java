public class Payment {

    private Integer id;
    private String method;
    private double amount;

    public Payment(int id, String method, double amount) {
        this.id = id;
        this.method = method;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public String getMethod() {
        return method;
    }

    public int getid() {
        return id;
    }


}
