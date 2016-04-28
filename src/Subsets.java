import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets.
 * <p/>
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If nums = [1,2,3], a solution is:
 * <p/>
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class Subsets {
    public static void main(String[] args) {

        int nums[] = {1, 9, 3, 4};

        Subsets test = new Subsets();
        System.out.println("----------------");
        System.out.println(test.subsets(nums));

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if(nums.length == 0){
            return result;
        }

        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }

    public void helper(int[] nums, int index, List<Integer> path, List<List<Integer>> result){
        result.add(new ArrayList<Integer>(path));
        System.out.println("result :" + result);

        for(int i = index; i < nums.length; i++){
            System.out.println("path :" + result);
            path.add(nums[i]);
            helper(nums, i + 1, path, result);
            path.remove(path.size()-1);
        }
    }
}
