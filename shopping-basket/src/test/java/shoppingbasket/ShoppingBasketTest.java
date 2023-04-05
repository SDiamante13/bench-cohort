package shoppingbasket;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;
import static org.assertj.core.api.Assertions.assertThat;

class ShoppingBasketTest {

    /*
    shouldHaveZeroTotalPriceForNoItems
    0 items -> $0

    shouldCalculateTotalPriceOfOneItem
    1 item of $10 -> $10

    shouldCalculateTotalPriceOfTwoItems
    2 items of $5 and $6 -> $11

    shouldCalculateTotalPriceOfMultipleItemsOfSameName
    1 item with quantity of 5 $20 -> $100

    shouldApply5PercentDiscountForOrderOver100
    2 steaks of $40 each and 3 boxes of cereal $7 -> $80 + $21 = $101 * 95% = $95.95

    shouldApply10PercentDiscountForOrderOver200
    1 TV of $220 -> $198

    shouldFindOutTheQuantityOfAParticularItem
    item has 1 apple, 2 orange, and 3 bananas -> find each quantity
    */


    @Test
    void shouldCalculateTotalPriceForNoItems() {
        ShoppingBasket shoppingBasket = new ShoppingBasket(emptyMap());

        int total = shoppingBasket.calculateTotal();

        assertThat(total).isZero();
    }

    @Test
    void shouldCalculateTotalPriceOfOneItem() {
        //1 item of $10 -> $10
        ShoppingBasket shoppingBasket = new ShoppingBasket();
        int total = shoppingBasket.calculateTotal();
        assertThat(total).isEqualTo(10);
    }

    private class ShoppingBasket {

        private Map<String, Item> items;

        public ShoppingBasket(Map<String, Item> items) {
            this.items = items;
        }

        public int calculateTotal() {
            return 0;
        }
    }


    private class Item {

        private int price;
        private int quantity;

        public Item(int price, int quantity) {
            this.price = price;
            this.quantity = quantity;
        }
    }
}
