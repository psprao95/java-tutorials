package coding.with.john.lambda;

public class LambdaDemo {

	
	public static void main(String args[]) {
		Cat myCat = new Cat();
		printThing(myCat);
		
		// with lambda
		Printable myLambdaCat = () -> {System.out.println("Meow");};
		printThing(myLambdaCat);
	}
	
	public static void printThing(Printable printable) {
		printable.print();
	}
}
