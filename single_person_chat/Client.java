
import java.net.*;
import java.io.*;

public class Client {
	public static void main(String[] args) throws IOException {
		Socket Client = null;
		PrintWriter out2Server = null;
		BufferedReader inFromServer = null;
		try {
			Client = new Socket("localhost", 4444);
			out2Server = new PrintWriter(Client.getOutputStream(),true);
			inFromServer = new BufferedReader(new InputStreamReader(Client.getInputStream()));
			System.out.println("¿Í»§¶ËÆô¶¯!");
			
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
	String fromu,froms;
	boolean ubye=false,sbye=false;
	
	while(true) {
		if(ubye == false) {
			System.out.print("Clinet say:");
			fromu = sin.readLine();
			out2Server.println(fromu);
			if(fromu.compareToIgnoreCase("bye") == 0) {
				ubye = true;
			}
		}
		if(sbye == false) {
			System.out.print("Server say:");
			froms = inFromServer.readLine();
			System.out.println(froms);
			
			if(froms.compareToIgnoreCase("bye") == 0) {
				sbye = true;
			}
		}
		if(sbye== true &&ubye == true) {
			break;
		}
		
	}
	sin.close();
	Client.close();
	inFromServer.close();
	out2Server.close();
	}
}
