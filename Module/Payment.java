package Module;

import java.util.List;

public class Payment implements HasId{

    private Integer id;
    private String method;
    private double amount;

    public Payment(Integer id, String method, Double amount) {
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

    public Integer getId() {
        return id;
    }

    public static Payment createPaymentForAppointment(Service service, List<Produce> products, String paymentMethod, int paymentId) {
        double totalAmount = service.getPrice();  // Start with the service price
        for (Produce product : products) {
            totalAmount += product.getPrice();  // Add product prices
        }
        return new Payment(Integer.valueOf(paymentId), paymentMethod, Double.valueOf(totalAmount));
    }

}
