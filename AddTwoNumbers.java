public class AddTwoNumbers {

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

	public static ListNode addTwoNumbers(ListNode head1, ListNode head2) {
		ListNode head = null, cur = null;
		int carry = 0;
		for (int sum, val; head1 != null || head2 != null; head1 = head1 == null ? null
				: head1.next, head2 = head2 == null ? null : head2.next) {
			sum = (head1 == null ? 0 : head1.val) + (head2 == null ? 0 : head2.val) + carry;
			val = sum % 10;
			carry = sum / 10;
			if (head == null) {
				head = new ListNode(val);
				cur = head;
			} else {
				cur.next = new ListNode(val);
				cur = cur.next;
			}
		}
		if (carry == 1)
			cur.next = new ListNode(1);
		return head;
	}
}
