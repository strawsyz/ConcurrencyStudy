package straw.java8;

import java.util.Arrays;
import java.util.function.IntConsumer;
/***
 * 用循环遍历数组中的元素并打印的例子，了解函数式编程
 */
public class ArrayLambda {
	

	
	
	static int []	arr={1,2,3,4,5,6};
	/***
	 * 不用java8，简单的遍历
	 * @param args
	 */
//	public static void main(String[] args) {
//		for(int i :arr){
//			System.out.println(i);
//		}
//	}
	
	/***
	 * 使用java8中的流
	 * @param args
	 */
//	public static void main(String[] args) {
//		Arrays.stream(arr).forEach(new IntConsumer(){
//			@Override
//			public void accept(int value) {
//				System.out.println(value);
//			}
//		});
//	}
	
	/***
	 * java8的精简版一
	 * @param args
	 */
//	public static void main(String[] args) {
//		Arrays.stream(arr).forEach((final int x)->{
//			System.out.println(x);
//		});
//	}
	
	/***
	 * java8精简版二
	 * @param args
	 */
//	public static void main(String[] args) {
//		Arrays.stream(arr).forEach((x)->{
//			System.out.println(x);
//		});
//	}
	
	/***
	 * java8精简版三
	 * @param args
	 */
//	public static void main(String[] args) {
//		Arrays.stream(arr).forEach((x)->System.out.println(x));
//	}
	
	/***
	 * java8精简版四
	 * @param args
	 */
//	public static void main(String[] args) {
//		Arrays.stream(arr).forEach(System.out::println);
//	}
	
	/***
	 * 对数组中的所有元素进行两次输出，一次输到标准错误，一次输到标准输出中
	 * @param args
	 */
	public static void main(String[] args) {
		IntConsumer outprintln = System.out::println;//指向到标准输出的IntConsumer接口
		IntConsumer errprintln = System.err::println;//指向到标准错误的IntConsumer接口
		Arrays.stream(arr).forEach(outprintln.andThen(errprintln));//使用接口默认函数IntConsumer.addThen()，将来两个IntConsumer结合
		
	}
	
	/***
	 * addThen的实现
	 */
//	default IntConsumer addThen(IntConsumer after){
//		Objects.requireNonNull(after);
//		return (int t) ->{accept(t);after.accept(t);} 
//	}
	
	
	
	
	
}
