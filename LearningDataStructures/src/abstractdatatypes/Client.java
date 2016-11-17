package abstractdatatypes;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Counter test = new Counter("test");
		test.increment();
		test.increment();
		
		System.out.println(test.getCurrentValue());
		System.out.println(test.toString());

		
	}

}
