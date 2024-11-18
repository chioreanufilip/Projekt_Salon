package Module;

import java.util.List;

/**
 * Represents a payment made for services and products in the salon.
 * This class calculates the total payment amount based on the prices of the provided services and products.
 * Implements the {@link HasId} interface for unique identification.
 */
public class Payment implements HasId {

    private Integer id;
    private String method;
    private double amount;

    /**
     * Constructs a Payment object with the specified ID and calculates the total amount
     * based on the given lists of services and products.
     *
     * @param id        the unique identifier of the payment
     * @param services  the list of services included in the payment
     * @param products  the list of products included in the payment
     */
    public Payment(Integer id, List<Service> services, List<Produce> products) {
        this.id = id;
        for (int i = 0; i < services.size(); i++) {
            amount += services.get(i).getPrice();
        }
        for (int i = 0; i < products.size(); i++) {
            amount += products.get(i).getPrice();
        }
    }

    /**
     * Default constructor for the Payment class.
     */
    public Payment() {}

    /**
     * Retrieves the total amount of the payment.
     *
     * @return the payment amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets the payment amount.
     *
     * @param amount the new payment amount
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Retrieves the payment method.
     *
     * @return the payment method
     */
    public String getMethod() {
        return method;
    }

    /**
     * Retrieves the unique identifier of the payment.
     *
     * @return the payment ID
     */
    public Integer getId() {
        return id;
    }
}
