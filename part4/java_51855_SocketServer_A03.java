import java.io.*;
import java.net.*;

public class java_51855_SocketServer_A03 {
    public static void main(String[] args) throws IOException{
        ServerSocket server = new ServerSocket(6013); // bind the socket to port, choose any available one that is not in use by another service 
         System.out.println("Waiting for client on " +server.getLocalSocketAddress());  
          while (true) {   
               Socket connection = server.accept();     // accept a new request from the connected user/client, if there's no available one then it will block until some connects 
                System.out.println("Accepted " +connection.getRemoteSocketAddress());  
                 DataInputStream dis=new DataInputStream(connection.getInputStream());   
                  // Read a string sent by the client using input stream     
                   String message =dis.readUTF();    
                    System.out.print ("Message received :"+message);  }            
           server.close();   }}//Close Server Socket