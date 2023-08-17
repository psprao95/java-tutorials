package example.multithreading;

public class ExecuteMeForever implements Runnable {
	
	@Override
	public void run() {
		while(true) {
			System.out.println("Say hello again and again!");
			try {
				Thread.sleep(5000);
				System.out.println("woke up");
			} catch(InterruptedException ie) {
				
			}
		}
	}

}
