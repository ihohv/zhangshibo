public class SingleNumber {

	public static int singleNumber(int[] arr) {
		int eor = 0;
		for (int num : arr) {
			eor ^= num;
		}
		return eor;
	}
}
