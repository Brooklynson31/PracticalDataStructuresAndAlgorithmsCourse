package ds.stack;

public class Stack {

	private int maxSize;
	private long[] stackArray;
	private int top; //index position of last item placed on top of the stack
	
	//implement push and pop using throws declaration and catch
	
	public Stack(int size){
		this.maxSize = size;
		this.stackArray = new long[maxSize];
		this.top = -1;
	}
	
	public void push(long j) throws Exception {
		
		if(isFull()){

			throw new Exception("Stack is full");
		}
		else{
			top++;
			stackArray[top] = j;
		}
	
}
	
	public long pop() throws Exception{
			if(isEmpty()){
				throw new Exception("Stack is empty!");
			}
			else {
			int old_top = top;
			top--;
			return stackArray[old_top];
		}
	
	
	
	}
	
	public long peek(){
		return stackArray[top];
	}
	
	public boolean isEmpty(){
		return (top == -1);
	}
	
	public boolean isFull(){
		return (maxSize-1 == top);
	}
	
}
