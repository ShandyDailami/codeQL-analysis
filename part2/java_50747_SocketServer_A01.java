import java.io.*;
import java.net.*;

public class java_50747_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(); // create the socket for listening on this port number (12345 in our case). 
        
        System.out.println("Securing Socket with Broken Access Control enabled...");   
      
		// BIND SOCKET TO PORT AND SET LISTENING OPTIONS -> INSTEAD OF ALLOW ANYTHING OUTSIDE THE SERVER, WE WILL RESTRICT IT 10.53 (RFC6890).  
        server.bind(new InetSocketAddress("localhost", 12345), 60); // "`backlog" is the maximum length of the queue of pending connections to be processed by all threads within this socket address, and must not exceed what was set on a listening port in listen()'s backlog argument.
        System.out.println("Securing Socket with Broken Access Control done...");  // Print statement is added here just for demonstration purposes rather than real security-sensitive operation  	
     }   
}