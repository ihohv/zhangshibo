public class ListReverse {

	public static class ListNode{
		public int val;
		public ListNode next;
		
		public ListNode(int val) {
			this.val = val;
		}
		
		public ListNode(int val,ListNode next) {
			this.val = val;
			this.next = next;
		}
		
	}
	
	public static ListNode listReverse(ListNode head) {
		ListNode pre = null;
		ListNode next = null;
		while(head!=null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}
	
	
	public static class DoubleListNode{
		int val;
		DoubleListNode last;
		DoubleListNode next;
		
		public DoubleListNode(int val) {
			this.val = val;
		}
		
		public DoubleListNode(int val,DoubleListNode last,DoubleListNode next) {
			this.val = val;
			this.last = last;
			this.next = next;
		}
	}
	
	public static DoubleListNode doubleListReverse(DoubleListNode head) {
		DoubleListNode pre = null;
		DoubleListNode next = null;
		while(head!=null) {
			next = head.next;
			head.next = pre;
			head.last = next;
			pre = head;
			head = next;
		}
		return pre;
	}
}
