
class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int farthest = Math.max(startPos, fruits[fruits.length - 1][0]);
        int[] fruitCount = new int[farthest + 2];
        int[] cumulative = new int[farthest + 3];

        for (int[] pair : fruits) {
            fruitCount[pair[0]] = pair[1];
        }

        for (int i = 0; i < fruitCount.length; i++) {
            cumulative[i + 1] = cumulative[i] + fruitCount[i];
        }

        int maxCollected = 0;

        int maxMoveRight = Math.min(farthest - startPos, k);
        for (int stepsRight = 0; stepsRight <= maxMoveRight; stepsRight++) {
            int stepsLeft = Math.max(0, k - 2 * stepsRight);
            maxCollected = Math.max(maxCollected,
                collectFruits(startPos - stepsLeft, startPos + stepsRight, cumulative));
        }

        int maxMoveLeft = Math.min(startPos, k);
        for (int stepsLeft = 0; stepsLeft <= maxMoveLeft; stepsLeft++) {
            int stepsRight = Math.max(0, k - 2 * stepsLeft);
            maxCollected = Math.max(maxCollected,
                collectFruits(startPos - stepsLeft, startPos + stepsRight, cumulative));
        }

        return maxCollected;
    }

    private int collectFruits(int left, int right, int[] cumulative) {
        left = Math.max(0, left);
        right = Math.min(cumulative.length - 2, right);
        return cumulative[right + 1] - cumulative[left];
    }
}

public class solution_2106 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] fruits = { {2, 4}, {4, 3}, {10, 5} };
        int startPos = 4;
        int k = 6;
        System.out.println(sol.maxTotalFruits(fruits, startPos, k));
    }
}
