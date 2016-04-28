public class RemoveElement {

    /**
     * https://leetcode.com/articles/remove-element/
     *
     * Given an array and a value, remove all instances of that value in place and return the new length.
     * Do not allocate extra space for another array, you must do this in place with constant memory.
     * The order of elements can be changed. It doesn't matter what you leave beyond the new length.

     * Example:
     * Given input array nums = [3,2,2,3], val = 3
     * Your function should return length = 2, with the first two elements of nums being 2.
     *
     * 1. Try two pointers.
     * 2. Did you use the property of "the order of elements can be changed"?
     * 3. What happens when the elements to remove are rare?
     *
     */
    public static void main(String[] args) {
        //System.out.println("Hello World!");

//        int list[] = {3,2,2,3};
//        int len = removeElement(list,3);

        int list[] = {4,1,2,3,5};
        int len = removeElement2(list, 4);
        System.out.println(len);
    }
    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static int removeElement2(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }
}
