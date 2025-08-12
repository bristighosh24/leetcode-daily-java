public class solution2787 {

    static final int MOD = 1_000_000_007;
    static Integer[][] dp;

    public static void main(String[] args) {
        int n = 10;
        int x = 2;
        System.out.println(numberOfWays(n, x)); // Example test
    }

    public static int numberOfWays(int n, int x) {
        dp = new Integer[n + 1][n + 1];
        return dfs(1, n, x);
    }

    private static int dfs(int num, int remaining, int power) {
        if (remaining == 0) return 1; // Found one valid way
        if (remaining < 0) return 0;  // Invalid path
        if (num > remaining) return 0;

        if (dp[num][remaining] != null) return dp[num][remaining];

        long pow = (long) Math.pow(num, power);
        int take = 0;
        if (pow <= remaining) {
            take = dfs(num + 1, (int) (remaining - pow), power);
        }

        int skip = dfs(num + 1, remaining, power);

        return dp[num][remaining] = (int) ((take + (long) skip) % MOD);
    }
}
