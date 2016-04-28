import java.util.ArrayList;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * <p/>
 * For example,
 * If n = 4 and k = 2, a solution is:
 * <p/>
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class Combinations {
    public static void main(String[] args) {
        Combinations test = new Combinations();
        System.out.println("----------------");
        System.out.println(test.combine(4, 2));

    }

    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (n <= 0 || n < k) {
            return res;
        }

        System.out.println(Integer.toHexString(System.identityHashCode(res)));

        helper(n, k, 1, new ArrayList<Integer>(), res);

        return res;
    }

    private void helper(int n, int k, int start, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> res) {

        System.out.println(Integer.toHexString(System.identityHashCode(res)));
        System.out.println("level" + start + ",item" + item.toString());
        if (item.size() == k) { // termination condition
            res.add(new ArrayList<Integer>(item));
            return;
        }

        // i control the outter loop, and start control the inner loop for recursive function.
        // [
        // [1, 2], [1, 3], [1, 4]
        // [2, 3], [2, 4]
        // [3, 4]      ^       ^
        //  ^  ^       |       |
        //  |  |       |       |
        //  |  start  start  start
        //  |
        //  i
        //
        // ]


        for (int i = start; i <= n; i++) {
            item.add(i); // the most important part
            helper(n, k, i + 1, item, res);
            item.remove(item.size() - 1);
        }
    }


}
