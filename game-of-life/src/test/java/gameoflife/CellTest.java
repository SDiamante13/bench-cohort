package gameoflife;

import com.sun.imageio.plugins.tiff.TIFFFaxCompressor;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CellTest {

    @Test
    void name() {
        Cell cell = new Cell();
        assertThat(cell.nextState(1)).isEqualTo(CellState.DEAD);
    }

    private class Cell {
        public CellState nextState(int neighbors) {
        }
    }
}
