public class solution3197 {

  public int minimumSum(int[][] grid) {
    final int m = grid.length;
    final int n = grid[0].length;
    int ans = m * n;

    // Case 1: bottom + two parts of top
    for (int i = 0; i < m; ++i) {
      final int top = minimumArea(grid, 0, i, 0, n - 1);
      for (int j = 0; j < n; ++j)
        ans = Math.min(ans, top + /*left*/ minimumArea(grid, i + 1, m - 1, 0, j) +
                                /*right*/ minimumArea(grid, i + 1, m - 1, j + 1, n - 1));
    }

    // Case 2: top + two parts of bottom
    for (int i = 0; i < m; ++i) {
      final int bottom = minimumArea(grid, i, m - 1, 0, n - 1);
      for (int j = 0; j < n; ++j)
        ans = Math.min(ans, bottom + /*left*/ minimumArea(grid, 0, i - 1, 0, j) +
                                /*right*/ minimumArea(grid, 0, i - 1, j + 1, n - 1));
    }

    // Case 3: right + two parts of left
    for (int j = 0; j < n; ++j) {
      final int left = minimumArea(grid, 0, m - 1, 0, j);
      for (int i = 0; i < m; ++i)
        ans = Math.min(ans, left + /*top*/ minimumArea(grid, 0, i, j + 1, n - 1) +
                                /*bottom*/ minimumArea(grid, i + 1, m - 1, j + 1, n - 1));
    }

    // Case 4: left + two parts of right
    for (int j = 0; j < n; ++j) {
      final int right = minimumArea(grid, 0, m - 1, j, n - 1);
      for (int i = 0; i < m; ++i)
        ans = Math.min(ans, right + /*top*/ minimumArea(grid, 0, i, 0, j - 1) +
                                /*bottom*/ minimumArea(grid, i + 1, m - 1, 0, j - 1));
    }

    // Case 5: horizontal stripes
    for (int i1 = 0; i1 < m; ++i1)
      for (int i2 = i1 + 1; i2 < m; ++i2)
        ans = Math.min(ans, /*top*/ minimumArea(grid, 0, i1, 0, n - 1) +
                                /*middle*/ minimumArea(grid, i1 + 1, i2, 0, n - 1) +
                                /*bottom*/ minimumArea(grid, i2 + 1, m - 1, 0, n - 1));

    // Case 6: vertical stripes
    for (int j1 = 0; j1 < n; ++j1)
      for (int j2 = j1 + 1; j2 < n; ++j2)
        ans = Math.min(ans, /*left*/ minimumArea(grid, 0, m - 1, 0, j1) +
                                /*middle*/ minimumArea(grid, 0, m - 1, j1 + 1, j2) +
                                /*right*/ minimumArea(grid, 0, m - 1, j2 + 1, n - 1));

    return ans;
  }

  private int minimumArea(int[][] grid, int si, int ei, int sj, int ej) {
    int x1 = Integer.MAX_VALUE;
    int y1 = Integer.MAX_VALUE;
    int x2 = 0;
    int y2 = 0;
    for (int i = si; i <= ei; ++i)
      for (int j = sj; j <= ej; ++j)
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
          x1 = Math.min(x1, i);
          y1 = Math.min(y1, j);
          x2 = Math.max(x2, i);
          y2 = Math.max(y2, j);
        }
    return x1 == Integer.MAX_VALUE ? 0 : (x2 - x1 + 1) * (y2 - y1 + 1);
  }

  // Main method for quick testing
  public static void main(String[] args) {
    solution3197 sol = new solution3197();
    int[][] grid = {
      {1, 0, 0, 1},
      {0, 1, 1, 0},
      {1, 0, 0, 1}
    };
    System.out.println(sol.minimumSum(grid)); // Example run
  }
}

