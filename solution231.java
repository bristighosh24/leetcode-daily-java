public class solution231 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    // You can test it here
    public static void main(String[] args) {
        solution231 sol = new solution231();
        System.out.println(sol.isPowerOfTwo(1));   // true
        System.out.println(sol.isPowerOfTwo(16));  // true
        System.out.println(sol.isPowerOfTwo(3));   // false
    }
}
