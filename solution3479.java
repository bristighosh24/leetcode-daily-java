import java.util.HashMap;
import java.util.Map;

public class solution3479 {
    public int totalFruits(int[] fruits) {
        Map<Integer, Integer> basket = new HashMap<>();
        int left = 0, maxFruits = 0;

        for (int right = 0; right < fruits.length; right++) {
            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);

            while (basket.size() > 2) {
                basket.put(fruits[left], basket.get(fruits[left]) - 1);
                if (basket.get(fruits[left]) == 0) {
                    basket.remove(fruits[left]);
                }
                left++;
            }

            maxFruits = Math.max(maxFruits, right - left + 1);
        }

        return maxFruits;
    }

    public static void main(String[] args) {
        solution3479 obj = new solution3479();
        int[] fruits = {1, 2, 1, 2, 3};
        int result = obj.totalFruits(fruits);
        System.out.println("Maximum number of fruits: " + result);
    }
}

