package algo.insertionsort;

public class InsertionSortApp {

	public static void main(String[] args) {
		int[] array = new int[] {10,12,34,5,72,22,31,56};
		System.out.println("Before:");
		for(int i =0; i < array.length-1; i++){
			System.out.print("[" + array[i] + "]");
		}
		insertionSort(array);
		System.out.println("After:");
		for(int i =0; i < array.length-1; i++){
			System.out.print("[" + array[i] + "]");
		}	
		
		int[] array2 = new int[] {20,24,17,10,36,44,62,28};
		System.out.println("Before:");
		for(int i =0; i < array2.length-1; i++){
			System.out.print("[" + array2[i] + "]");
		}

		insertionSort2(array2);
		System.out.println("After:");
		for(int i =0; i < array2.length-1; i++){
			System.out.print("[" + array2[i] + "]");
		}	
	}
	//Assignment: Write the alogrithm for an Insertion sort

	public static void insertionSort(int[] array) {
		for(int unsortedIndex = 1; unsortedIndex < array.length-1;unsortedIndex++){ //declare index for unsorted portion of array
			int sortedIndex = unsortedIndex-1; //declare index for sorted portion of array
			if(array[unsortedIndex] < array[sortedIndex]){ //check if value in sorted portion is greater than value in unsorted portion
				for(int backwardsInsertion = sortedIndex;backwardsInsertion >= 0;backwardsInsertion--){ //iterate until you reacg beginning
					if(array[unsortedIndex] < array[backwardsInsertion]){ 
					int temp = array[backwardsInsertion];
					array[backwardsInsertion] = array[unsortedIndex];
					array[unsortedIndex] = temp;
					unsortedIndex--; //decrement index of outer loop so you can check next two values 
					}
					}
			}
			
		}
	}
	//Assignment: Write a more efficient algorithm for an Insertion Sort
	
	public static void insertionSort2(int[] array) {
		for(int i=1;i<array.length-1;i++){
			int unsortedElement = array[i]; //store value of element being brought to sorted section
			int j = i-1; //start of the sorted portion of the array
			while(j >= 0 && array[j] > unsortedElement){ //while value being added to sorted section is greater than backwards iterator
				array[j+1] = array[j]; //swap 
				j--; //move iterator back one sport
			}
			array[j +1] = unsortedElement; //insert sorted element in correct spot
		}
	}
}
