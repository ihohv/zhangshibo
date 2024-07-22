public class PartitionList {

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

	public static ListNode partitionList(ListNode head, int num) {
		ListNode lhead = null, lcur = null;
		ListNode rhead = null, rcur = null;
		for (; head != null; head = head.next) {
			if (head.val < num) {
				if (lhead == null) {
					lhead = new ListNode(head.val);
					lcur = lhead;
				} else {
					lcur.next = new ListNode(head.val);
					lcur = lcur.next;
				}
			} else {
				if (rhead == null) {
					rhead = new ListNode(head.val);
					rcur = rhead;
				} else {
					rcur.next = new ListNode(head.val);
					rcur = rcur.next;
				}
			}
		}
		if (lhead == null) {
			return rhead;
		}
		lcur.next = rhead;
		return lhead;
	}
}
