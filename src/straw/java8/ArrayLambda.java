package straw.java8;

import java.util.Arrays;
import java.util.function.IntConsumer;
/***
 * ��ѭ�����������е�Ԫ�ز���ӡ�����ӣ��˽⺯��ʽ���
 */
public class ArrayLambda {
	

	
	
	static int []	arr={1,2,3,4,5,6};
	/***
	 * ����java8���򵥵ı���
	 * @param args
	 */
//	public static void main(String[] args) {
//		for(int i :arr){
//			System.out.println(i);
//		}
//	}
	
	/***
	 * ʹ��java8�е���
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
	 * java8�ľ����һ
	 * @param args
	 */
//	public static void main(String[] args) {
//		Arrays.stream(arr).forEach((final int x)->{
//			System.out.println(x);
//		});
//	}
	
	/***
	 * java8������
	 * @param args
	 */
//	public static void main(String[] args) {
//		Arrays.stream(arr).forEach((x)->{
//			System.out.println(x);
//		});
//	}
	
	/***
	 * java8�������
	 * @param args
	 */
//	public static void main(String[] args) {
//		Arrays.stream(arr).forEach((x)->System.out.println(x));
//	}
	
	/***
	 * java8�������
	 * @param args
	 */
//	public static void main(String[] args) {
//		Arrays.stream(arr).forEach(System.out::println);
//	}
	
	/***
	 * �������е�����Ԫ�ؽ������������һ���䵽��׼����һ���䵽��׼�����
	 * @param args
	 */
	public static void main(String[] args) {
		IntConsumer outprintln = System.out::println;//ָ�򵽱�׼�����IntConsumer�ӿ�
		IntConsumer errprintln = System.err::println;//ָ�򵽱�׼�����IntConsumer�ӿ�
		Arrays.stream(arr).forEach(outprintln.andThen(errprintln));//ʹ�ýӿ�Ĭ�Ϻ���IntConsumer.addThen()����������IntConsumer���
		
	}
	
	/***
	 * addThen��ʵ��
	 */
//	default IntConsumer addThen(IntConsumer after){
//		Objects.requireNonNull(after);
//		return (int t) ->{accept(t);after.accept(t);} 
//	}
	
	
	
	
	
}
