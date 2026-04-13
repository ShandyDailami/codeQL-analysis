import java.io.*;
import java.net.*;

public class java_43022_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(); // Create a bindable socket for the connection request from clients, non-blocking and reusable port number is automatically chosen by OS
        
        System.out.println("Secure Chat - Started");
      	System.out.println("\nWaiting connections...\n" ); 
         
        server.bind(new InetSocketAddress((InetAddress)null,0)); // Binding to any available port on the host machine in non-block mode and automatic binding of a random unused Port number by OS   (Port Auto Assignment By Operating System )   
        	System.out.println("Server listening at "+server); 	// Print out server's ip address & assigned socket id to identify it successfully with the client connection request from clients or any other way they connect, you should see this message printed in console if successful   // The below line is a simple program for testing only
          System.out.println("Server listening at Port: "+server.getLocalPort()); 	System.out.println("\nPlease make sure to secure your connection by using SSL or any other protocol which supports encryption\n");    } catch (IOException e) {   // If something goes wrong, print out the exception message and exit application
            System.err.println("Cannot open port " + server); 	System.exit(1); }}     			// Here is a simple program for testing only     void startServerThreads() throws IOException{    ServerSocket sock = (ServerSocket)server; Socket clientSock=null, secoundClientSOcket  = null;}