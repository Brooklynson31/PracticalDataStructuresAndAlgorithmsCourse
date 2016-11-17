package ds.stack;

public class DoubleStack {
	
	private int top;
	private int maxSize;
	private double[] stackArray;
	
	public DoubleStack(int length){
		this.top = -1;
		this.maxSize = length;
		this.stackArray = new double[maxSize];
	}

	
	public void push(double a){
		top++;
		a = stackArray[top];
	}
	
	public double pop(){
		
		int oldtop = top; // old top needs to be na int since top is an int.
		top--; //moves top pointer to the next element in the stack
		
		return stackArray[oldtop];
	}
	public boolean isEmpty(){
	return (top == -1);
	}
	
	public boolean isFull(){
		return(maxSize-1 == top);
	}
}
