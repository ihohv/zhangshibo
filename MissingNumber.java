public class MissingNumber {

	public static int missingNumber(int[] arr) {
		int eorAll = 0, eorHas = 0;
		for (int i = 0; i < arr.length; i++) {
			eorAll ^= i;
			eorHas ^= arr[i];
		}
		eorAll ^= arr.length;
		return eorAll ^ eorHas;
	}
}
