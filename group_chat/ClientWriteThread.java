import java.net.*;
import java.util.Scanner;
import java.io.*;
public class ClientWriteThread extends Thread{
	Socket socket;
	public ClientWriteThread(Socket socket) {
		this.socket = socket;
	}
	public void run() {
		try {
			Scanner sin = new Scanner(System.in);
			while(true) {
				String Message = sin.nextLine();
				PrintWriter p = new PrintWriter(socket.getOutputStream());
				p.println(socket.getInetAddress().getHostAddress()+":"+Message);
				p.flush();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
