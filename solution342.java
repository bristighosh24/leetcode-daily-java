public class solution342 {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) return false;
        // Check if it's a power of two (only one bit set)
        if ((n & (n - 1)) != 0) return false;
        // Check if the only set bit is in the odd position (1, 4, 16, etc.)
        return (n & 0x55555555) != 0;
    }

    public static void main(String[] args) {
        solution342 sol = new solution342();
        System.out.println(sol.isPowerOfFour(16)); // true
        System.out.println(sol.isPowerOfFour(5));  // false
        System.out.println(sol.isPowerOfFour(1));  // true
    }
}
