package educative.io.multithreading;

import java.util.concurrent.Executor;

public class DumbExecutor implements Executor {
	
	@Override
	public void execute(Runnable runnable) {
		Thread t = new Thread(runnable);
		t.start();
	}

}
