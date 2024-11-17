package Module;

import java.util.List;

public class Payment implements HasId {

    private Integer id;
    private String method;
    private double amount;

    public Payment(Integer id, List<Service> services, List<Produce> products) {
        this.id = id;
        for (int i = 0; i < services.size(); i++) {
            amount += services.get(i).getPrice();
        }
        for (int i = 0; i < products.size(); i++) {
            amount += products.get(i).getPrice();
        }
    }
    public Payment(){}
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getMethod() {
        return method;
    }

    public Integer getId() {
        return id;
    }
}