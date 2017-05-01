package basket;

import data.DataProxy;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Stores a map of items and their quantities
 */
public class Basket {

    private static Logger logger = Logger.getLogger(Basket.class.getName());

    private Map<Item, Integer> basket;
    private DataProxy dataProxy;

    public Basket(DataProxy dataProxy){
        this.dataProxy = dataProxy;
        basket = new HashMap<>();
    }

    public void add(Item item){
        if(item != null) {
            int qty;
            if (basket.containsKey(item)) {
                //Item already present. Increase qty
                qty = basket.get(item);
                qty++;
            } else {
                qty = 1;
            }
            basket.put(item, qty);
            logger.info("Item added: " + item.getName());
        } else {
            logger.info("Null item. Not added to basket");
        }
    }

    public Map<Item, Integer> getBasket(){
        return basket;
    }

    public double getTotalCost(){
        double total = 0;

        for(Map.Entry<Item, Integer> entry: basket.entrySet()){
            Item item = entry.getKey();
            Integer qty = entry.getValue();
            //Find price of item from data store
            double price = dataProxy.getPrice(item);
            total += qty * price;
        }
        logger.info("getTotalCost called:" + total);
        return total;
    }

}
