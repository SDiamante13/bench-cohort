package shoppingbasket;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SampleTest {

    ShoppingBasket basket = new ShoppingBasket();
    @Test
    void givenAnEmptyBasketWhenCalculateTotalThenReturn0() {
        assertThat(basket.getTotal()).isEqualTo(0);
    }

    @Test
    void givenAnEmptyBasketWhenCalculateQuantityShouldReturn0() {
        assertThat(basket.getQuantity()).isEqualTo(0);
    }

    @Test
    void givenABasketWithAnItemWhenCalculateQuantityShouldReturnOne() {
//        ShoppingBasket.addItem("Candy", 50);
//        assertThat(ShoppingBasket.getTotal()).isNotEqualTo(0);
    }

    private class ShoppingBasket {

        public ShoppingBasket() {
        }

        public int getTotal() {
//            if ()
            return 0;
        }

        public int getQuantity() {
            return 0;
        }
    }
}