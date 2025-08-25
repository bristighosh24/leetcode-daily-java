import java.util.Arrays;

public class solution498 {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m * n];
        int r = 0, c = 0, idx = 0;
        boolean up = true; // direction flag

        while (idx < m * n) {
            result[idx++] = mat[r][c];

            if (up) {
                if (c == n - 1) { // hit right wall
                    r++;
                    up = false;
                } else if (r == 0) { // hit top wall
                    c++;
                    up = false;
                } else { // move up-right
                    r--;
                    c++;
                }
            } else {
                if (r == m - 1) { // hit bottom wall
                    c++;
                    up = true;
                } else if (c == 0) { // hit left wall
                    r++;
                    up = true;
                } else { // move down-left
                    r++;
                    c--;
                }
            }
        }
        return result;
    }

    // Main method for local testing
    public static void main(String[] args) {
        solution498 sol = new solution498();
        int[][] mat1 = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] mat2 = {{1,2},{3,4}};

        System.out.println("Output 1: " + Arrays.toString(sol.findDiagonalOrder(mat1)));
        System.out.println("Output 2: " + Arrays.toString(sol.findDiagonalOrder(mat2)));
    }
}
