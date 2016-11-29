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
//		for(int i = 1; i < array.length-1;i++){
//			int numberToBeSorted = i; 
//			int sortedIndex = i-1;
//			if(array[numberToBeSorted] < array[sortedIndex]){
//				
//				for(int backwardsInsertion = sortedIndex;backwardsInsertion >= 0;backwardsInsertion--){
//					if(array[numberToBeSorted] < array[backwardsInsertion]){
//					int temp = array[backwardsInsertion];
//					array[backwardsInsertion] = array[numberToBeSorted];
//					array[numberToBeSorted] = temp;
//					numberToBeSorted--;
//					}
//				}
//			}
//			
//		}
		
		for(int numberToBeSorted = 1; numberToBeSorted < array.length-1;numberToBeSorted++){
			int sortedIndex = numberToBeSorted-1;
			if(array[numberToBeSorted] < array[sortedIndex]){
					for(int backwardsInsertion = sortedIndex;backwardsInsertion >= 0;backwardsInsertion--){
					int temp = array[backwardsInsertion];
					array[backwardsInsertion] = array[numberToBeSorted];
					array[numberToBeSorted] = temp;
					numberToBeSorted--;
					}
			}
			
		}
	}
}
