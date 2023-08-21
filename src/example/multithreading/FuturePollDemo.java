package example.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;

public class FuturePollDemo {
	
	private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

	public static void main(String args[]) throws InterruptedException {
		statusPollAndCancel(100);
		threadPool.shutdown();
	}
	
	private static int statusPollAndCancel(final int n) throws InterruptedException {
		int result = -1;
		
		Callable<Integer> sumTask = new Callable<Integer>() {
			
			@Override
			public Integer call() throws InterruptedException {
				System.out.println("Sum Task: going to sleep for ten seconds");
				Thread.sleep(10000);
				System.out.println("Sum Task: woke up!");
				int sum = 0;
				for(int i = 0; i <=n; i++){
				sum += i;
				}
				return sum;
			}
		};
		
		Callable<Void> randomTask = new Callable<Void>() {
			
			@Override
			public Void call() throws InterruptedException {
				System.out.println("Random Task: going to sleep for an hour");
				Thread.sleep(3600*1000);
				return null;
			}
		};
		
		Future<Integer> f1 = threadPool.submit(sumTask);
		Future<Void> f2 = threadPool.submit(randomTask);
		
		try {
			System.out.println("Main thread: going to sleep for two seconds");
			Thread.sleep(2000);
			System.out.println("Main thread: woke up!");
			f2.cancel(true);
			while(!f1.isDone()) {
				Thread.sleep(1000);
				System.out.println("Waiting for sum task to complete");
			}
			result = f1.get();
			System.out.println("SumTask result: " + result);
		} catch(ExecutionException ee) {
			System.out.println("Something went wrong. " + ee.getCause());
		}
		
		System.out.println("Is random task cancelled: " + f2.isCancelled());
		return result;
	}
}
