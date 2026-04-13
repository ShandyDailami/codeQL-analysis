import java.net.*;
import java.io.*;

public class java_50990_SocketServer_A08 {  
    public static void main(String[] args) throws Exception{    
        ServerSocket server = new ServerSocket();      // Creating a socket for incoming connections      
         try{            
            System.out.println("Waiting for client on port: "+server.getLocalPort() +"...");              
              Socket connection =  server.accept();    // Establishing the communication with an individual user 
                System.out.println ("Connected to : "  +connection.getRemoteSocketAddress());        
                 DataInputStream dis = new DataInputStream(connection.getInputStream());     
                  BufferedReader br =new BufferedReader (new InputStreamReader (connection.getInputStream()));       // Getting input from user  and sending it back through the socket    
                   String clientMessage=null;   
                    if ((clientMessage  = dis.readUTF()) != null){        
                         System.out.println("Client says :" + clientMessage);                     
                          connection.getOutputStream().writeUTF( ( "Hello Client, Message From Server!" ) );   // Sending a reply back to the user          }     catch (Exception e) {e.printStackTrace();}               server.close();    }}       catch (SocketException e){ System.out.println("Could not listen on port: 4445");server.close();}}