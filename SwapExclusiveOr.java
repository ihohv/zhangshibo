public class SwapExclusiveOr {

	public static void main(String[] args) {
		int a = 9999;
		int b = -1234;
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println(a);
		System.out.println(b);

		int[] arr = { 7, 19 };
		swap(arr, 0, 1);
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		swap(arr, 0, 0);
		System.out.println(arr[0]);
	}

	public static void swap(int[] arr, int i, int j) {
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[i] ^ arr[j];
	}
}
