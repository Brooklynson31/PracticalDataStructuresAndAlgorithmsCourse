package algo.linearsearch;

public class LinearSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	int[] linear = new int[] {15,10,8,6,4};
	System.out.println(linearSearch(linear, 4));

	}

	public static int linearSearch(int[] array, int value ){
		for(int i = 0; i < array.length; i++){
			if(array[i] == value){
				return i;
			}
		}
		return -1;
	}
}
