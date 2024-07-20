import java.util.Arrays;

public class FindLeft {

	public static int findLeft(int[] arr, int num) {
		int ans = -1, l = 0, r = arr.length - 1, index;
		while (l <= r) {
			index = l + ((r - l) >> 1);
			if (arr[index] >= num) {
				ans = index;
				r = index - 1;
			} else {
				l = index + 1;
			}
		}
		return ans;
	}

	// 生成随机数组
	public static int[] randomArray(int n, int v) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = (int) (Math.random() * v) + 1;
		}
		return arr;
	}

	// 测试函数，暴力找数字位置
	public static int testFunction(int[] arr, int num) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= num)
				return i;
		}
		return -1;
	}

	public static void arrayPrint(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		// 随机数组最大长度
		int N = 1000;
		// 随机数组每个值，在1~V之间等概率随机
		int V = 50000;
		// 测试次数
		int testTimes = 300;
		System.out.println("测试开始");
		for (int i = 0; i < testTimes; i++) {
			// 随机数组的长度
			int n = (int) (Math.random() * N);
			int[] arr = randomArray(n, V);
			int num = (int) (Math.random() * V);
			Arrays.sort(arr);
			if (findLeft(arr, num) != testFunction(arr, num)) {
				arrayPrint(arr);
				System.out.println(findLeft(arr, num));
				System.out.println(testFunction(arr, num));
				System.out.println("出现错误！");
				break;
			}

		}
		System.out.println("测试结束");
	}
}
