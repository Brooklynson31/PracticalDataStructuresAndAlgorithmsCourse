package algo.mergesort;

public class MergeSort {

	
	public void sort(int[] array) {
		sort(array,0,array.length-1); // 2nd argument is the start and the 3rd argument is the end
		
	}

	public static void sort(int[] array, int start, int end) {
		if(end <= start){ // recursive base condition --> base condition is when all values in array are placed into individual array
			return;
		}
		
			int mid = (start + end)/2; 
			sort(array, start,mid); //will start spliting array left of mid point
			sort(array,mid+1,end); //will start splitting array right of mid point
			merge2(array,start,mid,end);
		
	}


	
	private static void merge2(int[] array, int start, int mid, int end){
		int tempArray[] = new int[end-start+1]; //temp array to hold the sorted values +1 because end index only gives total length-1
		
		int leftSlot = start; //first slot of the left side of array 
		int rightSlot = mid+1; //first slot of the right side of array
		int k =0;
		
		while(leftSlot <= mid && rightSlot <= end){ //if left position exceeds middle index, then we have finished that side
													//if right position exceeds end that we have sorted that side of array
			if(array[leftSlot] < array[rightSlot]){
				tempArray[k] = array[leftSlot];
				leftSlot++;
			}
			else{
				tempArray[k] = array[rightSlot];
				rightSlot++;
			}
			k++;
		}
		
		//at this point above loop has completed, so both right and left side of the sub array can be considered sorted.
		
		if(leftSlot <= mid){ //consider the right side done being sorted, left must be sorted already
			while(leftSlot <= mid){
			tempArray[k] = array[leftSlot];
			leftSlot++;
			k++;
			}
		}
		//means left side had been sorted, so right side must  already be sorted
		else if(rightSlot <= end) {  //consider the left side done being sorted, right must be sorted already
			while(rightSlot <= end){
			tempArray[k] = array[rightSlot];
			rightSlot++;
			k++;
			}
		}
		//copy over the temp array into the appropriate slots of the inputArray
		for(int i = 0; i < tempArray.length;i++){
			array[start+i] = tempArray[i];
		}
	}

}
//public static void merge(int[] array, int start, int mid, int end) {
//int leftcenter =end-start +1; // number of indexes on left side of array
//int rightcenter = end - mid; //  number of indexes on right side of array
//
//int[] L = new int[leftcenter+1]; //left side of array with extra spot
//int[] R = new int[rightcenter+1]; // right side of array with extra spot
//
//for(int i = 0; i < leftcenter; i++){
//	L[i] = array[start +i-1]; //populate almost all of  Left Side
//}
//
//for(int j = 0; j < rightcenter; j++){
//	R[j] = array[mid+j]; // populate almost all of Right Side
//}
//L[leftcenter] = 100000000; //last slot in L
//R[rightcenter] = 100000000; //lsat slot in R
//
//
//int I = 0;
//int J = 0;
//for(int k = start; start < end;k++ ){
//	if(L[I] > R[J]){
//		array[k] = L[I];
//		I = I+1;
//	}
//	else{
//		array[k] = R[J];
//		J = J+1;
//	}
//}
//
//
//}
