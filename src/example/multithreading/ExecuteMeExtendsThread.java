package example.multithreading;

public class ExecuteMeExtendsThread extends Thread {
	
	@Override
	public void run() {
		System.out.println("Hello World");
	}

}
