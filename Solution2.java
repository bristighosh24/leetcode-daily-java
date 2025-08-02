import java.util.*;

class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        List<Integer> toSwap = new ArrayList<>();

        // Count the frequency differences
        for (int fruit : basket1) {
            frequencyMap.put(fruit, frequencyMap.getOrDefault(fruit, 0) + 1);
        }
        for (int fruit : basket2) {
            frequencyMap.put(fruit, frequencyMap.getOrDefault(fruit, 0) - 1);
        }

        // Prepare the list of fruits to be swapped
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int fruitType = entry.getKey();
            int diff = entry.getValue();

            if (diff % 2 != 0) return -1;

            int swapCount = Math.abs(diff) / 2;
            for (int i = 0; i < swapCount; i++) {
                toSwap.add(fruitType);
            }
        }

        // Find the minimum value in both baskets
        int minFruit = Integer.MAX_VALUE;
        for (int fruit : basket1) minFruit = Math.min(minFruit, fruit);
        for (int fruit : basket2) minFruit = Math.min(minFruit, fruit);

        Collections.sort(toSwap);
        long totalCost = 0;

        // Swap using cheaper option: either directly or via two of the smallest fruit
        int swapOperations = toSwap.size() / 2;
        for (int i = 0; i < swapOperations; i++) {
            totalCost += Math.min(toSwap.get(i), 2 * minFruit);
        }

        return totalCost;
    }

    // Optional: for testing the method
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] basket1 = {4, 2, 2, 2};
        int[] basket2 = {1, 4, 1, 2};
        System.out.println(sol.minCost(basket1, basket2)); // Example test
    }
}
