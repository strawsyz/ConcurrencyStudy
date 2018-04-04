package straw.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		Socket client = null;
		PrintWriter writer = null;
		BufferedReader reader =null;
		try {
			client = new Socket();
			client.connect(new InetSocketAddress("localhost",8000));
			writer = new PrintWriter(client.getOutputStream(),true);
			writer.print("Hello!");
			writer.flush();
			
			reader = new BufferedReader(new InputStreamReader (client.getInputStream()));
			System.out.println("from server :" +reader.readLine());
		} catch (UnknownHostException e) {
			// TODO: handle exception
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