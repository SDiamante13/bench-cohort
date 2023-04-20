package gameoflife;

// import com.sun.imageio.plugins.tiff.TIFFFaxCompressor;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CellTest {

    @Test
    void deadCellWithOneLiveNeighborDies() {
        Cell cell = new Cell(CellState.DEAD);
        assertThat(cell.nextState(1)).isEqualTo(CellState.DEAD);
    }

    @Test
    void deadCellWithTwoLiveNeighborDies() {
        Cell cell = new Cell(CellState.DEAD);
        assertThat(cell.nextState(2)).isEqualTo(CellState.DEAD);
    }
    private class Cell {

        public Cell(CellState cellState) {

        }

        public CellState nextState(int liveNeighbors) {
            return CellState.DEAD;
        }
    }
}
