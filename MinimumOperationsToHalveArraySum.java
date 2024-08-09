import java.util.PriorityQueue;

public class MinimumOperationsToHalveArraySum {

	public static int halveArray(int[] nums) {
		PriorityQueue<Double> heap = new PriorityQueue<Double>((a, b) -> b.compareTo(a));
		double sum = 0;
		for (int num : nums) {
			heap.add((double) num);
			sum += num;
		}
		int ans = 0;
		sum /= 2;
		for (double count = 0, cur; count < sum; ans++, count += cur) {
			cur = heap.poll() / 2;
			heap.add(cur);
		}
		return ans;
	}
}
