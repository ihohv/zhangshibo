public class BinaryTreeTraversalRecursion {

	public static class TreeNode{
		public int val;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static void preOrder(TreeNode head) {
		if(head == null) {
			return;
		}
		
		System.out.print(head.val + " ");
		preOrder(head.left);
		preOrder(head.right);
	}
	
	public static void inOrder(TreeNode head) {
		if(head == null) {
			return;
		}
		
		preOrder(head.left);
		System.out.print(head.val + " ");
		preOrder(head.right);
	}
	
	public static void posOrder(TreeNode head) {
		if(head == null) {
			return;
		}
		
		preOrder(head.left);
		preOrder(head.right);
		System.out.print(head.val + " ");
	}
	
	public static void main(String[] args) {
		TreeNode head = new TreeNode(1);
		head.left = new TreeNode(2);
		head.right = new TreeNode(3);
		head.left.left = new TreeNode(4);
		head.left.right = new TreeNode(5);
		head.right.left = new TreeNode(6);
		head.right.right = new TreeNode(7);
	
		System.out.println("先序遍历递归版");
		preOrder(head);
		System.out.println();

		System.out.println("中序遍历递归版");
		inOrder(head);
		System.out.println();

		System.out.println("后序遍历递归版");
		posOrder(head);
		System.out.println();
	}
}
