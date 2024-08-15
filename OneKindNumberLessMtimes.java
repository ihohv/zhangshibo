public class OneKindNumberLessMtimes {

	public static int singleNumber(int[] arr) {
		return find(arr, 3);
	}

	public static int find(int[] arr, int m) {
		int[] cnts = new int[32];
		for (int num : arr) {
			for (int i = 0; i < 32; i++) {
				cnts[i] += (num >> i) & 1;
			}
		}
		int ans = 0;
		for (int i = 0; i < 32; i++) {
			if (cnts[i] % m != 0) {
				ans |= (1 << i);
			}
		}
		return ans;
	}
}
