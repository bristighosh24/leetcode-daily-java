public class solution326 {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    // For quick testing
    public static void main(String[] args) {
        solution326 sol = new solution326();
        System.out.println(sol.isPowerOfThree(27)); // true
        System.out.println(sol.isPowerOfThree(0));  // false
        System.out.println(sol.isPowerOfThree(9));  // true
        System.out.println(sol.isPowerOfThree(45)); // false
    }
}
