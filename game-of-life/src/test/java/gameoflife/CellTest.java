package gameoflife;

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

    @Test
    void deadCellWithThreeNeighborLives() {
        Cell cell = new Cell(CellState.DEAD);
        assertThat(cell.nextState(3)).isEqualTo(CellState.ALIVE);
    }

    @Test
    void liveCellWithOneLiveNeighborDies() {
        Cell cell = new Cell(CellState.ALIVE);

        assertThat(cell.nextState(1)).isEqualTo(CellState.DEAD);
    }

    @Test
    void liveCellWithThreeLiveNeighborsLives() {
        Cell cell = new Cell(CellState.ALIVE);

        assertThat(cell.nextState(3)).isEqualTo(CellState.ALIVE);
    }

    @Test
    void liveCellWithTwoLiveNeighborsLives() {
        Cell cell = new Cell(CellState.ALIVE);

        assertThat(cell.nextState(2)).isEqualTo(CellState.ALIVE);
    }

    private class Cell {

        private final CellState cellState;

        public Cell(CellState cellState) {
            this.cellState = cellState;
        }

        public CellState nextState(int liveNeighbors) {
            if (cellState.equals(CellState.ALIVE)) {
                return nextStateOfAliveCell(liveNeighbors);
            }
            if (liveNeighbors == 3 ) {
                return CellState.ALIVE;
            }
            return CellState.DEAD;
        }

        private CellState nextStateOfAliveCell(int liveNeighbors) {
            if (liveNeighbors == 3 || liveNeighbors == 2) {
                return CellState.ALIVE;
            }
            return CellState.DEAD;
        }
    }
}
