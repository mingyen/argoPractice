import java.util.ArrayList;

/**
 * Given a collection of distinct numbers, return all possible permutations.
 * <p/>
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * <p/>
 *
 * Permutation這個分支是在backtracking下的一個子分支，其
 * 具體的解題方法和Combination幾乎是同出一轍，一個思路，
 * 對於給定數組用DFS方法一層一層遍歷，在這個section當
 * 中，我們將對於leetcode上出現的permutation問題進行逐個
 * 分析與解答.
 *
 * 題目翻譯: 給定一個整形數組，要求求出這個數組的所有變形體，具體例子看上文中給出的例子就可以.
 *
 * 題目分析: 這道題很直接，幾乎算是沒有坑，相信大家都可以理解題目的要求. Permutation的解題方法和
 * Combination幾乎是相同的，唯一需要注意的是，Permutation需要加一個bool類型的數組來進行記錄哪個
 * 元素訪問了，哪個沒有，這樣才不會導致重複出現，並且不同於Combination的一點是，Permutation不需
 * 要排序.
 *
 * 解題思路: 遇到這種問題，很顯然，第一個想法我們首先回去想到DFS,遞歸求解，對於數組中的每一個元
 * 素，找到以他為首節點的Permutations,這就要求在遞歸中，每次都要從數組的第一個元素開始遍歷，這
 * 樣，，就引入了另外一個問題，我們會對於同一元素訪問多次，這就不是我們想要的答案了，所以我們引
 * 入了一個bool類型的數組，用來記錄哪個元素被遍歷了(通過下標找出對應).在對於每一個Permutation進行
 * 求解中，如果訪問了這個元素,我們將它對應下表的bool數組中的值置為true,訪問結束後，我們再置為false.
 *
 * 時間複雜度分析: 這道題同Combination,所以對於這道題的解答，時間複雜度同樣是O(n!)
 */
public class Permutations {
    public static void main(String[] args) {
        String list[] = {"a", "b", "c"};

        Permutations test = new Permutations();
        System.out.println(test.permute(list));
    }

    public ArrayList<ArrayList<String>> permute(String[] elements) {

        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        if (elements == null || elements.length == 0) {
            return result;
        }

        ArrayList<String> item = new ArrayList<String>();
        helper(result, item, elements);
        return result;
    }

    public void helper(ArrayList<ArrayList<String>> result, ArrayList<String> item, String[] elements) {

        if (item.size() == elements.length) {
            result.add(new ArrayList<String>(item));
            return;
        }

        for (int i = 0; i < elements.length; i++) {
            if (item.contains(elements[i])) {
                continue;
            }
            item.add(elements[i]);
            helper(result, item, elements);
            item.remove(item.size() - 1);
        }

    }
}

