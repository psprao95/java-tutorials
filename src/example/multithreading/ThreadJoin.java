package example.multithreading;

public class ThreadJoin {
	
	public static void main(String args[]) throws InterruptedException{
		Thread t = new Thread(new ExecuteMeForever());
		//t.setDaemon(true);
		t.start();
		t.join();
	}
	

}
