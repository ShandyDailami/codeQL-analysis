import java.io.*;
import java.net.*;
public class java_52737_SocketServer_A01 {  
    public static void main(String args[]) throws Exception{    
        ServerSocket welcomeSocket = new ServerSocket(6013);      // Create a server socket at port 6789 and wait for connection requests from clients        
           while (true){         
               Socket connectionSocket = welcomeSocket.accept();    // Listen to incoming client connections    
                System.out.println("A new Connection is made");      
                   DataInputStream inputStream = 
                           new DataInputStream(connectionSocket.getInputStream());   // Stream of bytes read from the socket     
                  String messageFromClient =inputStream .readUTF();  ## Read a string sent by client    
                System.out.println("Received Message: " +messageFromClient);    # Print out received data       DataOutputStream outputStream =  new DataOutputStream(connectionSocket.getOutputStream());   // Stream of bytes written to the socket      OutputStream printScreen =System.out;  Send back message from server       
                   String returnMessageToClient="Echo: " +messageFromClient ;    # ECHO : sent data string+         outputStream .writeUTF(returnMessageToClient);   System. out.println("Sent Message to Client:" +  sendBackMesage );  }     welcomeSocket.close();     
        }}`}}}}}