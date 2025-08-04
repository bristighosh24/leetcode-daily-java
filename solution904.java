import java.util.HashMap;
import java.util.Map;

public class solution904 {
    public static void main(String[] args) {
        int[] fruits = {1, 2, 1, 2, 3};  // Example input
        System.out.println("Max Fruits: " + totalFruit(fruits));
    }

    public static int totalFruit(int[] fruits) {
        int maxFruits = 0;
        Map<Integer, Integer> basket = new HashMap<>();
        int left = 0;

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
}
