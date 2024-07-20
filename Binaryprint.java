public class BinaryPrint {

	// 打印一个int类型的数字，32位进制的状态
	// 左侧是高位，右侧是低位
	public static void binaryPrint(int num) {
		for (int i = 31; i >= 0; i--) {
			System.out.print(((1 << i) & num) == 0 ? "0" : "1");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int n = -8;
		binaryPrint(n);
	}
}
