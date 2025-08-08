import java.util.HashMap;
import java.util.Map;

public class solution808 {
    public int maxFruits(int[] fruits) {
        int n = fruits.length;
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, maxFruits = 0;

        for (int right = 0; right < n; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }

            maxFruits = Math.max(maxFruits, right - left + 1);
        }

        return maxFruits;
    }

    // Optional: main method for testing
    public static void main(String[] args) {
        solution808 sol = new solution808();
        int[] fruits = {1, 2, 1, 2, 3}; // Sample input
        System.out.println(sol.maxFruits(fruits)); // Output: 4
    }
}
