package algo.binarysearch;


public class BinarySearchApp {

	public static void main(String[] args) {

		
	int[] array = new int[] {1,3,5,7,11,16,20,25,32,42};
	
	System.out.println(binarySearch(array, 3));
		
	}
	
	
	public static int binarySearch(int[] array, int value){
		int r = array.length-1; //last index of the array
		int p = 0;			//first index of array
		int q;	
		while(p <= r){
			q = (p+r)/2; //middle index of array
			if(array[q] == value)
				return array[q];
			if(array[q] > value) //if middle of array is greater than value
				r = q-1; 
			else{
				p = q+1; 
			}
		}
		return -1;
	}
}
