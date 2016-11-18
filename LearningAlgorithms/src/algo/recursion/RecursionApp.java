package algo.recursion;

public class RecursionApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reduceByOne(9));

		
	}
	
	public static int reduceByOne(int n){
		int numOfRecursiveCalls = n;
		if(n >= 0){
			reduceByOne(n-1);
		}
		return numOfRecursiveCalls;
	}	

}
