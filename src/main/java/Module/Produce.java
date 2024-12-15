package Module;

/**
 * Represents a product used in the salon, such as items for barbers, nail painters, or pedicurists.
 * Each product has a name, price, stock quantity, and type indicating which employee it is associated with.
 */
public class Produce implements HasId {

    private Integer id;
    private String name;
    private Double price;
    private Integer stock;
    private Integer type;  // 1 for barber, 2 for NailPainter, 3 for Pedicurist, 4 for both NailPainter and Pedicurist

    /**
     * Constructs a Produce object with the specified name, price, stock, type, and id.
     *
     * @param name  the name of the product
     * @param price the price of the product
     * @param stock the available stock quantity of the product
     * @param type  the type of employee the product is associated with (1 for barber, 2 for NailPainter,
     *              3 for Pedicurist, 4 for both NailPainter and Pedicurist)
     * @param id    the unique identifier for the product
     */
    public Produce(String name, Double price, Integer stock, Integer type, Integer id) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.id = id;
    }

    /**
     * Returns the unique identifier of the product.
     *
     * @return the ID of the product
     */
    public Integer getId() {
        return id;
    }

    /**
     * Returns the name of the product.
     *
     * @return the name of the product
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the product.
     *
     * @param name the name of the product to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the price of the product.
     *
     * @return the price of the product
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Sets the price of the product.
     *
     * @param price the price of the product to set
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Returns the available stock quantity of the product.
     *
     * @return the stock quantity of the product
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * Sets the stock quantity of the product.
     *
     * @param stock the stock quantity to set
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * Returns the type of employee the product is associated with.
     * 1 for barber, 2 for NailPainter, 3 for Pedicurist, and 4 for both NailPainter and Pedicurist.
     *
     * @return the type of the product
     */
    public Integer getType() {
        return type;
    }

    /**
     * Sets the type of employee the product is associated with.
     *
     * @param type the type of the product to set (1, 2, 3, or 4)
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * Default constructor for the Produce class.
     */
    public Produce() {}
}
