package shoppingbasket;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SampleTest {

    @Test
    void givenAnEmptyBasketWhenCalculateTotalThenReturn0() {
        assertThat(ShoppingBasket.getTotal()).isEqualTo(0);
    }

    @Test
    void givenAnEmptyBasketWhenCalculateQuantityShouldReturn0() {
        assertThat(ShoppingBasket.getQuantity()).isEqualTo(0);
    }

    @Test
    void givenABasketWithAnItemWhenCalculateQuantityShouldReturnOne() {
        ShoppingBasket.addItem("Candy", 50);
        assertThat(ShoppingBasket.getTotal()).isNotEqualTo(0);
    }

    private static class ShoppingBasket {

        public static int getTotal() {
            if ()
                return 0;
        }

        public static int getQuantity() {
            return 0;
        }
    }
}