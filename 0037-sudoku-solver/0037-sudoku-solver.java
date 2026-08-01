class Solution {

    public void solveSudoku(char[][] board) {
        sudokuSolver(board, 0, 0);
    }

    public boolean isSafe(char[][] board, int row, int col, int digit) {

        // Check column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == (char) (digit + '0')) {
                return false;
            }
        }

        // Check row
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == (char) (digit + '0')) {
                return false;
            }
        }

        // Check 3x3 grid
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;

        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (board[i][j] == (char) (digit + '0')) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean sudokuSolver(char[][] board, int row, int col) {

        // Base Case
        if (row == 9) {
            return true;
        }

        int nextRow = row;
        int nextCol = col + 1;

        if (col + 1 == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }

        // Skip already filled cells
        if (board[row][col] != '.') {
            return sudokuSolver(board, nextRow, nextCol);
        }

        // Try digits 1 to 9
        for (int digit = 1; digit <= 9; digit++) {

            if (isSafe(board, row, col, digit)) {

                board[row][col] = (char) (digit + '0');

                if (sudokuSolver(board, nextRow, nextCol)) {
                    return true;
                }

                // Backtracking
                board[row][col] = '.';
            }
        }

        return false;
    }
}