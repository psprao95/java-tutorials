package example.main;

public class FirstJavaExample {
	
	public static void main(String args[]) {
		System.out.println("Hello World");
		int addResult = addTwoNumbers(20, 30);
		System.out.println(addResult);
	}
	
	public static int addTwoNumbers(int a, int b) {
		return a + b;
	}

}
