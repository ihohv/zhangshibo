import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class MaxCover {

	public static int MAX_INIT = 100001;

	public static int[][] arr = new int[MAX_INIT][2];

	public static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StreamTokenizer in = new StreamTokenizer(br);
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		while (in.nextToken() != in.TT_EOF) {
			n = (int) in.nval;
			for (int i = 0; i < n; i++) {
				in.nextToken();
				arr[i][0] = (int) in.nval;
				in.nextToken();
				arr[i][1] = (int) in.nval;
			}
			out.println(compute());
		}
		out.flush();
		out.close();
		br.close();
	}

	public static int compute() {
		Arrays.sort(arr, 0, n, (a, b) -> a[0] - b[0]);
		int ans = 0;
		for (int i = 0; i < n; i++) {
			while (size > 0 && heap[0] <= arr[i][0]) {
				pop();
			}
			add(arr[i][1]);
			ans = Math.max(ans, size);
		}
		return ans;
	}

	public static int[] heap = new int[MAX_INIT];

	public static int size;

	public static void pop() {
		swap(0, --size);
		int l = 0;
		int i = 2 * l + 1;
		while (i < size) {
			int lower = i + 1 < size && heap[i + 1] < heap[i] ? i + 1 : i;
			lower = heap[l] < heap[lower] ? l : lower;
			if (lower == l) {
				break;
			}
			swap(l, lower);
			l = lower;
			i = 2 * l + 1;
		}
	}

	public static void add(int n) {
		heap[size] = n;
		int i = size++;
		while (heap[i] < heap[(i - 1) / 2]) {
			swap(i, (i - 1) / 2);
			i = (i - 1) / 2;
		}
	}

	public static void swap(int i, int j) {
		int tem = heap[i];
		heap[i] = heap[j];
		heap[j] = tem;
	}

}
