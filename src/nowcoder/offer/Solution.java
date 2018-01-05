package nowcoder.offer;

import scala.Char;
import scala.Int;
import sun.reflect.generics.tree.Tree;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Zhong on 2017/12/27.
 */
public class Solution {
    public String replaceSpace(StringBuffer str) {
        return str.toString().replaceAll(" ", "%20");
    }

    public int NumberOf1(int n) {
        Integer.bitCount(n);

        System.out.println(Integer.toBinaryString(n));

        int count = 0;
        while (n != 0) {
            ++count;
            n = (n - 1) & n;
        }
        return count;
    }

    public double Power(double base, int exponent) {
        return Math.pow(base, exponent);
    }

    public void reOrderArray(int[] array) {
        int i = 0, j = 0;

        int odd = 0, even = array.length - 1;

        int[] tmp = new int[array.length];

        /*while (i < array.length) {
            if (array[i] % 2 == 0) {
                j = i + 1;
                while (j < array.length) {
                    if (array[j] % 2 == 1) {
                        break;
                    }
                    j++;
                }

                if (j < array.length) {
                    int tmp = array[j];
                    for (int z = j; z > i; z --) {
                        array[z] = array[z - 1];
                    }
                    array[i] = tmp;
                }

                i++;
                if (j == array.length - 1) break;

            } else {
            	i++;
            }
        }*/

        while (i < array.length) {
            if (array[i] % 2 == 1) {
                tmp[odd++] = array[i];
            }

            if (array[array.length - i - 1] % 2 == 0) {
                tmp[even--] = array[array.length - i];
            }
            i++;
        }

        for (int z = 0; z < tmp.length; z++) {
            array[z] = tmp[z];
        }
    }


    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        /*int total = 0;
        ListNode cur = head;
        while (cur != null) {
            total++;
            cur = cur.next;
        }

        int i = total - k;
        if (i < 0) return null;
        cur = head;
        while (i > 0) {
            cur = cur.next;
            i--;
        }
        return cur;*/

        ListNode pre = head, cur = head;

        while (k > 0) {
            if (pre != null) {
                pre = pre.next;
            } else {
                return null;
            }
            k--;
        }

        while (pre != null) {
            pre = pre.next;
            cur = cur.next;
        }
        return cur;
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);

        ListNode cur = head;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }


        if (list1 == null) {
            cur.next = list2;
        } else {
            cur.next = list1;
        }

        return head.next;
    }

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> arr = new ArrayList<>();
        int count = matrix.length * (matrix.length > 0 ? matrix[0].length : 0);
        int i = 0, j = 0, times = 0;
        while (count > 0) {
            int row = times;
            int col = matrix.length - times - 1;
            while (j < matrix[i].length - times) {
//                System.out.println(i + " " + j);
                arr.add(matrix[i][j]);
                count--;
                j++;
            }
            j--;

            i++;
            while (i < matrix.length - times) {
//                System.out.println(i + " " + j);
                arr.add(matrix[i][j]);
                count--;
                i++;
            }
            i--;

            j--;
            while (j >= times && i != times) {
//                System.out.println(i + " " + j);
                arr.add(matrix[i][j]);
                count--;
                j--;
            }
            j++;

            i--;
            while (i >= times + 1 && j != matrix[i].length - times - 1) {
                System.out.println(matrix[i].length - times - 1);
                System.out.println(i + " " + j);
                arr.add(matrix[i][j]);
                count--;
                i--;
            }
            i++;
            j++;
            times++;
//            System.out.println("i " + i + " j " + j + " times " + times + " count " + count);
        }

        return arr;
    }


    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }


    public RandomListNode Clone(RandomListNode pHead) {
        RandomListNode newHead = null, cur1 = pHead, cur2 = null;
        HashMap<RandomListNode, Integer> m1 = new HashMap<>();
        HashMap<Integer, RandomListNode> m2 = new HashMap<>();

        int i = 1;
        while (cur1 != null) {

            m1.put(cur1, i);

            if (cur2 == null) {
                cur2 = new RandomListNode(cur1.label);
                cur2.random = cur1.random;
                newHead = cur2;
            } else {
                cur2.next = new RandomListNode(cur1.label);
                cur2 = cur2.next;
                cur2.random = cur1.random;
            }
            m2.put(i, cur2);
            i++;
            cur1 = cur1.next;
        }

        cur2 = newHead;
        while (cur2 != null) {
            if (cur2.random != null)
                cur2.random = m2.get(m1.get(cur2.random));

            cur2 = cur2.next;
        }

        return newHead;

    }


    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        //检查输入的特殊情况
        if (input == null || input.length <= 0 || input.length < k) {
            return list;
        }
        //构建最大堆
        for (int len = k / 2 - 1; len >= 0; len--) {
            adjustMaxHeapSort(input, len, k - 1);
        }
        //从第k个元素开始分别与最大堆的最大值做比较，如果比最大值小，则替换并调整堆。
        //最终堆里的就是最小的K个数。
        int tmp;
        for (int i = k; i < input.length; i++) {
            if (input[i] < input[0]) {
                tmp = input[0];
                input[0] = input[i];
                input[i] = tmp;
                adjustMaxHeapSort(input, 0, k - 1);
            }
        }
        for (int j = 0; j < k; j++) {
            list.add(input[j]);
        }
        return list;
    }

    public void adjustMaxHeapSort(int[] input, int pos, int length) {
        int temp;
        int child;
        for (temp = input[pos]; 2 * pos + 1 <= length; pos = child) {
            child = 2 * pos + 1;
            if (child < length && input[child] < input[child + 1]) {
                child++;
            }
            if (input[child] > temp) {
                input[pos] = input[child];
            } else {
                break;
            }
        }
        input[pos] = temp;
    }

    public ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        //检查输入的特殊情况
        if (input == null || input.length == 0 || input.length < k) {
            return list;
        }
        //构建最小堆
        for (int len = input.length / 2 - 1; len >= 0; len--) {
            adjustMinHeapSort(input, len, input.length);
        }

        for (int n : input) {
            System.out.print(n + " ");
        }
        System.out.println();

        int tmp;
        for (int i = 0; i < k; i++) {
            list.add(input[0]);
            tmp = input[input.length - i - 1];
            input[input.length - i - 1] = input[0];
            input[0] = tmp;
            for (int n : input) {
                System.out.print("b " + n + " ");
            }
            System.out.println();
            adjustMinHeapSort(input, 0, input.length - i - 2);
            for (int n : input) {
                System.out.print("a " + n + " ");
            }
            System.out.println();
        }
        return list;
    }

    public void adjustMinHeapSort(int[] input, int pos, int length) {
        int temp;
        int child;
        for (temp = input[pos]; 2 * pos + 1 <= length; pos = child) {
            child = 2 * pos + 1;
            if (child < length - 1 && input[child] > input[child + 1]) {
                child++;
            }
            if (input[child] < temp) {
                input[pos] = input[child];
            } else {
                break;
            }
        }
        input[pos] = temp;
    }


    public String PrintMinNumber(int[] numbers) {
        int n;
        StringBuilder s = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<Integer>();
        n = numbers.length;
        for (int i = 0; i < n; i++) {
            list.add(numbers[i]);
        }
        Collections.sort(list, (str1, str2) -> {
                    String s1 = str1 + "" + str2;
                    String s2 = str2 + "" + str1;
                    return s1.compareTo(s2);
                }
        );
        /*new Comparator<Integer>() {

            public int compare(Integer str1, Integer str2) {
                String s1 = str1 + "" + str2;
                String s2 = str2 + "" + str1;
                return s1.compareTo(s2);
            }
        }*/

        for (int j : list) {
            s.append(j);
        }
        return s.toString();

    }

    //too slow
    public int InversePairs1(int[] array) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        int count = 0;

        for (int n : array) {
            while (!s1.empty() && s1.peek() > n) {
                count++;
                count %= 1000000007;
                s2.push(s1.pop());
            }

            s1.push(n);
            while (!s2.empty()) {
                s1.push(s2.pop());
            }
        }

        return count;
    }

    public int inversePairs(int[] array) {
        return inversePairsHelper(array, 0, array.length - 1);
    }

    private int inversePairsHelper(int[] array, int start, int end) {
        if (start == end) return 0;
        int mid = start + (end - start) / 2;
        int left = inversePairsHelper(array, start, mid);
        int right = inversePairsHelper(array, mid + 1, end);

        int count = 0;

        int i = start, j = mid + 1;
        int[] tmp = new int[end - start + 1];
        int k = 0;
        while (i <= mid && j <= end) {
            if (array[i] <= array[j]) {
                tmp[k++] = array[i++];
            } else {
                tmp[k++] = array[j++];
                count += mid - i + 1;
            }
        }

        while (i <= mid) {
            tmp[k++] = array[i++];
        }

        while (j <= end) {
            tmp[k++] = array[j++];
        }

        for (k = 0; k < tmp.length; k++) {
            array[start + k] = tmp[k];
        }

        return left + right + count;
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        Set<ListNode> set = new HashSet<>();

        while (pHead1 != null || pHead2 != null) {
            if (pHead1 != null) {
                if (set.contains(pHead1)) {
                    return pHead1;
                }
                set.add(pHead1);
                pHead1 = pHead1.next;
            }
            if (pHead2 != null) {
                if (set.contains(pHead2)) {
                    return pHead2;
                }
                set.add(pHead2);
                pHead2 = pHead2.next;
            }
        }

        return null;
    }

    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        ListNode cur1 = pHead1;
        ListNode cur2 = pHead2;
        while (cur1 != cur2) {
            cur1 = cur1.next == null ? pHead2 : cur1.next;
            cur2 = cur2.next == null ? pHead1 : cur2.next;
        }

        return null;
    }

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        if (sum <= 1) {
            return lists;
        }
        int small = 1;
        int big = 2;
        int curSum = 3;

        while (small != (1 + sum) / 2) {          //当small==(1+sum)/2的时候停止
            System.out.println(curSum);
            if (curSum == sum) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                for (int i = small; i <= big; i++) {
                    list.add(i);
                }
                lists.add(list);
                small++;
                big++;
                curSum += big - small + 1;
            } else if (curSum < sum) {
                big++;
                curSum += big;
            } else {
                curSum -= small;
                small++;
            }
        }
        return lists;
    }

    public String LeftRotateString(String str, int n) {
        int abs = n % str.length();
        if (abs < 0) abs += n;

        return (str + str).substring(n, str.length());
    }

    public String ReverseSentence(String str) {
        String[] array = str.split(" ");
        List<String> ls = Arrays.asList(array);
        Collections.reverse(ls);
        StringBuilder sb = new StringBuilder();
        for (String s : ls) {
            sb.append(s);
            sb.append(" ");
        }
        if (array.length > 0) sb.deleteCharAt(sb.length() - 1);
        else return str;

        return sb.toString();
    }

    //注意数组时null的情况
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        int[] flag = new int[length];

        for (int i = 0; i < length; i++) {
            if (flag[numbers[i]] == 1) {
                duplication[0] = numbers[i];
                return true;
            }
            flag[numbers[i]] = 1;
        }
        return false;
    }

    public int[] multiply(int[] A) {
        int[] rst1 = new int[A.length];
        int[] rst2 = new int[A.length];
        if (rst1.length <= 1) return rst1;

        rst1[0] = 1;
        for (int i = 1; i < rst1.length; i++) {
            rst1[i] = rst1[i - 1] * A[i - 1];
        }

        rst2[rst2.length - 1] = 1;
        for (int i = rst2.length - 2; i >= 0; i--) {
            rst2[i] = rst2[i + 1] * A[i + 1];
            rst1[i] *= rst2[i];
        }


        return rst1;
    }

    /*public boolean match(char[] str, char[] pattern) {
        return matchHelper(str, pattern, 0, 0);
    }

    private boolean matchHelper(char[] str, char[] pattern, int strIndex, int patternIndex) {
        if (strIndex == str.length && patternIndex == pattern.length) return true;

        if (patternIndex == pattern.length && strIndex < str.length) return false;

        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            if (str[strIndex] == pattern[patternIndex]) {
                return matchHelper(str, pattern, strIndex, patternIndex + 2) ||
                        matchHelper(str, pattern, strIndex + 1, patternIndex + 2) ||
                        matchHelper(str, pattern, strIndex + 1, patternIndex);
            } else {
                return matchHelper(str, pattern, strIndex, patternIndex + 2);
            }
        } else {
            if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
                return matchHelper(str, pattern, strIndex + 1, patternIndex + 1);
            }
        }

        return false;
    }*/

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot == null) return true;
        else return symmetrical(pRoot.left, pRoot.right);
    }

    private boolean symmetrical(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 != null && n2 != null) {
            return n1.val == n2.val && symmetrical(n1.left, n2.right) && symmetrical(n1.right, n2.left);
        }
        return false;
    }

    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();

        if (pRoot != null) {
            q.offer(pRoot);
        }

        int count = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode h = q.poll();
                if (count % 2 == 1) {
                    tmp.add(h.val);
                } else {
                    tmp.add(0, h.val);
                }
                if (h.left != null) q.offer(h.left);
                if (h.right != null) q.offer(h.right);
            }
            rst.add(tmp);
        }

        for (ArrayList<Integer> a: rst ) {
            for (int i: a) {
                System.out.print(i + ",");
            }
        }

        return rst;
    }

    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> q = new LinkedList<>();

        if (root != null) {
            q.offer(root);
        } else {
            return "";
        }

        int count = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode h = q.poll();
                if (h == null) {
                    sb.append("#,");
                } else {
                    sb.append(h.val);
                    count = sb.length();
                    sb.append(",");
                    q.offer(h.left);
                    q.offer(h.right);
                }
            }
        }

        return sb.substring(0, count);
    }
    TreeNode Deserialize(String str) {
        String[] array = str.split(",");
        TreeNode head = null;
        if (array.length == 0 || array[0] == "") return head;
        System.out.println(array.length);
        System.out.println(array[0]);
//        return generateTree(array, 0);
        head = new TreeNode(Integer.valueOf(array[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(head);
        int index = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                int j = 0;
                while (j < 2) {
                    if (index < array.length) {
                        if (array[index].equals("#")) {

                        } else {
                            TreeNode tmp = new TreeNode(Integer.valueOf(array[index]));
                            if (j == 0 )
                                cur.left = tmp;
                            else
                                cur.right = tmp;
                            q.offer(tmp);
                        }
                    } else {
                        return head;
                    }
                    index++;
                    j++;
                }

            }
        }

        return head;
    }

    TreeNode generateTree(String[] array, int i) {
        if (i >= array.length) {
            return null;
        } else {
            if (array[i].equals("#")) {
                return null;
            }
            TreeNode node = new TreeNode(Integer.valueOf(array[i]));
            node.left = generateTree(array, 2 * i + 1);
            node.right = generateTree(array, 2 * i + 2);
            return node;
        }
    }

    private PriorityQueue<Integer> min = new PriorityQueue<>();
    private PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> b - a);
    private int count = 0;

    public void Insert(Integer num) {
        if (count % 2 == 0) {
            min.add(num);
            max.add(min.poll());
        } else {
            max.add(num);
            min.add(max.poll());
        }
        count++;
    }

    public Double GetMedian() {
        if (count % 2 == 0) {
            if (max.isEmpty()) {
                return 0.0;
            } else {
                return (double)(max.peek() + min.peek())/2;
            }
        } else {
            return (double)max.peek();
        }
    }

    static public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> rst = new ArrayList<>();
        if (size == 0 || size > num.length) return rst;
        int maxIndex = 0;
        int i = 1;
        for (; i < size; i++) {
            if (num[i] > num[maxIndex]) {
                maxIndex = i;
            }
        }
        rst.add(num[maxIndex]);

        System.out.println(maxIndex);
        System.out.println(i);

        for (; i < num.length; i++) {
            if (maxIndex == i - size) {
                maxIndex += 1;
                for (int j = maxIndex + 1; j <= i; j++) {
                    if (num[j] > num[maxIndex]) {
                        maxIndex = j;
                    }
                }
            } else {
                System.out.println(maxIndex + " "+ i);
                if (num[maxIndex] < num[i]) {
                    maxIndex = i;
                }
            }
            rst.add(num[maxIndex]);

        }

        return rst;

    }

    public static void main(String... args) {
//        System.out.println(new Solution().NumberOf1(Integer.MIN_VALUE));
//        new Solution().reOrderArray(new int[]{1, 2, 3, 4, 5, 6, 7});
//        ListNode l = new Solution().Merge(new ListNode(1), new ListNode(2));
//        System.out.println(l.val);
//        new Solution().printMatrix(new int[][]{{1}, {5}, {9}});
//        new Solution().GetLeastNumbers_Solution2(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 8);
//        new Solution().FindContinuousSequence(9);
//        new SimpleDateFormat();
//        new ConcurrentHashMap<>();
//        new Solution().duplicate(null, 0, new int[0]);

        /*TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n0 = new TreeNode(5);
        n4.left = n3;
        n3.left = n2;
        n0.left = n4;
        System.out.println(new Solution().Serialize(n0));
        new Solution().Print(new Solution().Deserialize(""));*/

        maxInWindows(new int[]{2,3,4,2,6,2,5,1}, 3);
    }
}
