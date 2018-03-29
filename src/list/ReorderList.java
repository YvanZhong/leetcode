package list;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class ReorderList {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void reorderList(ListNode head) {
        if (head == null) return;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = new ListNode(0);
        //head2.next = slow;
        //reverse
        ListNode cur = slow.next, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = head2.next;
            head2.next = cur;
            cur = next;
        }

        head2 = head2.next;



        /*while (head.next != slow) {
            next = head.next;
            head.next = head2;
            ListNode next2 = head2.next;
            head2.next = next;
            head = next;
            head2 = next2;
        }*/
        ListNode h = head2;
        while (h != null) {
            System.out.println(h.val);
            h = h.next;
        }

        ListNode p = head;
        ListNode q = head2;
        while (q != null && p != null) {
            slow.next = q.next;
            q.next = p.next;
            p.next = q;
            q = slow.next;
            p = p.next.next;
        }


    }

    public static void main(String... args) {
        ListNode h = new ListNode(0);
        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);
        ListNode h4 = new ListNode(4);
        ListNode h5 = new ListNode(5);
        h.next = h1;
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        reorderList(h);

        System.out.println("rst");
        while (h != null) {
            System.out.println(h.val);
            h = h.next;
        }
    }
}
