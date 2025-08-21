public class solution1504 {
    public int numSubmat(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int result = 0;

        // Step 1: Precompute heights (like histogram for each column)
        int[][] height = new int[rows][cols];
        for (int j = 0; j < cols; j++) {
            height[0][j] = mat[0][j];
            for (int i = 1; i < rows; i++) {
                if (mat[i][j] == 1) {
                    height[i][j] = height[i - 1][j] + 1;
                } else {
                    height[i][j] = 0;
                }
            }
        }

        // Step 2: For each row, count submatrices ending at this row
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int minHeight = height[i][j];
                for (int k = j; k >= 0 && minHeight > 0; k--) {
                    minHeight = Math.min(minHeight, height[i][k]);
                    result += minHeight;
                }
            }
        }

        return result;
    }

    // Local testing
    public static void main(String[] args) {
        solution1504 sol = new solution1504();
        int[][] mat1 = {
            {1, 0, 1},
            {1, 1, 0},
            {1, 1, 0}
        };
        System.out.println(sol.numSubmat(mat1)); // Output: 13

        int[][] mat2 = {
            {0, 1, 1, 0},
            {0, 1, 1, 1},
            {1, 1, 1, 0}
        };
        System.out.println(sol.numSubmat(mat2)); // Output: 24
    }
}
