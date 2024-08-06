public class HeapSort {

	public static void heapInsert(int[] arr, int i) {
		while (arr[i] > arr[(i - 1) / 2]) {
			swap(arr, i, (i - 1) / 2);
			i = (i - 1) / 2;
		}
	}

	public static void heapify(int[] arr, int i, int size) {
		int l = i * 2 + 1;
		while (l < size) {
			int best = l + 1 < size && arr[l] > arr[l + 1] ? l : l + 1;
			best = arr[best] > arr[i] ? best : i;
			if (best == i) {
				break;
			}
			swap(arr, best, i);
			i = best;
			l = i * 2 + 1;
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int tem = arr[i];
		arr[i] = arr[j];
		arr[j] = tem;
	}

	// 从顶到底建立大根堆，O(n * logn)
	// 依次弹出堆内最大值并排好序，O(n * logn)
	// 整体时间复杂度O(n * logn)
	public static void heapSort1(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			heapInsert(arr, i);
		}
		int size = n;
		while (size > 1) {
			swap(arr, 0, --size);
			heapify(arr, 0, size);
		}
	}

	// 从底到顶建立大根堆，O(n)
	// 依次弹出堆内最大值并排好序，O(n * logn)
	// 整体时间复杂度O(n * logn)
	public static void heapSort2(int[] arr) {
		int n = arr.length;
		for (int i = n - 1; i >= 0; i--) {
			heapify(arr, i, n);
		}
		int size = n;
		while (size > 1) {
			swap(arr, 0, --size);
			heapify(arr, 0, size);
		}
	}
}
