package shoppingbasket;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SampleTest {

    @Test
    void givenAnEmptyBasketWhenCalculateTotalThenReturn0() {

        assertThat(ShoppingBasket.getTotal()).isEqualTo(0);
    }

    @Test
    void givenAnEmptyBasketWithAnItemWhenFindingReturnTrue() {

        assertThat(ShoppingBasket.getTotal()).isEqualTo(0);
    }

    private static class ShoppingBasket {
        public static int getTotal() {
            return 0;
        }
    }
}
