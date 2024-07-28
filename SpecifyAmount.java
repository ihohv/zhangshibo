import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.StreamTokenizer;

public class SpecifyAmount {

	// 求子矩阵的最大累加和
	public static int maxSumSubmatrix(int[][] mat, int n, int m) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			// 需要的辅助数组，临时动态生成
			int[] arr = new int[m];
			for (int j = i; j < n; j++) {
				for (int k = 0; k < m; k++) {
					arr[k] += mat[j][k];
				}
				max = Math.max(max, maxSumSubarray(arr, m));
			}
		}
		return max;
	}

	// 求子数组的最大累加和
	public static int maxSumSubarray(int[] arr, int m) {
		int max = Integer.MIN_VALUE;
		int cur = 0;
		for (int i = 0; i < m; i++) {
			cur += arr[i];
			max = Math.max(max, cur);
			cur = cur < 0 ? 0 : cur;
		}
		return max;
	}

	public static void main(String[] args) throws IOException {
		// 将文件里的内容加载到内存中
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 一个一个读数字
		StreamTokenizer in = new StreamTokenizer(br);
		// 提交答案时使用，将答案放在内存中
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

		// 文件没用空就继续读
		while (in.nextToken() != StreamTokenizer.TT_EOF) {
			int n = (int) in.nval;
			in.nextToken();
			int m = (int) in.nval;
			int[][] mat = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					in.nextToken();
					mat[i][j] = (int) in.nval;
				}
			}
			out.println(maxSumSubmatrix(mat, n, m));
		}
		out.flush();
		br.close();
		out.close();
	}
}
