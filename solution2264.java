public class solution2264 {
    public String largestGoodInteger(String num) {
        String largest = "";
        for (int i = 0; i < num.length() - 2; i++) {
            char c = num.charAt(i);
            if (c == num.charAt(i + 1) && c == num.charAt(i + 2)) {
                String good = num.substring(i, i + 3);
                if (largest.equals("") || good.compareTo(largest) > 0) {
                    largest = good;
                }
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        solution2264 sol = new solution2264();
        System.out.println(sol.largestGoodInteger("677713333")); // Output: "777"
        System.out.println(sol.largestGoodInteger("2300019"));   // Output: "000"
        System.out.println(sol.largestGoodInteger("42352338"));  // Output: ""
    }
}

