import java.io.*;
import java.net.*;

public class java_46312_SocketServer_A03 {  
    public static void main(String[] args) throws IOException{        
        ServerSocket server = new ServerSocket(8095);       // Create a socket on port number "port"    
          while (true){ 
              Socket client_socket=server.accept();             // Wait for incoming connection requests     
                  DataInputStream inStream  =              
                      new DataInputStream(client_socket .getInputStream());   / Read data from the stream        Incoming message, you can be of string type or object     byte[] bytes = "Hello Client".getBytes() ;  Write to socket       out.writeUTF("Server: Received your Message");         // Send a response back               
              System.out.println(inStream .readUTF());           if ("exit".equalsIgnoreCase   ( inStream .readUTF())) {client_socket    .close(); break;}            }     server.close();}}  });