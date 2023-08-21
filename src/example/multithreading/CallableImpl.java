package example.multithreading;

import java.util.concurrent.Callable;

public class CallableImpl implements Callable<Integer> {
	
	int n;
	
	CallableImpl(int n){
		this.n = n;
	}

	@Override 
	public Integer call() {
		int sum = 0;
		for(int i = 0; i < 100; i++) {
			sum+= i;
		}
		return sum;
	}
	
	
}
