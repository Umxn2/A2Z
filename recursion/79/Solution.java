class Solution {

    public static void main(String[] args) {
        char[][] board = {
            { 'A', 'B', 'C', 'E' },
            { 'S', 'F', 'C', 'S' },
            { 'A', 'D', 'E', 'E' },
        };
        String word = "ABCCED";
        Solution solution = new Solution();
        System.out.println(solution.exist(board, word));
    }

    public boolean exist(char[][] board, String word) {
        int maxRow = board.length;
        int maxCol = board[0].length;
        boolean[][] visited = new boolean[maxRow][maxCol];
        int[] rowDir = { 0, -1, 0, 1 };
        int[] colDir = { -1, 0, 1, 0 };
        int index = 0;

        for (int r = 0; r < maxRow; r++) {
            for (int c = 0; c < maxCol; c++) {
                if (
                    validateFunc(
                        r,
                        c,
                        maxRow,
                        maxCol,
                        visited,
                        index,
                        word,
                        board
                    )
                ) {
                    visited[r][c] = true;
                    if (
                        checkIfWordExists(
                            visited,
                            r,
                            c,
                            rowDir,
                            colDir,
                            word,
                            board,
                            maxRow,
                            maxCol,
                            index + 1
                        )
                    ) return true;
                    visited[r][c] = false;
                }
            }
        }
        return false;
    }

    boolean checkIfWordExists(
        boolean[][] visited,
        int row,
        int col,
        int[] rowDir,
        int[] colDir,
        String word,
        char[][] board,
        int maxRow,
        int maxCol,
        int index
    ) {
        if (index == word.length()) return true;
        for (int i = 0; i < 4; i++) {
            int newRow = row + rowDir[i];
            int newCol = col + colDir[i];
            if (
                validateFunc(
                    newRow,
                    newCol,
                    maxRow,
                    maxCol,
                    visited,
                    index,
                    word,
                    board
                )
            ) {
                visited[newRow][newCol] = true;
                if (
                    checkIfWordExists(
                        visited,
                        newRow,
                        newCol,
                        rowDir,
                        colDir,
                        word,
                        board,
                        maxRow,
                        maxCol,
                        index + 1
                    )
                ) return true;
                visited[newRow][newCol] = false;
            }
        }
        return false;
    }

    boolean validateFunc(
        int row,
        int col,
        int maxRow,
        int maxCol,
        boolean[][] visited,
        int index,
        String word,
        char[][] board
    ) {
        if (
            row < 0 ||
            row >= maxRow ||
            col < 0 ||
            col >= maxCol ||
            visited[row][col] ||
            board[row][col] != word.charAt(index)
        ) return false;
        return true;
    }
}
