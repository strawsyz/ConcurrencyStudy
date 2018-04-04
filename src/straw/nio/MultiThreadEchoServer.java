package straw.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/***
 * p231
 * 基于Socket的服务端的多线程模式
 * @author SYZPC
 *
 */
public class MultiThreadEchoServer {
	private static ExecutorService tp = Executors.newCachedThreadPool();//用线程池处理连接
	
	static class HandleMsg implements Runnable{//读取Socket的内容并返回
		Socket clientSocket ;
		
		public HandleMsg(Socket clientSocket){
			this.clientSocket=clientSocket;
		}
		@Override
		public void run() {

			BufferedReader is =null;
			PrintWriter os = null;
			try {
				is = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				os = new PrintWriter(clientSocket.getOutputStream(),true);
				//从inputstream中读取客户端发送的数据
				String inputLine = null;
				long b = System.currentTimeMillis();
				while ((inputLine = is.readLine())!=null){
					os.println(inputLine);
				}
				long  e = System.currentTimeMillis();
				System.out.println("speed time is :"+(e-b)+"ms");//计算处理一次客户端请求所花费的时间
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					if(is!=null){
						is.close();
					}
					if(os!=null)os.close();
					clientSocket.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	public static void main(String[] args) {//监听8000端口。等待连接
		ServerSocket echoServer = null;
		Socket clientSocket =null;
		try {
			echoServer = new ServerSocket(8000);
		} catch (Exception e) {
			System.out.println(e);
		}
		while (true){
			try {
				clientSocket = echoServer.accept();
				System.out.println(clientSocket.getRemoteSocketAddress()+" connect!");
				tp.execute(new HandleMsg(clientSocket));
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}
