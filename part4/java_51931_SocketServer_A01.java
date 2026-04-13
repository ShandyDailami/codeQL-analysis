import java.io.*;
import java.net.*;

public class java_51931_SocketServer_A01 {  
    public static void main(String[] args) throws IOException{  // e, f         
        ServerSocket server = new ServerSocket(12345);      
         System.out.println("Waiting for client connection on port: "+server.getLocalPort());     
          
               while (true){              Socket socketToClient = server.accept();   // a         
            Thread thread=new Thread(new ClientHandlerSocket(socketToClient));  // b         Handles the individual clients connections, not listening to multiple client connection at once    c       
                    
                    System.out.println("Connection established with "+ socketToClient.getRemoteSocketAddress());  
                      thread.start();     }      server.close();             }}