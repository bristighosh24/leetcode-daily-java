import java.util.ArrayList;
import java.util.List;

// Author: bristighosh24
// Date: 2025-08-01
// LeetCode Daily Challenge: Pascal's Triangle
// Time Complexity: O(numRows^2)
// Space Complexity: O(numRows^2)

class Solution {
    public List<List<Integer>> generate(int numRows) {
        // List to hold the final triangle
        List<List<Integer>> triangle = new ArrayList<>();

        // Loop through each row
        for (int row = 0; row < numRows; row++) {
            List<Integer> currentRow = new ArrayList<>();

            // Construct each element in the row
            for (int col = 0; col <= row; col++) {
                // First and last elements in the row are always 1
                if (col == 0 || col == row) {
                    currentRow.add(1);
                } else {
                    // Sum of the two elements directly above
                    int left = triangle.get(row - 1).get(col - 1);
                    int right = triangle.get(row - 1).get(col);
                    currentRow.add(left + right);
                }
            }

            // Add the constructed row to the triangle
            triangle.add(currentRow);
        }

        return triangle;
    }
}
