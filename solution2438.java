public class solution2438 {

    public int[] productQueries(int n, int[][] queries) {
        final int MOD = 1_000_000_007;

        // Step 1: extract powers of 2 that sum up to n
        java.util.List<Integer> powers = new java.util.ArrayList<>();
        for (int i = 0; n > 0; i++) {
            if ((n & (1 << i)) != 0) {
                powers.add(1 << i);
                n -= (1 << i);
            }
        }

        // Step 2: prefix product array
        long[] prefix = new long[powers.size() + 1];
        prefix[0] = 1;
        for (int i = 0; i < powers.size(); i++) {
            prefix[i + 1] = (prefix[i] * powers.get(i)) % MOD;
        }

        // Step 3: answer queries
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            long numerator = prefix[right + 1];
            long denominator = modInverse(prefix[left], MOD);
            ans[i] = (int) ((numerator * denominator) % MOD);
        }

        return ans;
    }

    private long modInverse(long a, int mod) {
        return powMod(a, mod - 2, mod);
    }

    private long powMod(long base, long exp, int mod) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) result = (result * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        solution2438 sol = new solution2438();

        int n = 15;
        int[][] queries = { {0, 1}, {2, 2}, {0, 3} };

        int[] result = sol.productQueries(n, queries);

        System.out.print("Output: ");
        for (int r : result) {
            System.out.print(r + " ");
        }
    }
}

