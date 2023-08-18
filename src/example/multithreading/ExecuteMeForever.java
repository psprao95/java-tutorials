package example.multithreading;

public class ExecuteMeForever implements Runnable {
	
	@Override
	public void run() {
		while(true) {
			System.out.println("Say hello again and again!");
			try {
				Thread.sleep(10000);
				System.out.println("woke up");
			} catch(InterruptedException ie) {
				System.out.println("I was interrupted at " + +System.currentTimeMillis()/1000);
			}
		}
	}

}
