import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int nums[] = {9,9};
        int res[] = nums;
        for (int i = 0; i < 3; i++) {
            res = plusOne(res);
            System.out.println(Arrays.toString(res));
        }

    }

    public static int[] plusOne(int[] digits) {
//        if (digits == null || digits.length == 0) {
//            return digits;
//        }

        int carry = 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            int digit = (digits[i] + carry) % 10;
            carry = (digits[i] + carry) / 10;
            digits[i] = digit;
            if (carry == 0) {
                return digits;
            }
        }

        // 為了增加一個位數,例如 9 -> 10
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
}
