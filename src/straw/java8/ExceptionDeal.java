package straw.java8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
/***
 * p272
 * CompletableFuture 中的异常处理
 * @author SYZPC
 *
 */
public class ExceptionDeal {
	public static Integer calc (Integer para){
		return para /0;
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<Void>  fu = CompletableFuture
				.supplyAsync(()->calc(50))
				.exceptionally(ex->{
					System.out.println(ex.toString());
					return 0;
				})
				.thenApply((i)->Integer.toString(i))
				.thenApply((str)->"\""+str+"\"")
				.thenAccept(System.out::println);
		fu.get();
	}
}	
