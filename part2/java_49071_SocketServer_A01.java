import java.io.*;
import java.net.*;
public class java_49071_SocketServer_A01 {  
    public static void main(String args[]) throws Exception{    
        ServerSocket server = new ServerSocket(4242);         // Create a socket on 4242 port (any available port).         
                                                            // This will be used to accept incoming connections.           
       while (true){                         
           Socket sock=server.accept();                // Wait for client connection and get corresponding 'Socket' object              
                                                                         System.out.println("Client connected!");                
                                             DataOutputStream out = new DataOutputStream(sock.getOutputStream());  // Output Stream                   
                                                           BufferedReader in =new BufferedReader (                         
                                         new InputStreamReader( sock.getInputStream()));                             String message;            
                                          while ((message=in.readLine()) != null){                   System.out.println("Client says: "+message);                       // Read the client's input and print it to console                  DataOutputStream out =newDataOutputStream ( socket.getSocket(address,port) );  Send back message from server