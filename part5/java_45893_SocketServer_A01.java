import java.io.*;
import java.net.*;
    
public class java_45893_SocketServer_A01 {   
      public static void main(String[] args) throws IOException{        
        ServerSocket server = new ServerSocket();           // Creating a listener on port number XXXXX (where you want your client to connect).  You can choose any available unused ports.  
            try {                         
                System.out.println("Wait for Client Connections...");   
            
                  server.bind(new InetSocketAddress(8091));           // Binding the Server Socket object on port XXXXX (same as client's request).  You can choose any available unused ports or IP address & Port number combination if you want multiple clients to connect at once  
               while (true) {                           
                  Socket socket = server.accept();                    // Accepting a connection from the incoming traffic         
                        try{                     
                         System.out.println("Connected client : " +socket.getRemoteSocketAddress());    
                          DataInputStream dis= new DataInputStream(socket.getInputStream());              
                               String message; 
                                  while ((message = dis.readUTF()) != null) {                            // Reading the Message from Client  
                                     System.out.println("Client says : " + message);                     
                              }                                                      
                        } finally{   
                         socket.close();                                        // Closing connection to client after done with it                  
                     }} catch(IOException e){                                     
                          e.printStackTrace();                            };   });      try { server.close();}       catch (IOException e) {}  ;};});