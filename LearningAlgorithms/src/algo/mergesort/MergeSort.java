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
		int leftcenter =mid-start +1; // number of indexes on left side of array
		int rightcenter = end - mid; //  number of indexes on right side of array
		
		int[] L = new int[leftcenter+1]; //left side of array with extra spot
		int[] R = new int[rightcenter+1]; // right side of array with extra spot
		
		for(int i = 0; i < leftcenter; i++){
			L[i] = array[start +i-1]; //populate almost all of  Left Side
		}
		
		for(int j = 0; j < rightcenter; j++){
			R[j] = array[mid+j]; // populate almost all of Right Side
		}
		L[leftcenter+1] = 100000000; //last slot in L
		R[rightcenter+1] = 100000000; //lsat slot in R
		
		
		int I = 0;
		int J = 0;
		for(int k = 0; k < end;k++ ){
			if(L[I] > R[J]){
				array[k] = L[I];
				I = I+1;
			}
			else{
				array[k] = R[J];
				J = J+1;
			}
		}
		
		
	}

}
