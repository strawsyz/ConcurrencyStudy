package straw.java8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
/***
 * p273
 * ��϶��CompletabledFuture
 * @author SYZPC
 *
 */
public class Combine {
	public static Integer calc (Integer para){
		return para /2;
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
//		����һ
//		CompletableFuture<Void>  fu = CompletableFuture
//				.supplyAsync(()->calc(50))
//				.thenCompose((i)->CompletableFuture.supplyAsync(()->calc(i) ))
//				.thenApply((str)->"\"" + str +"\"").thenAccept(System.out::println);
//		fu.get();
		
		
//		������
		CompletableFuture<Integer> intFuture = CompletableFuture.supplyAsync(()->calc(50));
		CompletableFuture<Integer> intFuture2 = CompletableFuture.supplyAsync(()->calc(25));
		
		CompletableFuture<Void> fu = intFuture.thenCombine(intFuture2, (i,j)->(i+j))
				.thenApply((str)->"\""+str+"\"")
				.thenAccept(System.out::println);
		fu.get();
				
	}
}
