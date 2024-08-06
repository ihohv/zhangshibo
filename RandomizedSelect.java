public class RandomizedSelect {

	public static int findKthLargest(int[] nums, int k) {
		return f(nums, nums.length-k);
	}

	public static int f(int[] arr, int k) {
		int ans = 0;
		int l = 0, r = arr.length - 1;
		for (int i = l; i <= r;) {
			int x = arr[l + (int) (Math.random() * (r - l + 1))];
			partition(arr, l, r, x);
			if (last < k) {
				l = last + 1;
			} else if (first > k) {
				r = first - 1;
			} else {
				ans = arr[k];
				break;
			}
		}
		return ans;
	}

	public static int first, last;

	public static void partition(int[] arr, int l, int r, int x) {
		first = l;
		last = r;
		int i = l;
		while (i <= last) {
			if (arr[i] < x) {
				swap(arr, i++, first++);
			} else if (arr[i] == x) {
				i++;
			} else {
				swap(arr, i, last--);
			}
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int tem = arr[i];
		arr[i] = arr[j];
		arr[j] = tem;
	}
}
