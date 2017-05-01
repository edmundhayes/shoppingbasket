package data;

import basket.Item;

/**
 * Interface for accessing the items catalogue and price service
 */
public interface DataProxy {

    Item getItem(int id);

    Double getPrice(Item item);
}
