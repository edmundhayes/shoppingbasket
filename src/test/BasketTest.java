import basket.Basket;
import basket.Item;
import data.DataProxy;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Edmund on 01/05/2017.
 */
public class BasketTest {

    private Basket basket;
    private DataProxy dataProxy;
    private Item item;
    private Item item2;

    @Before
    public void setup(){
        dataProxy = new FakeDataProxy();
        basket = new Basket(dataProxy);

        item  = dataProxy.getItem(123);
        item2 = dataProxy.getItem(456);
    }

    @Test
    public void testSingleAdd(){
        basket.add(item);
        assertEquals(basket.getBasket().size(),1,0);
        assertEquals(basket.getBasket().get(item),1,0);
    }

    @Test
    public void testAddNull(){
        basket.add(null);
        assertEquals(basket.getBasket().size(),0,0);
    }

    @Test
    public void testDoubleAddSameItem(){
        basket.add(item);
        basket.add(item);
        assertEquals(basket.getBasket().size(),1,0);
        assertEquals(basket.getBasket().get(item),2,0);
    }

    @Test
    public void testDoubleAddDifferentItem(){
        basket.add(item);
        basket.add(item2);
        assertEquals(basket.getBasket().size(),2,0);
        assertEquals(basket.getBasket().get(item),1,0);
        assertEquals(basket.getBasket().get(item2),1,0);
    }

    @Test
    public void testTotal(){
        basket.add(item);
        basket.add(item2);
        assertEquals(basket.getBasket().size(),2,0);
        assertEquals(basket.getTotalCost(),15.0,0);
    }
}
