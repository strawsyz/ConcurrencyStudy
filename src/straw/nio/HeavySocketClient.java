/**
 * 
 */
package straw.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.LockSupport;

/**
 * @author SYZPC
 *
 */
public class HeavySocketClient {
	
	private static ExecutorService tp= Executors.newCachedThreadPool();
	private static final int sleeptime = 1000*1000*1000;
	public static class EchoClient implements Runnable{
		
		public void run() {
		Socket client = null;
		PrintWriter writer = null;
		BufferedReader reader =null;
		
		try {
			client = new Socket();
			client.connect(new InetSocketAddress("localhost",8000));
			writer= new PrintWriter(client.getOutputStream(), true);
			writer.print("H");
			LockSupport.parkNanos(sleeptime);
			writer.print("e");
			LockSupport.parkNanos(sleeptime);
			writer.print("l");
			LockSupport.parkNanos(sleeptime);
			writer.print("l");
			LockSupport.parkNanos(sleeptime);
			writer.print("o");
			LockSupport.parkNanos(sleeptime);
			writer.print("!");
			LockSupport.parkNanos(sleeptime);
			writer.println();
			writer.flush();
			
			reader = new BufferedReader(new InputStreamReader (client.getInputStream()));
			System.out.println("from server :" +reader.readLine());
//			System.out.println("from server :" );
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}catch(IOException e1){
			e1.printStackTrace();
		}finally{
			try{
				
			if(reader!=null)reader.close();
			if(writer!=null)writer.close();
			if(client!=null)client.close();
			}catch (IOException e) {
			}
		}
		
	
		}
		
		
	}
	public static void main(String[] args) {
		EchoClient ec = new EchoClient();
		for (int i = 0; i < 10; i++) {
			tp.execute(ec);
		}
	}
}
