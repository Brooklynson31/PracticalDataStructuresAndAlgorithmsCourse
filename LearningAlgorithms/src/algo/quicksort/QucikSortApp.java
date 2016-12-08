package algo.quicksort;

public class QucikSortApp {

	//Assignment: Write a algorithm for a Quick Sort
	public static void main(String[] args) {

		int[] array = {12,81, 74, 43, 1098, 0, 8, 92, 17, 754, 912, 0, 6, 4};
		quickSort(array,0,array.length-1);
		
		for(int i = 0; i <= array.length-1;i++){
			System.out.print("[" + array[i] + "]");
		}

	}

	public static void quickSort(int[] array, int start, int end){
		if(start < end){
			int pp = partition(array,start,end); //pp is the index of the  correctly placed pivot value -->partition point
			quickSort(array,start, pp-1); //sorts left half of given range
			quickSort(array,pp+1,end); //sorts right half given range
		}
	}

	private static int partition(int[] array, int start, int end) {
		int pivot = array[end];
		int i = start-1; //in the first iteration, i starts from -1
		for(int j = start; j < end; j++){
			if(array[j] <= pivot){
				i++;
				int temp = array[i]; //swap the values 
				array[i] = array[j];
				array[j] = temp;
			}
		}
		int temp = array[end];  //swap to place pivot value in the correct slot
		array[end] = array[i+1];
		array[i+1] = temp; //place pivot value in the correct position
		return i+1;
	}
	
}
