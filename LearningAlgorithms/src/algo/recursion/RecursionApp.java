package algo.recursion;

public class RecursionApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reduceByOne(9));

		int[] array = new int[] {10,12,34,5,72,22,31,56};
		int i = 0; //index where recursive calls will start
		System.out.println(recursiveLinearSearch(array, i, 31));
	}
	
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
			return recursiveLinearSearch(array, i+1, value); //will start at first index position and move one over in each iteration
		}
	}

}
