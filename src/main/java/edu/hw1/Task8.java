package edu.hw1;

public class Task8 {
    public static final int X = 0;
    public static final int Y = 1;
    public static final int[][] KNIGHT_MOVES = {
        {2, 1}, {2, -1},
        {-1, 2}, {1, 2},
        {-2, 1}, {-2, -1},
        {-1, -2}, {1, -2}
    };

    private Task8() {
    }

    public static boolean knightBoardCapture(int[][] board) {
        int boardLength = board.length;
        for (int i = 0; i < boardLength; i++) {
            for (int j = 0; j < boardLength; j++) {
                if (board[i][j] == 1) {
                    for (int[] coordinates : KNIGHT_MOVES) {
                        int x = i - coordinates[X];
                        int y = j - coordinates[Y];
                        if ((x >= 0) && (y >= 0) && (x < boardLength) && (y < boardLength) && (board[x][y] == 1)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
