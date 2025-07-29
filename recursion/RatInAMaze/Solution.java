package RatInAMaze;

import java.util.ArrayList;

class Solution {

    public static void main(String[] args) {
        int mat[][] = { { 1, 0 }, { 1, 0 } };
        Solution solution = new Solution();
        ArrayList<String> output = solution.ratInMaze(mat);
        for (String s : output) {
            System.out.println(s);
        }
    }

    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> output = new ArrayList<>();
        String currString = "";
        int maxRow = maze.length;
        int maxCol = maze[0].length;
        boolean[][] visited = new boolean[maxRow][maxCol];
        int[] rowDir = { 1, 0, 0, -1 };
        int[] colDir = { 0, -1, 1, 0 };
        char[] direction = { 'D', 'L', 'R', 'U' };
        visited[0][0] = true;
        getAllPaths(
            output,
            currString,
            0,
            0,
            maxRow,
            maxCol,
            visited,
            rowDir,
            colDir,
            direction,
            maze
        );
        return output;
    }

    void getAllPaths(
        ArrayList<String> output,
        String currString,
        int row,
        int col,
        int maxRow,
        int maxCol,
        boolean[][] visited,
        int[] rowDir,
        int[] colDir,
        char[] direction,
        int[][] maze
    ) {
        if (row == maxRow - 1 && col == maxCol - 1) {
            output.add(new String(currString));
            return;
        }

        for (int i = 0; i < 4; i++) {
            int newRow = row + rowDir[i];
            int newCol = col + colDir[i];
            if (isValid(newRow, newCol, maxRow, maxCol, visited, maze)) {
                visited[newRow][newCol] = true;
                getAllPaths(
                    output,
                    currString + direction[i],
                    newRow,
                    newCol,
                    maxRow,
                    maxCol,
                    visited,
                    rowDir,
                    colDir,
                    direction,
                    maze
                );
                visited[newRow][newCol] = false;
            }
        }
    }

    boolean isValid(
        int row,
        int col,
        int maxRow,
        int maxCol,
        boolean[][] visited,
        int[][] maze
    ) {
        if (
            row < 0 ||
            row >= maxRow ||
            col < 0 ||
            col >= maxCol ||
            visited[row][col] ||
            maze[row][col] == 0
        ) return false;
        return true;
    }
}
