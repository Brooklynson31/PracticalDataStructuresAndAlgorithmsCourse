package algo.selectionsort;

public class SelectionSortApp {

	public static void main(String[] args) {
		int[] array = new int[] {10,12,34,5,72,22,31,56};
		System.out.println("Before:");
		for(int i =0; i < array.length-1; i++){
			System.out.print("[" + array[i] + "]");
		}
		selectionSort(array);
		System.out.println("After:");
		for(int i =0; i < array.length-1; i++){
			System.out.print("[" + array[i] + "]");
		}		
	}

	//Assignment: Write an algorithm for a selectionSort
	public static int[] selectionSort(int[] array) {
		
	
		for(int smallestNum = 0; smallestNum < array.length-2;smallestNum++){ //continue until you reach second last value
			int swapNumber = smallestNum+1; //iterator that will check unsorted part of array starting after index
			while(swapNumber < array.length-1){
				if( array[smallestNum] > array[swapNumber]){ //compare unsorted values to index
					int newSmallest = array[swapNumber]; // store new smallest value
					array[swapNumber] = array[smallestNum]; 
					array[smallestNum] = newSmallest; //swap values
				}
				swapNumber++; // move index over one spot
			}
		}
		
		
		return array;
	}
	

}
