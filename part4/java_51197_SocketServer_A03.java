import java.io.*;
import java.net.*;

public class java_51197_SocketServer_A03 {  
    public static void main(String args[]) throws Exception{ 
        ServerSocket server = new ServerSocket(6457); // Port number should be changed according to your application requirements, port numbers below 1024 are privileged and must not be used. Below is a basic example of how the program may look when runned by you: `java SocketServer`
        System.out.println("Waiting for client on port " + server.getLocalPort()+"...");   // This will print out which IP address it's listenning to and what its listening Port 6457 is chosen here as an example but should match the application requirements or be changed according your needs
        while(true){   
            Socket socket = server.accept();     // Accept connection from client     
             System.out.println("Connected: " +socket.getRemoteSocketAddress());   /* Prints out what IP address and port number the current connected user has, this will print to console */ 
              Thread thread =  new SocketThread(socket);    /// Create a separate handler for each client connection     // This code is highly vulnerable if no check in place against A03_Injection. No sanitization or input validation are done here and only raw socket programming, use of streams etc should be made safe
              thread.start();  }   }}// close bracket}}))))) */