package example.multithreading;

public class ThreadInterruption {
	
	public static void main(String args[]) throws InterruptedException {
		Thread t = new Thread(new ExecuteMeForever());
		t.start();
		System.out.println("Main thread sleeping at " + +System.currentTimeMillis() / 1000);
		Thread.sleep(5000);
		t.interrupt();
		System.out.println("Main thread exiting at " + +System.currentTimeMillis() / 1000);
	}

}
