import java.io.*;
import java.net.*;

public class java_46677_SocketServer_A08 {  
    public static void main(String[] args) throws IOException{      
        ServerSocket server = new ServerSocket(12345);         //create a socket on port 6789 (0 means any available local port).             
                                                               //This creates our "server" endpoint for clients to connect.                    
                                                                    System.out.println("Server started at: " + server.getLocalSocketAddress());  
        while(true) {                                            
            Socket socket = server.accept();                    //this is where the magic happens - we wait until a client connects            
                                                               printWriter (socket); 
                                                                    }        
     public static void printWriter (Socket socket){              try{                      
                OutputStream outToClient=                           socket.getOutputStream();                  PrintWriter printer = new PrintWriter(outToClient, true);                     //create a writer on the connection that sends to client          
             while(!Thread.currentThread().isInterrupted() && !socket.isClosed()) {                      print("Message received from Client", false) ;  }                               finally{                           socket.close();printWriter(null)}            try{}catch (Exception e){e.printStackTrace(){}}       if (!serverSocket.isBound()) serverSocket = null;  
                                                          }}     void main and static methods must be inside a class for Java to recognize them as such, I've moved the code into one of those classes but did not specify which ones because it was all in response to your instructions about "be creative".  It is important that you understand how these pieces fit together.