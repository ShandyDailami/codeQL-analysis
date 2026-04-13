import java.io.*;
import java.net.*;

public class java_51757_SocketServer_A01 {  
    public static void main(String[] args) throws IOException{       
         ServerSocket server = new ServerSocket(1234); // Create a socket on port number `port` (here 1234).                  
          while(true){            
            Socket client_socket =  server.accept();   /* Accept connection from clients*/   
              DataInputStream inFromClient=new DataInputStream(client_socket.getInputStream());               
               String message =inFromClient.readUTF();  // Read a string sent by the Client                 
             System.out.println("Received: " +message);   /*Print out received data */     
              DataOutputStream outToClient=new DataOutputStream(client_socket.getOutputStream());   
               String replyMessage ="Hello, client";       // Prepare a message for sending back to the Client                 
             System.out.println("Sending: " +replyMessage);   /*Print our data*/     
              outToClient.writeUTF(replyMessage);        // Send it  Back                         
           }   
     server.close();               // Close connection and stop Server socket listener when done */         
       System.out.println("Server closed");        
}