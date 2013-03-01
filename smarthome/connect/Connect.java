package com.yufei.smarthome.connect;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Connect {
	
	private String IP;
	private int port;
	private PrintWriter os;
	private Socket socket;
	private String client_name;
	
	public Connect(String IP,int port,String client_name){
		this.IP = IP;
		this.port = port;
		this.client_name = client_name;
		// If Object create,socket will create
		this.connect(); 
	}
	
	public boolean connect(){
		try{
			// Connect to Server
			socket = new Socket(IP,port);
			os = new PrintWriter(socket.getOutputStream());
			// Send Client Name
			os.println(client_name);
			os.flush();
			return true;
		}
		catch(IOException e){
			return false;
		}
	}
	
	public void send_String_Data(String message){
		os.println(message);
		os.flush();
	}
	public void disconnect() throws IOException{
		os.println("close");
		os.flush();
		// Close socket
		os.close();
		socket.close();
	}
}
