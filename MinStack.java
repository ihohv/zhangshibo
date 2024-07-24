import java.util.Stack;

public class MinStack {

	public Stack<Integer> dataStack;
	public Stack<Integer> minStack;

	public MinStack() {
		dataStack = new Stack<Integer>();
		minStack = new Stack<Integer>();
	}

	public void push(int value) {
		dataStack.push(value);
		if (minStack.isEmpty() || value < minStack.peek()) {
			minStack.push(value);
		} else {
			minStack.push(minStack.peek());
		}
	}

	public void pop() {
		dataStack.pop();
		minStack.pop();
	}

	public int top() {
		return dataStack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}

	public class MinStackPlus {
		public final int MAXN = 8001;

		public int[] data;
		public int[] min;
		int size;

		public MinStackPlus() {
			data = new int[MAXN];
			min = new int[MAXN];
			size = 0;
		}

		public void push(int val) {
			data[size] = val;
			if (size == 0 || val <= min[size - 1]) {
				min[size] = val;
			} else {
				min[size] = min[size - 1];
			}
			size++;
		}

		public void pop() {
			size--;
		}

		public int top() {
			return data[size - 1];
		}

		public int getMin() {
			return min[size - 1];
		}

	}
}
