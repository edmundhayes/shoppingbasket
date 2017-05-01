import basket.Item;
import data.DataProxy;

import java.util.HashMap;
import java.util.Map;

/**
 * Mock data for testing. Two items with prices
 */
public class FakeDataProxy implements DataProxy {

    private Map<Item, Double> items = new HashMap<>();

    public FakeDataProxy(){
        Item item = new Item(123, "Michael Bolton hits");
        Item item2 = new Item(456, "Jump to conclusions mat");

        items.put(item,10.0);
        items.put(item2,5.0);
    }

    public Item getItem(int id){
        for(Item item: items.keySet()){
            if(item.getId() == id){
                return item;
            }
        }
        return null;
    }

    public Double getPrice(Item item){
        if(items.containsKey(item)){
            return items.get(item);
        }
        return null;
    }
}
