import java.util.HashSet;

// 位图的实现，数据为非负数，且在一定范围内，位图可以节省大量空间
public class BitSet {

	public static class Bitset {

		public int[] set;

		public Bitset(int n) {
			set = new int[(n + 31) / 32];
		}

		public void add(int num) {
			set[num / 32] |= 1 << (num % 32);
		}

		public void remove(int num) {
			set[num / 32] &= ~(1 << (num % 32));
		}

		public void reverse(int num) {
			set[num / 32] ^= 1 << (num % 32);
		}

		public boolean contains(int num) {
			return ((set[num / 32] >> (num % 32)) & 1) == 1;
		}
	}

	public static void main(String[] ags) {
		int n = 1000;
		int testTimes = 10000;
		System.out.println("测试开始");
		Bitset bitSet = new Bitset(n);
		HashSet<Integer> hashSet = new HashSet<>();
		System.out.println("调用阶段开始");
		for (int i = 0; i < testTimes; i++) {
			double decide = Math.random();
			int num = (int) (Math.random() * n);
			if (decide < 0.33) {
				bitSet.add(num);
				hashSet.add(num);
			} else if (decide < 0.66) {
				bitSet.remove(num);
				hashSet.remove(num);
			} else {
				bitSet.reverse(num);
				if (hashSet.contains(num)) {
					hashSet.remove(num);
				} else {
					hashSet.add(num);
				}
			}
		}
		System.out.println("调用阶段结束");
		System.out.println("验证阶段开始");
		for (int i = 0; i < n; i++) {
			if (bitSet.contains(i) != hashSet.contains(i)) {
				System.out.println("出错了!");
			}
		}
		System.out.println("验证阶段结束");
		System.out.println("测试结束");
	}
}
