import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class RadixSort {

	// 设置进制
	public static int BASE = 10;

	public static int MAX_INIT = 100001;

	public static int[] arr = new int[MAX_INIT];

	public static int[] help = new int[MAX_INIT];

	public static int[] cnts = new int[BASE];

	public static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StreamTokenizer in = new StreamTokenizer(br);
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		in.nextToken();
		n = (int) in.nval;
		for (int i = 0; i < n; i++) {
			in.nextToken();
			arr[i] = (int) in.nval;
		}
		sort();
		for (int i = 0; i < n - 1; i++) {
			out.print(arr[i] + " ");
		}
		out.println(arr[n - 1]);
		out.flush();
		out.close();
		br.close();
	}

	public static void sort() {
		int min = arr[0];
		for (int i = 1; i < n; i++) {
			min = Math.min(min, arr[i]);
		}
		int max = 0;
		for (int i = 0; i < n; i++) {
			arr[i] -= min;
			max = Math.max(max, arr[i]);
		}
		radixSort(bits(max));
		for (int i = 0; i < n; i++) {
			arr[i] += min;
		}
	}

	public static int bits(int n) {
		int ans = 0;
		while (n > 0) {
			n /= BASE;
			ans++;
		}
		return ans;
	}

	public static void radixSort(int bits) {
		for (int offset = 1; bits > 0; offset *= BASE, bits--) {
			Arrays.fill(cnts, 0);
			for (int i = 0; i < n; i++) {
				cnts[(arr[i] / offset) % BASE]++;
			}
			for (int i = 1; i < BASE; i++) {
				cnts[i] = cnts[i] + cnts[i - 1];
			}
			for (int i = n - 1; i >= 0; i--) {
				help[--cnts[(arr[i] / offset) % BASE]] = arr[i];
			}
			for (int i = 0; i < n; i++) {
				arr[i] = help[i];
			}
		}
	}
}
