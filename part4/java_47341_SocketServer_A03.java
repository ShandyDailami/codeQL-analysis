import java.io.*;
import java.net.*;

public class java_47341_SocketServer_A03 {  
    public static void main(String[] args) throws Exception{      
        ServerSocket server = new ServerSocket(6013); // socket port number for the server         
         System.out.println("Waiting for client on port " +          
            server.getLocalPort()+"...");    
              
   while (true) {     
       Socket sock=server.accept();  /* wait here until a connection is accepted */   
        // handle the new socket...         
         System.out.println("Connected to " +          
            sock.getRemoteSocketAddress());    
                DataInputStream in =              
              new DataInputStream(sock.getInputStream());  
                  String message=in .readUTF();    /* read a string from the socket */       
          System.out.println("Received: " +           // echo what was received           
             message);      
                sock.close();  }     }}`