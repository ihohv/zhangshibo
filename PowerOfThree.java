public class PowerOfThree {
	
	// 判断一个整数是不是3的幂
	// 测试链接 : https://leetcode.cn/problems/power-of-three/

	public static boolean isPowerOfThree(int n) {
		return n > 0 && 1162261467 % n == 0;
	}

	public static void main(String[] String) {
		for (int i = 0; i < 25; i++) {
			int ans = 1;
			int m = i;
			while (m > 0) {
				ans *= 3;
				m--;
			}
			System.out.print(ans + "  ");
		}
	}
}
