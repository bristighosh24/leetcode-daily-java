import java.util.*;

public class solution679 {
    private static final double EPSILON = 1e-6;

    public boolean judgePoint24(int[] cards) {
        List<Double> nums = new ArrayList<>();
        for (int card : cards) {
            nums.add((double) card);
        }
        return backtrack(nums);
    }

    private boolean backtrack(List<Double> nums) {
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - 24.0) < EPSILON;
        }

        // Pick two numbers
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                if (i == j) continue;

                List<Double> next = new ArrayList<>();
                for (int k = 0; k < nums.size(); k++) {
                    if (k != i && k != j) next.add(nums.get(k));
                }

                // Try all 4 operations
                for (double val : compute(nums.get(i), nums.get(j))) {
                    next.add(val);
                    if (backtrack(next)) return true;
                    next.remove(next.size() - 1);
                }
            }
        }
        return false;
    }

    // Generate all possible results for a pair (a, b)
    private List<Double> compute(double a, double b) {
        List<Double> results = new ArrayList<>();
        results.add(a + b);
        results.add(a - b);
        results.add(b - a);
        results.add(a * b);
        if (Math.abs(b) > EPSILON) results.add(a / b);
        if (Math.abs(a) > EPSILON) results.add(b / a);
        return results;
    }

    // Just for testing
    public static void main(String[] args) {
        solution679 solver = new solution679();

        int[] cards1 = {4, 1, 8, 7};
        System.out.println(solver.judgePoint24(cards1)); // true

        int[] cards2 = {1, 2, 1, 2};
        System.out.println(solver.judgePoint24(cards2)); // false
    }
}
