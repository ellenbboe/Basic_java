//in the client ,i need a socketList to know the number of the client

import java.util.ArrayList;
import java.io.*;
import java.net.*;
public class Server {
	private static ArrayList<Socket> socketlist = new ArrayList<Socket>();
	//private static ServerSocket serversocket;
	public static void main(String[] args) throws IOException {
		ServerSocket serversocket = new ServerSocket(8888);
		while(true) {
			Socket socket = serversocket.accept();
			System.out.println("连接成功");
			socketlist.add(socket);
			new Thread(new ServerThread(socket,socketlist)).start();//start the thread of the socket
		}
	}
	
}
