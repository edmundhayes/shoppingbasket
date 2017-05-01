package basket;

/**
 * Created by Edmund on 01/05/2017.
 */
public class Item {

    private int id;
    private String name;
    private int price;

    public Item(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    /*
    * Price now found via DataProxy lookup
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }*/
}
