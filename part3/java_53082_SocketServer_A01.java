import java.net.*;
import java.io.*;
  
public class java_53082_SocketServer_A01 {
    public static void main(String[] args) throws Exception{
        ServerSocket server = new ServerSocket(5432); // Create a socket on port 6789 with backlog = 10 (connections queue size).     
         try {    
            while(true){  
                Socket client=server.accept();//Establish connection until successful    Connection is established, then the program will close and server gets closed as well       System.out.println("Client connected");  //Print statement to verify if a new user has arrived      }     finally {           try{if(server != null)
            throwException((ServerSocket)server).getMessage());    catch (IOException e){}}catch (ClassCastException ccE ) {}   System.out.println("The server socket encountered an error while trying to respond to the client.");  // exception handling for unknown clients     }         
        }}