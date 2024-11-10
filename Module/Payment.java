package Module;

import java.util.List;

public class Payment implements HasId{

    private Integer id;
    private String method;
    private double amount;

    public Payment(Integer id, List<Service> services, List<Produce> products) {
        this.id = id;
//        this.method = method;
//        this.amount = 0;
        for (int i = 0; i < services.size(); i++) {
            amount+=services.get(i).getPrice();
        }
        for (int i = 0; i < products.size(); i++) {
            amount+=products.get(i).getPrice();
        }
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

//    public static Payment createPaymentForAppointment(Service service, List<Produce> products, String paymentMethod, int paymentId) {
//        double totalAmount = service.getPrice();  // Start with the service price
//        for (Produce product : products) {
//            totalAmount += product.getPrice();  // Add product prices
//        }
//        return new Payment(Integer.valueOf(paymentId), paymentMethod, Double.valueOf(totalAmount));
//    }

}
