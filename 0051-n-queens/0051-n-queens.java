class Solution {

    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];

        // Fill every cell with '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        helper(board, 0);

        return ans;
    }
    public void helper(char[][] board, int row) {

    // Base Case
    if ( row == board.length) {

        saveBoard(board);

        return;
    }

    for (int j = 0; j < board.length; j++) {

        if ( isSafe(board, row, j) ) {

             board[row][j] = 'Q';;

            helper(board, row + 1);

            board[row][j] = '.';

        }

    }

}
public boolean isSafe(char[][] board, int row, int col) {

    // Check upper column
    for (int i = row - 1; i >= 0; i--) {
        if (board[i][col] == 'Q') {
            return false;
        }
    }

    // Check upper-left diagonal
    for (int i = row - 1, j = col - 1;
         i >= 0 && j >= 0;
         i--, j--) {

        if (board[i][j] == 'Q') {
            return false;
        }
    }

    // Check upper-right diagonal
    for (int i = row - 1, j = col + 1;
         i >= 0 && j < board.length;
         i--, j++) {

        if (board[i][j] == 'Q') {
            return false;
        }
    }

    return true;
}
  public void saveBoard(char[][] board) {

    List<String> list = new ArrayList<>();

    for (int i = 0; i < board.length; i++) {

        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < board.length; j++) {

            sb.append(board[i][j]);      // Blank 1

        }

        list.add(sb.toString());         // Blank 2

    }

    ans.add(list);                      // Blank 3

}

}