import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamTokenizer;
import java.io.BufferedReader;

public class QuickSort {

	public static int MAX_INIT = 100001;
	public static int[] arr = new int[MAX_INIT];
	public static int n;

	public static void quickSort1(int l, int r) {
		if (l >= r) {
			return;
		}
		int x = arr[l + (int) (Math.random() * (r - l + 1))];
		int mid = partition1(l, r, x);
		quickSort1(l, mid - 1);
		quickSort1(mid + 1, r);
	}

	public static int partition1(int l, int r, int x) {
		int a = l, ax = 0;
		for (int i = l; i <= r; i++) {
			if (arr[i] <= x) {
				swap(a, i);
				if (arr[a] == x) {
					ax = a;
				}
				a++;
			}
		}
		swap(a - 1, ax);
		return a - 1;
	}

	public static void swap(int a, int b) {
		int tem = arr[a];
		arr[a] = arr[b];
		arr[b] = tem;
	}

	public static int first;
	public static int last;

	public static void quickSort2(int l, int r) {
		if (l >= r) {
			return;
		}
		int x = arr[l + (int) (Math.random() * (r - l + 1))];
		partition2(l, r, x);
		int left = first;
		int right = last;
		quickSort2(l, left - 1);
		quickSort2(right + 1, r);
	}

	public static void partition2(int l, int r, int x) {
		first = l;
		last = r;
		int a = l;
		while (a <= last) {
			if (arr[a] < x) {
				swap(first++, a++);
			} else if (arr[a] == x) {
				a++;
			} else {
				swap(a, last--);
			}
		}
	}

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
		quickSort1(0, n - 1);
		for (int i = 0; i < n - 1; i++) {
			out.print(arr[i] + " ");
		}
		out.println(arr[n - 1]);
		out.flush();
		out.close();
		br.close();
	}
}