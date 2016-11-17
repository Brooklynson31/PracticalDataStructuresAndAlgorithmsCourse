package abstractdatatypes;

public class Counter {
	
	

	private  int counter;
	private String stringcounter;
	
	public Counter(String str){
		this.counter = 0;
		this.stringcounter = str;
	}
	
	public void increment(){
		counter++;
	}
	
	public int getCurrentValue(){
		return counter;
	}
	
	@Override
	public String toString() {
		return stringcounter + " = " + getCurrentValue();
	}

}
