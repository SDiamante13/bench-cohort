package shoppingbasket;

import org.junit.jupiter.api.Test;

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
        ShoppingBasket shoppingBasket = new ShoppingBasket();
        assertThat(shoppingBasket.calculateTotal()).isEqualTo(0);
    }


    private class ShoppingBasket {
        public int calculateTotal() {
            return 0;
        }
    }
}
