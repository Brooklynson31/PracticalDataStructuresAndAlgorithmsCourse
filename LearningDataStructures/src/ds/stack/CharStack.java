package ds.stack;

public class CharStack {
	
	private int top; //index position of last item placed on top of the stack
	private char[] stackArray;
	private int maxSize;
	
	public CharStack(String wordSize){
		this.maxSize = wordSize.length();
		this.stackArray =  wordSize.toCharArray(); // or new char[maxSize];
		this.top = -1;
		
	}
	
	public void push(char c) throws Exception{
		if(isFull()){
			throw new Exception("Stack is full");
		}
		top++;
		stackArray[top] = c;
	}
	
	public char pop() throws Exception{
		if(isEmpty()){
		throw new Exception("Stack is empty!");	
		}
		
		int oldtop = top;
		top--;
		
		return stackArray[oldtop];
	}
	
	public char peek(){
		return stackArray[top];
	}
	public boolean isEmpty(){
		return (top == -1);
	}
	
	public boolean isFull(){
		return (maxSize-1 == top);
	}

}
