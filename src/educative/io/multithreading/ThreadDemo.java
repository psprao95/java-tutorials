package educative.io.multithreading;

import java.lang.Runnable;

public class ThreadDemo {
	
	public static void main(String args[]) {
		
		
		/*Thread t = new Thread(new Runnable() {
			public void run() {
				System.out.println("Hello World");
			}
		});*/
		
		//Thread t = new Thread(new ExecuteMe());
		
		Thread t = new ExecuteMeExtendsThread();
		t.start();
		
		

		
	}
	

}
