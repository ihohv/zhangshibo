public class SelectBubbleInsert {

	public static void swap(int[] arr, int i, int j) {
		int count = arr[i];
		arr[i] = arr[j];
		arr[j] = count;
	}

	// 选择排序
	public static void selectSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}

		for (int minIndex, i = 0; i < arr.length - 1; i++) {
			minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			swap(arr, i, minIndex);
		}
	}

	// 冒泡排序
	public static void bubbleSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}

		for (int end = arr.length - 1; end > 0; end--) {
			for (int i = 0; i < end; i++) {
				if (arr[i] > arr[i + 1]) {
					swap(arr, i, i + 1);
				}
			}
		}
	}

	// 插入排序
	public static void insertSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
				swap(arr, j, j + 1);
			}
		}
	}

	// n 表示随机数组的长度，v 表示将随机值设置在[1,v]之间
	public static int[] randomArray(int n, int v) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = (int) (Math.random() * v) + 1;
		}
		return arr;
	}

	public static int[] copyArray(int[] arr) {
		int n = arr.length;
		int[] ans = new int[n];
		for (int i = 0; i < n; i++) {
			ans[i] = arr[i];
		}
		return ans;
	}

	public static boolean compareArray(int[] arr1, int[] arr2) {
		if (arr1.length != arr2.length)
			return false;

		int n = arr1.length;
		for (int i = 0; i < n; i++) {
			if (arr1[i] != arr2[i])
				return false;
		}
		return true;
	}

	public static void arrayPrint(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		// 随机数组最大长度
		int N = 100;
		// 随机数组每个值，在1~V之间等概率随机
		int V = 5000;
		// 测试次数
		int testTimes = 300;
		System.out.println("测试开始");
		for (int i = 0; i < testTimes; i++) {
			// 随机数组的长度
			int n = (int) (Math.random() * N);
			int[] arr = randomArray(n, V);
			int[] arr1 = copyArray(arr);
			int[] arr2 = copyArray(arr);
			int[] arr3 = copyArray(arr);
			selectSort(arr1);
			bubbleSort(arr2);
			insertSort(arr3);
			if (!compareArray(arr1, arr2) || !compareArray(arr1, arr3)) {
				System.out.println("出错了！");
				arrayPrint(arr);
				arrayPrint(arr1);
				arrayPrint(arr2);
				arrayPrint(arr3);
				break;
			}
		}
		System.out.println("测试结束！");
	}
}
