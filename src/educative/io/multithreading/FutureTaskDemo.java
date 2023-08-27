package educative.io.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;

public class FutureTaskDemo {
	
	private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

	
	public static void main(String args[]) throws InterruptedException, ExecutionException {
		FutureTask<Integer> futureTask = new FutureTask<Integer>(new Callable<Integer>() {
			@Override
			public Integer call() throws InterruptedException {
				Thread.sleep(10000);
				int sum = 0;
				for(int i = 1; i <= 100; i++) {
					sum+= i;
				}
				return sum;
			}
		});
		
		Future duplicateFuture = threadPool.submit(futureTask);
		
		while(!futureTask.isDone()) {
			Thread.sleep(1000);
			System.out.println("Waiting for sum task to complete");
		}
		
		if(futureTask.isDone() != duplicateFuture.isDone()) {
			System.out.println("This should never happen");
		}
		
		System.out.println("Result of sum task: " + futureTask.get());
		threadPool.shutdown();
	}
}
