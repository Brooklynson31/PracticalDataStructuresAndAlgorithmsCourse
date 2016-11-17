package ds.queue;

public class Queue {
	private int maxSize;
	private long[] queueArray;
	private int front;
	private int rear;
	private int nitems;
	
	public Queue(int size){
		this.maxSize = size;
		this.queueArray = new long[maxSize];
		this.front = 0;
		this.rear = -1;
		this.nitems = 0;
	}
	
	public void insert(long j){
		rear++;
		queueArray[rear] = j;
				nitems++;

	}
	
	public void view(){
		System.out.println("[");
		for(int i = 0; i< queueArray.length; i++){
			System.out.println(queueArray[i] + " ");
		}
		System.out.println("]");
	}
	
	public long remove(){ //removes from the front of the queue
		long temp = queueArray[front];
		front++; //increment because it will point to the next thing in the line
		
		if(front ==maxSize){ //if front has reached maxSize index of array
			front = 0; //we can set front back to the 0th index so that we can use entire array aggain
		}
		nitems--;
		
		return temp;
	}
	
	public long peekFront(){
		return queueArray[front];
	}
	
	public boolean isFull(){
		return (nitems == maxSize);
	}
	
	public boolean isEmpty(){
		return (nitems == 0);
	}
	

}
