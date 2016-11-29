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
	}

	public static void insertionSort(int[] array) {

		
		for(int unsortedIndex = 1; unsortedIndex < array.length-1;unsortedIndex++){
			int sortedIndex = unsortedIndex-1;
			if(array[unsortedIndex] < array[sortedIndex]){
					for(int backwardsInsertion = sortedIndex;backwardsInsertion >= 0;backwardsInsertion--){
					int temp = array[backwardsInsertion];
					array[backwardsInsertion] = array[unsortedIndex];
					array[unsortedIndex] = temp;
					unsortedIndex--;
					}
			}
			
		}
	}
}
