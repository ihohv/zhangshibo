public class IntersectionOfTwoLinkedLists {

    // 返回两个无环链表相交的第一个节点
    // 测试链接 : https://leetcode.cn/problems/intersection-of-two-linked-lists/
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int dis = 0;
        ListNode a = headA, b = headB;
        if (headA == null || headB == null) {
            return null;
        }
        while (a != null) {
            dis++;
            a = a.next;
        }
        while (b != null) {
            dis--;
            b = b.next;
        }
        a = headA;
        b = headB;
        if (dis >= 0) {
            while (dis-- != 0) {
                a = a.next;
            }
        } else {
            while (dis++ != 0) {
                b = b.next;
            }
        }
        if (a == b) {
            return a;
        }
        while (a != null && b != null) {
            if (a.next == b.next) {
                return a.next;
            }
            a = a.next;
            b = b.next;
        }
        return null;
    }
}
