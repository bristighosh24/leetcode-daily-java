public class solution2348 {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0, consecutiveZeros = 0;

        for (int num : nums) {
            if (num == 0) {
                consecutiveZeros++;
                count += consecutiveZeros;  // Add all subarrays ending with this zero
            } else {
                consecutiveZeros = 0;  // Reset when a non-zero is found
            }
        }
        return count;
    }

    public static void main(String[] args) {
        solution2348 sol = new solution2348();
        int[] nums = {1, 3, 0, 0, 2, 0, 0, 4};
        System.out.println(sol.zeroFilledSubarray(nums));  // Expected output: 6
    }
}
