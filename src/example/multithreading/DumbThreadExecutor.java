package example.multithreading;

public class DumbThreadExecutor {
	
	public static void main(String args[]) {
		DumbExecutor dumbExecutor = new DumbExecutor();
		dumbExecutor.execute(new ExecuteMe());
	}

}
