import java.io.*;  // Import the necessary classes from standard library  
import java.net.*;   
public class java_52315_SocketServer_A03 {
     public static void main(String[] args) throws Exception{     
          ServerSocket server = new ServerSocket(80);      
           System.out.println("Server started");        // Start the TCP socket to accept client requests 
            while (true){                               // infinite loop for listening and accepting connections   
                 Socket sock=server.accept();             // Waiting until a connection is established  
                  DataInputStream dis = new DataInputStream(sock.getInputStream());    
                   System.out.println("Client connected");      /* Print out message to the console */ 
                    String clientInput;   
                     do{                                           // Main loop for reading from socket input stream      
                         if((clientInput=dis.readUTF())==null) break ;   // If read return null, it means no data is available in this round trip and hence we should stop here    
                          System.out.println("Received: "+ clientInput);    /*Print out received message to the console*/ 
                     }while(true);       
            };      
      }   // End of main method          
}