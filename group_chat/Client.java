import java.net.*;
import java.io.*;
public class Client {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("127.0.0.1", 8888);
		new ClientReadThread(socket).start();
		new ClientWriteThread(socket).start();
	}
}
