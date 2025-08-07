
public class solution3363 {
    
    public int maxOperations(int[] nums) {
        if (nums.length < 2) return 0;

        int maxOps = 0;

        // Try all possible initial sums (nums[0] + nums[1], nums[0] + nums[2], ..., etc.)
        for (int i = 1; i < nums.length; i++) {
            int target = nums[0] + nums[i];
            boolean[] used = new boolean[nums.length];
            used[0] = true;
            used[i] = true;

            int count = 1;
            count += dfs(nums, used, target);
            maxOps = Math.max(maxOps, count);
        }

        return maxOps;
    }

    private int dfs(int[] nums, boolean[] used, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (used[j]) continue;
                if (nums[i] + nums[j] == target) {
                    used[i] = true;
                    used[j] = true;
                    int result = 1 + dfs(nums, used, target);
                    used[i] = false;
                    used[j] = false;
                    return result;
                }
            }
        }
        return 0;
    }

    // Optional: main() to test locally
    public static void main(String[] args) {
        solution3363 sol = new solution3363();
        int[] nums = {3, 2, 1, 4, 5};
        System.out.println("Max operations: " + sol.maxOperations(nums)); // Expected: 2
    }
}
