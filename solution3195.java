public class solution3195 {
    public int minimumArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int minRow = m, maxRow = -1, minCol = n, maxCol = -1;

        // Traverse the grid to locate boundaries of 1s
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i);
                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }

        // Compute area of rectangle enclosing all 1s
        return (maxRow - minRow + 1) * (maxCol - minCol + 1);
    }

    // MAIN METHOD for local testing
    public static void main(String[] args) {
        solution3195 sol = new solution3195();

        int[][] grid1 = {
            {0, 1, 0},
            {1, 0, 1}
        };
        System.out.println(sol.minimumArea(grid1)); // Expected output: 6

        int[][] grid2 = {
            {1, 0},
            {0, 0}
        };
        System.out.println(sol.minimumArea(grid2)); // Expected output: 1
    }
}
