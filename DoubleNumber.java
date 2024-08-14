public class DoubleNumber {

	public static int[] singleNumber(int[] arr) {
		int eor1 = 0;
		for (int num : arr) {
			eor1 ^= num;
		}
		int rightOne = eor1 & (-eor1);
		int eor2 = 0;
		for (int num : arr) {
			if ((num & rightOne) == 0) {
				eor2 ^= num;
			}
		}
		return new int[] { eor2, eor1 ^ eor2 };
	}
}
