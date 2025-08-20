public class solution1277 {
    public int countSquares(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int totalSquares = 0;

        // DP table to store the maximum square size ending at (i, j)
        int[][] dp = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1; // Only 1x1 possible at edges
                    } else {
                        dp[i][j] = 1 + Math.min(dp[i - 1][j],
                                        Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                    }
                    totalSquares += dp[i][j];
                }
            }
        }

        return totalSquares;
    }

    // Optional: Main method for local testing
    public static void main(String[] args) {
        solution1277 sol = new solution1277();
        int[][] matrix1 = {
            {0, 1, 1, 1},
            {1, 1, 1, 1},
            {0, 1, 1, 1}
        };
        System.out.println(sol.countSquares(matrix1)); // Output: 15

        int[][] matrix2 = {
            {1, 0, 1},
            {1, 1, 0},
            {1, 1, 0}
        };
        System.out.println(sol.countSquares(matrix2)); // Output: 7
    }
}
