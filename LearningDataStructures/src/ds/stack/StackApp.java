package ds.stack;


public class StackApp {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	
	/* First stack assignment--> makes a stack */
		Stack theStack = new Stack(3);
		theStack.push(20);
		theStack.push(40);
		theStack.push(60);
		theStack.push(80);
		
		while(!theStack.isEmpty()){
			long value = theStack.pop();
			System.out.println(value);
		}
		
	
		
	/* second stack assignment--> reverse a string using a stack */

		System.out.println(reverseString("racecar"));
		System.out.println("boob".equals(reverseString("racecar")));
	
	 	
		
		

	}
	
	public static String reverseString(String str) throws Exception{
		CharStack word = new CharStack(str);
			for(int i = 0; i < str.length();i++){
			word.push(str.charAt(i)); //pushes character at string index into stack
		}
		String reverseword = "";
		while(!word.isEmpty()){
			reverseword += word.pop();
		}		
		return reverseword ;
	}

}
