package algo.recursion;

public class RecursionApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reduceByOne(9));

		int[] array = new int[] {10,12,34,5,72,22,31,56};
		int i = 0; //index position within array where we are currently at during search process. 
		System.out.println(recursiveLinearSearch(array, i, 31));
		
		int[] array2 = new int[] {5,10,12,22,31,34,56,72};
		System.out.println(recursiveBinarySearch(array2,0,array2.length-1,22));

	}
	
	//Write a recursive algorithm
	public static int reduceByOne(int n){
		int numOfRecursiveCalls = n;
		if(n >= 0){
			reduceByOne(n-1);
		}
		return numOfRecursiveCalls;
	}	
	
	//Assignment: Write an algorithm for a Linear Search Using Recursion
	public static int recursiveLinearSearch(int array[], int i, int value ){
		if( i > array.length-1){ //out of bounds check
			return -1;
		}
		else if( array[i] == value){
			return i;}
		else{
			System.out.println("Index at: " +i);
			return recursiveLinearSearch(array, i+1, value); //will start at first index position and move one over in each iteration
		}
	}
	
	//Assignment: Write an algorithm for a Binary Search Using Recursion
	public static int recursiveBinarySearch(int[] array, int low, int high, int value){
		System.out.println("[" + low + "......" + high + "]");
		if( low > high){
			return -1;
		}
		else {
			int mid = (low + high)/2;
			if (array[mid] == value)
				return mid;
			else if ( value <  array[mid]){
				return recursiveBinarySearch(array, low, mid-1,value);
			}
			else {
				return recursiveBinarySearch(array, mid+1, high,value);
			}
		}
	}


}
