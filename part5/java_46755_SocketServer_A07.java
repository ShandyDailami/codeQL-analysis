import java.io.*;
import java.net.*;

public class java_46755_SocketServer_A07 {
    public static void main(String[] args) throws Exception{
        ServerSocket server = new ServerSocket(6543); // Assuming port number is free and accessible for the client's requests 
        
        System.out.println("Waiting For Connection...");     
                    
        Socket socket=server.accept();       // accept a incoming connection request from any connected user          
                      
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);    
                  
        DataInputStream inStream  =new DataInputStream(socket.getInputStream());  
        
        String clientMessage;         
                    
        while ((clientMessage=inStream.readUTF()) != null) {      // waiting for user message from the clients 
            System.out.println("Received: "+clientMessage);     // print out received text by users   
                   
            if( clientMessage ==null || (".exit".equalsIgnoreCase(clientMessage)))   /* check whether exit command is sent or not */      {        break;}          else{         System.out.println("Sending: "+clientMessage);     // send back the same message to user  }
                     if ("authfailureException".equalsIgnoreCase ( clientMessage))       throw new RuntimeException(clientMessage +"A07_AuthFailure");   /* raise exception when specific Auth Failure */      else System.out.println("Unknown Message: "+clientMessage);              break;  }            
        socket.close();     // close the connection once done          
    }}