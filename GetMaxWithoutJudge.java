public class GetMaxWithoutJudge {

	// 保证n一定是0或1
	public static int flip(int n) {
		return n ^ 1;
	}

	// 无符号右移，负数返回0，正数返回1
	public static int sign(int n) {
		return flip(n >>> 31);
	}

	// 有溢出风险
	public static int getMax1(int a, int b) {
		int c = a - b;
		int returnA = sign(c);
		int returnB = flip(returnA);
		return a * returnA + b * returnB;
	}

	public static int getMax2(int a, int b) {
		// c可能是溢出的
		int c = a - b;
		// a的符号
		int sa = sign(a);
		// b的符号
		int sb = sign(b);
		// c的符号
		int sc = sign(c);
		// 判断A和B，符号是不是不一样，如果不一样diffAB=1，如果一样diffAB=0
		int diffAB = sa ^ sb;
		// 判断A和B，符号是不是一样，如果一样sameAB=1，如果不一样sameAB=0
		int sameAB = flip(diffAB);
		int returnA = diffAB * sa + sameAB * sc;
		int returnB = flip(returnA);
		return a * returnA + b * returnB;
	}

	public static void main(String[] args) {
		int a = Integer.MIN_VALUE;
		int b = Integer.MAX_VALUE;
		// getMax1方法会错误，因为溢出
		System.out.println(getMax1(a, b));
		// getMax2方法永远正确
		System.out.println(getMax2(a, b));
	}
}
