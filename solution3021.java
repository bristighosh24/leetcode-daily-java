public class solution3021 {

    public long flowerGame(int n, int m) {
        // Alice wins if x + y is odd, occurring when:
        // 1. x is even and y is odd, or
        // 2. y is even and x is odd.
        final int xEven = n / 2;
        final int yEven = m / 2;
        final int xOdd = (n + 1) / 2;
        final int yOdd = (m + 1) / 2;

        return (long) xEven * yOdd + (long) yEven * xOdd;
    }

    // Main method for testing
    public static void main(String[] args) {
        solution3021 sol = new solution3021();
        System.out.println(sol.flowerGame(3, 4)); // Example test
        System.out.println(sol.flowerGame(2, 2)); // Another test
    }
}

