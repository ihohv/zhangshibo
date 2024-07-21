public class MergeTwoLists {

	public static class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
		}

		public ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static ListNode mergeTwoLists(ListNode head1, ListNode head2) {
		if (head1 == null || head2 == null) {
			return head1 == null ? head2 : head1;
		}
		ListNode head = head1.val >= head2.val ? head2 : head1;
		ListNode pre = head;
		ListNode cur1 = head == head1 ? head1.next : head1;
		ListNode cur2 = head == head2 ? head2.next : head2;
		while (cur1 != null && cur2 != null) {
			if (cur1.val <= cur2.val) {
				pre.next = cur1;
				cur1 = cur1.next;
			} else {
				pre.next = cur2;
				cur2 = cur2.next;
			}
			pre = pre.next;
		}
		pre.next = cur1 == null ? cur2 : cur1;
		return head;
	}
}
