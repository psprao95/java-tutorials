package educative.io.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;

public class FutureDemo {

	private static ExecutorService threadPool = Executors.newFixedThreadPool(2);
	
	public static void main(String args[]) throws Exception {
		int n = 100;
		System.out.println("Sum of first " + n + " numbers: " + findSum(n));
		findSumWithException(n);
		threadPool.shutdown();
	}
	
	
	//example 1: future returns an integer value
	public static int findSum(final int n) throws ExecutionException, InterruptedException {
		
		// approach 1: create instance of class that implements Callable
		//Callable<Integer> myCallable = new CallableImpl(100);
		
		// approach 2: create anonymous class
		Callable<Integer> myCallable = new Callable<Integer>() {
			@Override 
			public Integer call() {
				int sum = 0;
				for(int i = 1; i <= 100; i++) {
					sum+= i;
				}
				return sum;
			}
		};
		
		Future<Integer> myFuture = threadPool.submit(myCallable);
		return myFuture.get();
	}
	
	// example 2: future throws an exception
	public static int findSumWithException(final int n) throws ExecutionException, InterruptedException {
		int result = -1;
		
		Callable<Integer> myCallable = new Callable<Integer>() {
			@Override 
			public Integer call() {
				throw new RuntimeException("Something bad happened.");
			}
		};
		
		Future<Integer> future = threadPool.submit(myCallable);
		try {
			future.get();
		} catch(ExecutionException ee) {
			System.out.println("Something went wrong. " + ee.getCause());
		}
		
		return result;
		
	}
}
