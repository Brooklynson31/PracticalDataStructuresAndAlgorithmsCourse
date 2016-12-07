package algo.mergesort;

public class MergeSort {
	 public static int tempArray[];
	
	public void sort(int[] array) {
		sort(array,0,array.length-1); // 2nd argument is the start and the 3rd argument is the end
		
		
	}

	public static void sort(int[] array, int start, int end) {
		if(end <= start){ // recursive base condition --> base condition is when all values in array are placed into individual array
			return; //were done traversing the array
		}
		tempArray = new int [array.length];
			int mid = (start + end)/2; 
			sort(array, start,mid); //will start spliting array left of mid point
			sort(array,mid+1,end); //will start splitting array right of mid point
			mergeInPlace(array,start,mid,end);
		
	}


	
	private static void merge(int[] array, int start, int mid, int end){
		int tempArray[] = new int[end-start+1]; //temp array to hold the sorted values +1 because end index only gives total length-1
		
		int leftSlot = start; //first slot of the left side of array 
		int rightSlot = mid+1; //first slot of the right side of array
		int k =0; //index counter for temporary sorted array
		
		while(leftSlot <= mid && rightSlot <= end){ //if left position exceeds middle index, then we have finished that side
													//if right position exceeds end that we have sorted that side of array
			
			
			if(array[leftSlot] < array[rightSlot]){ //check if the value of the index position on the left side of array is less than index position on right side
				tempArray[k] = array[leftSlot]; //assign value on the left to the sorted temp array
				leftSlot++; //move index position on left after placement
			}
			else{
				tempArray[k] = array[rightSlot]; //else assign value on the right to the sorted temp array
				rightSlot++; // move index position on right after placement
			}
			k++; //move index position of temp array after placement from either side
		}
		
		//at this point above loop has completed, so both right and left side of the temp array can be considered sorted.
		
		if(leftSlot <= mid){ //consider the right side done being sorted, left must be sorted already
			while(leftSlot <= mid){ //until you have place every value on left side
			tempArray[k] = array[leftSlot];  //place in sorted array
			leftSlot++;
			k++; //increment both pointers
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
	
//private static int tempArray[];//an array used for merging
//To use the mergeInPlace() method you'll need to intialize as
//shown on the next line inside of the wrapper sort() method
//tempArray = new int [array.length];

public static void mergeInPlace(int inputArray[], int start, int mid, int end){
	int i = start;
	int j = mid+1;
	
	for(int k = 0; k <= end;k++){
		tempArray[k] = inputArray[k];
	}
	
	for (int k = start; k <= end; k++){
		if(i > mid){
			inputArray[k] = tempArray[j];
			j++;
		} else if(j > end){
			inputArray[k] = tempArray[i];
			i++;
		} else if (tempArray[j] < tempArray[i]){
			inputArray[k] = tempArray[j];
			j++;
		}
		else {
			inputArray[k] = tempArray[i];
			i++;
		}
		
	}
}


}

