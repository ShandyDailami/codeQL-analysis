import java.io.*;
import java.net.*;

public class java_52208_SocketServer_A03 {
    public static void main(String[] args) throws IOException{
        // Create a server socket and bind it to port 12345 on all available interfaces (localhost).
        ServerSocket server = new ServerSocket();  
	server.bind(new InetAddress.getByName("0"), 12345);   
        
	// Run the loop indefinitely, listening for client connections and handling them as they arrive...
	for (;;) {         
            Socket sock = server.accept();   // accept a connection to this socket	    
	    System.out.println("Accepted new connection from " +sock.getRemoteSocketAddress());   	       
            
        } 
	}		      			     									                  	 	     
}          							                                       								                                )                      (                                                           );   .                              ,