public class ReversePairs {

	public static int MAX_INIT = 50001;
	public static int[] help = new int[MAX_INIT];

	public static int merge(int l, int r, int m, int[] arr) {
		int ans = 0;
		for (int i = l, j = m + 1; i <= m; i++) {
			while ((long) arr[i] > (long) 2 * arr[j] && j <= r) {
				j++;
			}
			ans += j - m - 1;
		}

		int a = l, b = m + 1, i = l;
		while (a <= m && b <= r) {
			help[i++] = arr[a] < arr[b] ? arr[a++] : arr[b++];
		}
		while (a <= m) {
			help[i++] = arr[a++];
		}
		while (b <= r) {
			help[i++] = arr[b++];
		}
		for (i = l; i <= r; i++) {
			arr[i] = help[i];
		}
		return ans;
	}

	public static int reversePairs(int l, int r, int[] arr) {
		if (l == r) {
			return 0;
		}
		int m = l + ((r - l) >> 1);
		return reversePairs(l, m, arr) + reversePairs(m + 1, r, arr) + merge(l, r, m, arr);
	}
}
