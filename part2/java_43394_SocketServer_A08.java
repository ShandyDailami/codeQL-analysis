import java.io.*;
import java.net.*;

public class java_43394_SocketServer_A08 {  
    public static void main(String args[]) throws IOException{    
        // Create a server socket at port 12345 (any available port in the range above).     
        ServerSocket welcomeSocket = new ServerSocket(60);      
        
        while(true){            
            Socket connectionSocket = welcomeSocket.accept();              System.out.println("New client connected");               // Waiting for a Client to connect               
           int received;                    ConnectionOutputStream conOut=new   BufferedConnectionInputStream (connectionSocket).getStream());    receiveIntegrity(received);                   }       if(!welcomeSocket.isClosed()) welcomeSocket.close();  }}      private static void     receiveIntegrity(){          // Integralty check implementation not shown, it's a skeleton of   how you would implement your own integrity checks        System..println("Received: "+received);}}