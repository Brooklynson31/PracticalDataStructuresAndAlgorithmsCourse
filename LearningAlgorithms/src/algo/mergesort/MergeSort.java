package algo.mergesort;

public class MergeSort {

	
	public void sort(int[] array) {
		sort(array,0,array.length-1); // 2nd argument is the start and the 3rd argument is the end
		
	}

	public static void sort(int[] array, int start, int end) {
		if(start < end){ // recursive base condition --> base condition is when all values in array are placed into individual array
			
			int mid = (start + end) / 2; 
			sort(array, start,mid); //will start spliting array left of mid point
			sort(array,mid+1,end); //will start splitting array right of mid point
			merge(array, start, mid, end); //once base case if met, will begin to merge 2 sorted arrays
		}
		
	}

	private static void merge(int[] array, int start, int mid, int end) {
		
		
	}

}
