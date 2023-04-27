package yatzy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class YatzyTest {

    @Test
    void chanceScoresSumOfAllDice() {
        assertThat(Yatzy.chance(2, 3, 4, 5, 1)).isEqualTo(15);
        assertThat(Yatzy.chance(3, 3, 4, 5, 1)).isEqualTo(16);
    }

    @Test
    void yatzyScoresFifty() {
        assertThat(Yatzy.yatzy(4, 4, 4, 4, 4)).isEqualTo(50);
        assertThat(Yatzy.yatzy(6, 6, 6, 6, 6)).isEqualTo(50);
        assertThat(Yatzy.yatzy(6, 6, 6, 6, 3)).isZero();
    }

    @Test
    void ones() {
        assertThat(Yatzy.ones(1, 2, 3, 4, 5)).isEqualTo(1);
        assertThat(Yatzy.ones(1, 2, 1, 4, 5)).isEqualTo(2);
        assertThat(Yatzy.ones(6, 2, 2, 4, 5)).isZero();
        assertThat(Yatzy.ones(1, 2, 1, 1, 1)).isEqualTo(4);
    }

    @Test
    void twos() {
        assertThat(Yatzy.twos(1, 2, 3, 2, 6)).isEqualTo(4);
        assertThat(Yatzy.twos(2, 2, 2, 2, 2)).isEqualTo(10);
    }

    @Test
    void threes() {
        assertThat(Yatzy.threes(1, 2, 3, 2, 3)).isEqualTo(6);
        assertThat(Yatzy.threes(2, 3, 3, 3, 3)).isEqualTo(12);
    }

    @Test
    void fours() {
        assertThat(new Yatzy(4, 4, 4, 5, 5).fours()).isEqualTo(12);
        assertThat(new Yatzy(4, 4, 5, 5, 5).fours()).isEqualTo(8);
        assertThat(new Yatzy(4, 5, 5, 5, 5).fours()).isEqualTo(4);
    }

    @Test
    void fives() {
        assertThat(new Yatzy(4, 4, 4, 5, 5).fives()).isEqualTo(10);
        assertThat(new Yatzy(4, 4, 5, 5, 5).fives()).isEqualTo(15);
        assertThat(new Yatzy(4, 5, 5, 5, 5).fives()).isEqualTo(20);
    }

    @Test
    void sixes() {
        assertThat(new Yatzy(4, 4, 4, 5, 5).sixes()).isZero();
        assertThat(new Yatzy(4, 4, 6, 5, 5).sixes()).isEqualTo(6);
        assertThat(new Yatzy(6, 5, 6, 6, 6).sixes()).isEqualTo(24);
    }

    @Test
    void onePair() {
        assertThat(Yatzy.score_pair(3, 4, 3, 5, 6)).isEqualTo(6);
        assertThat(Yatzy.score_pair(5, 3, 3, 3, 5)).isEqualTo(10);
        assertThat(Yatzy.score_pair(5, 3, 6, 6, 5)).isEqualTo(12);
    }

    @Test
    void twoPair() {
        assertThat(Yatzy.two_pair(3, 3, 5, 4, 5)).isEqualTo(16);
        assertThat(Yatzy.two_pair(3, 3, 5, 5, 5)).isEqualTo(16);
    }

    @Test
    void threeOfAKind() {
        assertThat(Yatzy.three_of_a_kind(3, 3, 3, 4, 5)).isEqualTo(9);
        assertThat(Yatzy.three_of_a_kind(5, 3, 5, 4, 5)).isEqualTo(15);
        assertThat(Yatzy.three_of_a_kind(3, 3, 3, 3, 5)).isEqualTo(9);
    }

    @Test
    void fourOfAKind() {
        assertThat(Yatzy.four_of_a_kind(3, 3, 3, 3, 5)).isEqualTo(12);
        assertThat(Yatzy.four_of_a_kind(5, 5, 5, 4, 5)).isEqualTo(20);
        assertThat(Yatzy.four_of_a_kind(6, 1, 6, 6, 2)).isZero();
    }

    @Test
    void smallStraight() {
        assertThat(Yatzy.smallStraight(1, 2, 3, 4, 5)).isEqualTo(15);
        assertThat(Yatzy.smallStraight(2, 3, 4, 5, 1)).isEqualTo(15);
        assertThat(Yatzy.smallStraight(1, 2, 2, 4, 5)).isZero();
    }

    @Test
    void largeStraight() {
        assertThat(Yatzy.largeStraight(6, 2, 3, 4, 5)).isEqualTo(20);
        assertThat(Yatzy.largeStraight(2, 3, 4, 5, 6)).isEqualTo(20);
        assertThat(Yatzy.largeStraight(1, 2, 2, 4, 5)).isZero();
    }

    @Test
    void fullHouse() {
        assertThat(Yatzy.fullHouse(6, 2, 2, 2, 6)).isEqualTo(18);
        assertThat(Yatzy.fullHouse(2, 3, 4, 5, 6)).isZero();
    }
}
