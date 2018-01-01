import java.net.*;
import java.io.*;
public class ClientReadThread extends Thread{
	Socket socket;
	public ClientReadThread(Socket socket) {
		this.socket = socket;
	}
	public void run() {
		try {
			while(true) {
				BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String Message = inFromServer.readLine();
				System.out.println(Message);
			}
		}catch(SocketException e) {
			System.out.println("服务器失联!客户端自动关闭");
			System.exit(1);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
