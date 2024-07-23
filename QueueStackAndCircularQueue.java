import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class QueueStackAndCircularQueue {

	public static class Queue {
		public int[] queue;
		public int l;
		public int r;

		public Queue(int n) {
			queue = new int[n];
			l = 0;
			r = 0;
		}

		public boolean isEmpty() {
			return l == r;
		}

		public void offer(int num) {
			queue[r++] = num;
		}

		public int poll() {
			return queue[l++];
		}

		public int head() {
			return queue[l];
		}

		public int size() {
			return r - l;
		}
	}

	public static class Stack {
		public int[] stack;
		public int size;

		public Stack(int n) {
			stack = new int[n];
			size = 0;
		}

		public boolean isEmpty() {
			return size == 0;
		}

		public void push(int num) {
			stack[size++] = num;
		}

		public int pop() {
			return stack[--size];
		}

		public int peek() {
			return stack[size - 1];
		}

		public int size() {
			return size;
		}
	}

	public class CircularQueue {
		public int[] queue;
		public int l, r, size, limit;

		public CircularQueue(int n) {
			queue = new int[n];
			l = r = size = 0;
			limit = n;
		}

		public boolean isFull() {
			return size == limit;
		}

		public boolean isEmpty() {
			return size == 0;
		}

		public boolean enQueue(int num) {
			if (isFull()) {
				return false;
			}
			queue[r] = num;
			r = r == limit - 1 ? 0 : (r + 1);
			size++;
			return true;
		}

		public boolean deQueue() {
			if (isEmpty()) {
				return false;
			}
			l = l == limit - 1 ? 0 : (l + 1);
			size--;
			return true;
		}

		public int Rear() {
			if (isEmpty()) {
				return -1;
			}
			int last = r == 0 ? (limit - 1) : (r - 1);
			return queue[last];
		}

		public int Front() {
			if (isEmpty()) {
				return -1;
			}
			return queue[l];
		}
	}
}
