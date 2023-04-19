package shoppingbasket;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.emptyMap;
import static org.assertj.core.api.Assertions.assertThat;

class ShoppingBasketTest {

    @Test
    void shouldCalculateTotalPriceForNoItems() {
        ShoppingBasket shoppingBasket = new ShoppingBasket(emptyMap());

        float total = shoppingBasket.calculateTotal();

        assertThat(total).isZero();
    }

    @Test
    void shouldCalculateTotalPriceOfOneItem() {
        //1 item of $10 -> $10
        Map<String, Item> oneItem = new HashMap<>();
        oneItem.put("Bread", new Item(10, 1));
        ShoppingBasket shoppingBasket = new ShoppingBasket(oneItem);
        float total = shoppingBasket.calculateTotal();
        assertThat(total).isEqualTo(10);
    }

    @Test
    void shouldCalculateTotalPriceOfTwoItems() {
        Map<String, Item> twoItems = new HashMap<>();
        twoItems.put("Bread", new Item(6, 1));
        twoItems.put("Butter", new Item(5, 1));

        ShoppingBasket shoppingBasket = new ShoppingBasket(twoItems);
        float total = shoppingBasket.calculateTotal();

        assertThat(total).isEqualTo(11);
    }

    @Test
    void shouldCalculateTotalPriceOfItemsWithQuantityGreaterThanOne() {
        Map<String, Item> oneItem = new HashMap<>();
        oneItem.put("Bread", new Item(20, 5));

        ShoppingBasket shoppingBasket = new ShoppingBasket(oneItem);
        float total = shoppingBasket.calculateTotal();

        assertThat(total).isEqualTo(100);
    }

    @Test
    void shouldApply5PercentDiscountForOrderOver100() {
        // 2 steaks of $40 each and 3 boxes of cereal $7 -> $80 + $21 = $101 * 95% = $95.95
        Map<String, Item> twoItems = new HashMap<>();
        twoItems.put("Steak", new Item(40, 2));
        twoItems.put("Cereal", new Item(7, 3));

        ShoppingBasket shoppingBasket = new ShoppingBasket(twoItems);
        float total = shoppingBasket.calculateTotal();

        assertThat(total).isEqualTo(95.95f);
    }

    @Test
    void shouldApply10PercentDiscountForOrderOver200() {
        Map<String, Item> oneItemMoreThan200USD = new HashMap<>();
        oneItemMoreThan200USD.put("Expensive TV", new Item(220, 1));

        ShoppingBasket shoppingBasket = new ShoppingBasket(oneItemMoreThan200USD);
        float total = shoppingBasket.calculateTotal();

        assertThat(total).isEqualTo(198);
    }
}
