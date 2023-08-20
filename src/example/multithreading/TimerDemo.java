package example.multithreading;


import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {
	
	public static void main(String args[]) throws InterruptedException {
		//firstExample();
		secondExample();
	}
	
	
	// bad task runs forever
	public static void firstExample() {
		Timer timer = new Timer();
		TimerTask badTask = new TimerTask() {
			
			@Override
			public void run() {
				while(true) {
					try {
						Thread.sleep(1000);
					} catch(InterruptedException ie) {
						
					}
					System.out.println("Bad Task: I am running");
				}
			}
		};
		
		TimerTask goodTask = new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("Good Task: I am running");
			}
		};
		
		timer.schedule(badTask, 1000);
		timer.schedule(goodTask, 3000);
		try {
			Thread.sleep(10000);
		} catch(InterruptedException ie) {
			System.out.println(ie);
		}
		System.out.println("Main thread: Woke up....exiting");
	}
	
	// bad task throws RuntimeException
	public static void secondExample() {
		Timer timer = new Timer();
		TimerTask badTask = new TimerTask() {
			@Override
			public void run() {
				throw new RuntimeException("Error occurred");
			}
		};
		
		TimerTask goodTask = new TimerTask() {
			@Override
			public void run() {
				System.out.println("Good Task: I am running");
			}
		};
		
		timer.schedule(badTask, 1000);
		
		try {
			Thread.sleep(3000);
		} catch(InterruptedException ie) {
			
		}
		timer.schedule(goodTask, 5000);
	}

}
