public class solution3000 {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double maxDiagonal = 0;
        int maxArea = 0;

        for (int[] rect : dimensions) {
            int length = rect[0];
            int width = rect[1];
            double diagonal = Math.sqrt(length * length + width * width);
            int area = length * width;

            if (diagonal > maxDiagonal) {
                maxDiagonal = diagonal;
                maxArea = area;
            } else if (diagonal == maxDiagonal) {
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }

    // Main method for local testing
    public static void main(String[] args) {
        solution3000 sol = new solution3000();
        
        int[][] dimensions1 = {{9, 3}, {8, 6}};
        System.out.println(sol.areaOfMaxDiagonal(dimensions1)); // Output: 48

        int[][] dimensions2 = {{3, 4}, {4, 3}};
        System.out.println(sol.areaOfMaxDiagonal(dimensions2)); // Output: 12
    }
}
