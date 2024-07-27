import java.util.Stack;
public class BinaryTreeTraversalIteration {

	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int v) {
			val = v;
		}
	}
	
	public static void preOrder(TreeNode head) {
		if(head == null) {
			return;
		}
		Stack<TreeNode> order = new Stack<TreeNode>();
		order.push(head);
		while(!order.empty()) {
			head = order.pop();
			System.out.print(head.val + " ");
			if(head.right != null) {
				order.push(head.right);
			}
			if(head.left != null) {
				order.push(head.left);
			}
		}
		System.out.println();
	}
	
	public static void inOrder(TreeNode head) {
		if(head != null) {
			Stack<TreeNode> order = new Stack<TreeNode>();
			while(!order.empty() || head != null) {
				if(head != null) {
					order.push(head);
					head = head.left;
				}
				else {
					head = order.pop();
					System.out.print(head.val + " ");
					head = head.right;
				}
			}
			System.out.println();
		}
	}
	
	public static void posOrderByTwoStack(TreeNode head) {
		if(head != null) {
			Stack<TreeNode> order = new Stack<TreeNode>();
			Stack<TreeNode> collect = new Stack<TreeNode>();
			order.push(head);
			while(!order.empty()) {
				head = order.pop();
				collect.push(head);
				if(head.left != null) {
					order.push(head.left);
				}
				if(head.right != null) {
					order.push(head.right);
				}
			}
			while(!collect.empty()) {
				head = collect.pop();
				System.out.print(head.val + " ");
			}
			System.out.println();
		}
	}
	
	public static void posOrderByOneStack(TreeNode head) {
		if(head != null) {
			Stack<TreeNode> order = new Stack<TreeNode>();
			order.push(head);
			while(!order.empty()) {
				TreeNode cur = order.peek();
				if(cur.left != null && head != cur.left && head != cur.right) {
					order.push(cur.left);
				}
				else if(cur.right != null && head != cur.right) {
					order.push(cur.right);
				}
				else {
					System.out.print(cur.val + " ");
					head = order.pop();
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		TreeNode head = new TreeNode(1);
		head.left = new TreeNode(2);
		head.right = new TreeNode(3);
		head.left.left = new TreeNode(4);
		head.left.right = new TreeNode(5);
		head.right.left = new TreeNode(6);
		head.right.right = new TreeNode(7);
		
		preOrder(head);
		inOrder(head);
		posOrderByTwoStack(head);
		posOrderByOneStack(head);
	}
}
