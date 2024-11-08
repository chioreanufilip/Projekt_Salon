package Module;
import java.util.Vector;

public class Produce implements HasId{
    private Integer id;
    private String name;
    private Double price;
    private Integer stock;
//    private static Vector<Produce> products = new Vector<Produce>();
    public Produce(String name, Double price, Integer stock,Integer id) {
//        if (products.isEmpty()) this.id=1;
//        else {
//            this.id = products.lastElement().id + 1;
//        }
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.id = id;
//        products.add(this);
    }
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
