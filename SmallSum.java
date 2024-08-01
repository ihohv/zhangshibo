import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.BufferedReader;

public class SmallSum {
	public static int MAX_INIT = 10001;
	public static int[] arr = new int[MAX_INIT];
	public static int[] help = new int[MAX_INIT];
	public static int n;

	public static long smallSum(int l, int r) {
		if (l == r) {
			return 0;
		}
		int m = l + ((r - l) >> 1);
		return smallSum(l, m) + smallSum(m + 1, r) + merge(l, r, m);
	}

	public static long merge(int l, int r, int m) {
		long res = 0;
		for (int i = l, j = m + 1, sum = 0; j <= r; j++) {
			while (i <= m && arr[i] <= arr[j]) {
				sum += arr[i++];
			}
			res += sum;
		}

		int a = l, b = m + 1, i = l;
		while (a <= m && b <= r) {
			help[i++] = arr[a] <= arr[b] ? arr[a++] : arr[b++];
		}
		while (a <= m) {
			help[i++] = arr[a++];
		}
		while (b <= r) {
			help[i++] = arr[b++];
		}
		for (i = l; i <= r; i++) {
			arr[i] = help[i];
		}
		return res;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StreamTokenizer in = new StreamTokenizer(br);
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		while (in.nextToken() != StreamTokenizer.TT_EOF) {
			n = (int) in.nval;
			for (int i = 0; i < n; i++) {
				in.nextToken();
				arr[i] = (int) in.nval;
			}
			out.println(smallSum(0, n - 1));
		}
		out.flush();
		out.close();
	}
}
