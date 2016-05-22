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
 * <p/>
 * 題目翻譯: 給定兩個整型數組n和k，要求返由k個數組成的combination，其實應該叫做組合. 這個
 * combination應該是高中里面的組合。這k個數是在n中任選k個數，由題意可得，這裡的k應該小於或等於
 * n(這個條件不要忘了做validation check哦).
 * 題目分析: 我覺得應該還有不少讀者困惑什麼是combination，這裡我們先給一個例子比如n=3， k=2的條件
 * 下， 所有可能的combination如下： [1,2], [1,3], [2,3]. 注意：[2,3]和[3,2]是相同的，我們只要求有其中一個
 * 就可以了. 所以解題的時候，我們要避免相同的組合出現.
 *
 * 解題思路: 看到這道題，首先第一想法應該是用遞歸來求解.如果要是用循環來求解，這個時間複雜度應該
 * 是比較恐怖了.並且，這個遞歸是一層一層往深處去走的，打個比方，我們一個循環，首先求得以1開始的
 *
 * 看個數的combination，之後再求以2開始的，以此類推，所以開始是對n個數做DFS, n-1個數做DFS...所以
 * 應該是對n(n-1)...*1做DFS. 在程序中，我們可以加一些剪枝條件來減少程序時間.
 *
 * 時間複雜度: 在題目分析中，我們提到了對於對n,n-1,...,1做DFS，所以時間複雜度是O(n!)
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
