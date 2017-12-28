package nowcoder.offer;

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

    public static void main(String... args) {
//        System.out.println(new Solution().NumberOf1(Integer.MIN_VALUE));
//        new Solution().reOrderArray(new int[]{1, 2, 3, 4, 5, 6, 7});
        ListNode l = new Solution().Merge(new ListNode(1), new ListNode(2));
        System.out.println(l.val);
    }
}
