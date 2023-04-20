package gameoflife;

// import com.sun.imageio.plugins.tiff.TIFFFaxCompressor;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CellTest {

    @Test
    void cellWithOneLiveNeighborDies() {
        Cell cell = new Cell();
        assertThat(cell.nextState(1)).isEqualTo(CellState.DEAD);
    }

    private class Cell {
        public CellState nextState(int liveNeighbors) {
            return CellState.DEAD;
        }
    }
}
