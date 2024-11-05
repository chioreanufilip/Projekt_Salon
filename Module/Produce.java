package Module;
import java.util.Vector;

public class Produce {
    private Integer id;
    private String name;
    private Double price;
    private Integer stock;
    private static Vector<Produce> products = new Vector<Produce>();
    public Produce(String name, Double price, Integer stock) {
        if (products.isEmpty()) this.id=1;
        else {
            this.id = products.lastElement().id + 1;
        }
        this.name = name;
        this.price = price;
        this.stock = stock;
        products.add(this);
    }
}
