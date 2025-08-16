public class solution1323 {
    public int maximum69Number (int num) {
        // Convert number to character array
        char[] digits = String.valueOf(num).toCharArray();
        
        // Change the first '6' to '9'
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == '6') {
                digits[i] = '9';
                break; // only change the first occurrence
            }
        }
        
        // Convert back to integer
        return Integer.parseInt(new String(digits));
    }

    // Example test
    public static void main(String[] args) {
        solution1323 sol = new solution1323();
        int num = 9669;
        System.out.println(sol.maximum69Number(num)); // Output: 9969
    }
}

