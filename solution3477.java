public class solution3477 {

    // Your method to solve the problem
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        boolean[] used = new boolean[n];
        int unplaced = 0;

        for (int i = 0; i < n; i++) {
            boolean placed = false;
            for (int j = 0; j < n; j++) {
                if (!used[j] && baskets[j] >= fruits[i]) {
                    used[j] = true;
                    placed = true;
                    break;
                }
            }
            if (!placed) {
                unplaced++;
            }
        }

        return unplaced;
    }

    // Main method to test the function
    public static void main(String[] args) {
        solution3477 sol = new solution3477();

        int[] fruits1 = {4, 2, 5};
        int[] baskets1 = {3, 5, 4};
        System.out.println("Test 1 Output: " + sol.numOfUnplacedFruits(fruits1, baskets1)); // Output: 1

        int[] fruits2 = {3, 6, 1};
        int[] baskets2 = {6, 4, 7};
        System.out.println("Test 2 Output: " + sol.numOfUnplacedFruits(fruits2, baskets2)); // Output: 0
    }
}

