package straw.java8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AskThread2 {
	public static Integer calc (Integer para){
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		return para*para;
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		final CompletableFuture<Integer> future = CompletableFuture.supplyAsync(()->calc(50));
		System.out.println(future.get());
	}
}
