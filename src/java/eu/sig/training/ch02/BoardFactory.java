package eu.sig.training.ch02;

public class BoardFactory {
    // tag::createBoard[]
    public Board createBoard(Square[][] grid) {
        assert grid != null;

        Board board = new BoardCreator(grid).create();

        return board;
    }

    private class BoardCreator {
        private Square[][] grid;
        private int width;
        private int height;
        private final Board board;

        public BoardCreator(Square[]... grid) {
            this.grid = grid;
            board = new Board(grid);
            width = board.getWidth();
            height = board.getHeight();
        }

        public Board create() {
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    linkSquareWithNeighbours(x, y);
                }
            }

            return board;
        }

        private void linkSquareWithNeighbours(int x, int y) {
            Square square = getSquare(x, y);
            for (Direction dir : Direction.values()) {
                linkNeigbhour(x, y, square, dir);
            }
        }

        private void linkNeigbhour(int x, int y, Square sourceSquare, Direction dir) {
            int dirX = createXDirection(x, dir);
            int dirY = createYDirection(y, dir);

            Square neighbour = getSquare(dirX, dirY);
            sourceSquare.link(neighbour, dir);
        }

        private Square getSquare(int x, int y) {
            return grid[x][y];
        }

        private int createYDirection(int y, Direction dir) {
            return (height + y + dir.getDeltaY()) % height;
        }

        private int createXDirection(int x, Direction dir) {
            return (width + x + dir.getDeltaX()) % width;
        }
    }
    // end::createBoard[]
}

class Board {
    @SuppressWarnings("unused")
    public Board(Square[][] grid) {
    }

    public int getWidth() {
        return 0;
    }

    public int getHeight() {
        return 0;
    }
}

class Square {
    @SuppressWarnings("unused")
    public void link(Square neighbour, Direction dir) {
    }
}

class Direction {

    public static Direction[] values() {
        return null;
    }

    public int getDeltaY() {
        return 0;
    }

    public int getDeltaX() {
        return 0;
    }
}
