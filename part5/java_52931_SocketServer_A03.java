import java.io.*;
import java.net.*;

public class java_52931_SocketServer_A03 {  
    public static void main(String[] args) throws Exception{    
        ServerSocket server = new ServerSocket();        
		// The port must be a number between 0 and 65535, inclusive: (0 <= Port <= 65535).         
	    int clientPort = 897;    // Default value. You may change it to any available unused ports in your network range    
        server.bind(new InetSocketAddress("localhost",clientPort)); 	// Binds the socket with local address and port number          		
        	System.out.println ("Server started at Port : " + clientPort);     			   									  								} }