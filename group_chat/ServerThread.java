import java.util.ArrayList;
import java.io.*;
import java.net.*;
//转发socket的输入流
public class ServerThread extends Thread{
	Socket socket;
	ArrayList<Socket> socketlist;
	public ServerThread(Socket socket, ArrayList<Socket> socketlist) {
		this.socket = socket;
		this.socketlist = socketlist;
	}
	public void run(){
		try {
			while(true) {
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String Message = inFromClient.readLine();
			for(Socket socket:socketlist) {
				PrintWriter p = new PrintWriter(socket.getOutputStream());
				p.println(Message);
				p.flush();
			}
		}
		}catch (SocketException e1) {
			
			System.out.println("一台客户端断开连接!");
		} 
		catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
}
