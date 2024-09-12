public class ReverseNodesInkGroup {

    // 每k个节点一组翻转链表
    // 测试链接：https://leetcode.cn/problems/reverse-nodes-in-k-group/
    public static class ListNode {
        public int val;
        public ListNode next;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode end = teamEnd(start, k);
        if (end == null) {
            return head;
        }
        // 第一组很特殊因为牵扯到换头的问题
        head = end;
        reverse(start, end);
        // 翻转之后start变成了上一组的结尾节点
        ListNode lastTeamEnd = start;
        while (lastTeamEnd.next != null) {
            start = lastTeamEnd.next;
            end = teamEnd(start, k);
            if (end == null) {
                return head;
            }
            reverse(start, end);
            lastTeamEnd.next = end;
            lastTeamEnd = start;
        }
        return head;
    }

    public static ListNode teamEnd(ListNode start, int k) {
        while (--k != 0 && start != null) {
            start = start.next;
        }
        return start;
    }

    public void reverse(ListNode start, ListNode end) {
        end = end.next;
        ListNode pre = null, cur = start, next = null;
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = end;
    }
}
