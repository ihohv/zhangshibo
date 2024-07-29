import java.io.StreamTokenizer;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;

public class MergeSort {

	public static int MAXINI = 501;

	public static int[] arr = new int[MAXINI];
	public static int[] help = new int[MAXINI];

	public static int n;

	public static void merge(int l, int r, int m) {
		int a = l;
		int b = m + 1;
		int i = l;
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
	}

	public static void mergeSort(int l, int r) {
		if (l == r) {
			return;
		}
		int m = l + ((r - l) >> 1);

		mergeSort(l, m);
		mergeSort(m + 1, r);
		merge(l, r, m);
	}

	public static void mergeSortS() {
		for (int l, r, m, step = 1; step < n; step <<= 1) {
			l = 0;
			while (l < n) {
				m = l + step - 1;
				if (m + 1 >= n) {
					break;
				}
				r = Math.min(l + (step << 1) - 1, n - 1);
				merge(l, r, m);
				l = r + 1;
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
		mergeSort(0, n - 1);
		mergeSortS();
		for (int i = 0; i < n; i++) {
			out.print(arr[i] + " ");
		}
		out.flush();
		out.close();
		br.close();
	}
}
