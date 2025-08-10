import java.util.Arrays;

public class solution869 {
    public boolean reorderedPowerOf2(int n) {
        char[] target = String.valueOf(n).toCharArray();
        Arrays.sort(target);
        
        for (int i = 0; i < 31; i++) { // Check powers of 2 up to 2^30
            int power = 1 << i;
            char[] digits = String.valueOf(power).toCharArray();
            Arrays.sort(digits);
            if (Arrays.equals(target, digits)) {
                return true;
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        solution869 obj = new solution869();
        System.out.println(obj.reorderedPowerOf2(1));   // true
        System.out.println(obj.reorderedPowerOf2(10));  // false
        System.out.println(obj.reorderedPowerOf2(46));  // true
    }
}
