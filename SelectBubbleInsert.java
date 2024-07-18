public class SelectBubbleInsert {
	
	public static void swap(int[] arr, int i, int j) {
		int count = arr[i];
		arr[i] = arr[j];
		arr[j] = count;
	}
	
	public static void selectSort(int[] arr) {
		if(arr == null || arr.length < 2) {
			return;
		}

		for(int minIndex, i=0;i<arr.length-1;i++) {
			minIndex = i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]<arr[i]) {
					minIndex = j;
				}
			}
			swap(arr,i,minIndex);
		}
	}
	
	public static void bubbleSort(int[] arr) {
		if(arr == null || arr.length < 2) {
			return;
		}
		
		for(int end=arr.length-1;end>0;end--) {
			for(int i=0;i<end;i++) {
				if(arr[i]>arr[i+1]) {
					swap(arr,i,i+1);
				}
			}
		}
	}
	
	public static void insertSort(int[] arr) {
		if(arr == null || arr.length < 2) {
			return;
		}
		
		for(int i=1;i<arr.length;i++) {
			for(int j=i-1;j>=0 && arr[j]>arr[j+1];j--) {
				swap(arr,j,j+1);
			}
		}
	}
	
	public static void main(String[] args) {
		
	}
}
