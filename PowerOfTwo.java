public class PowerOfTwo {

	// 判断一个整数是不是2的幂
	// 测试链接 : https://leetcode.cn/problems/power-of-two/
	public static boolean isPowerOfTwo(int n) {
		return n > 0 && n == (n & -n);
	}
}
