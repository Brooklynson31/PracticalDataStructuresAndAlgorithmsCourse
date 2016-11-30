package algo.mergesort;

public class MergeSortApp {

	//Assignment: Write an algorithm for the "Merge" portion of the MErge Sort
	public static void main(String[] args) {

		int[] array = {9 , 7,3,1,6,3,2,6,8,9,2,3,0};
		MergeSort sorter = new MergeSort();
		
		sorter.sort(array);
	
		for(int i=0; i < array.length;i++){
			System.out.println(array[i]);	
		}
	
	}

}
