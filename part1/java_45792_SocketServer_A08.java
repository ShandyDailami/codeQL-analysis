import java.io.*;
import java.net.*;

public class java_45792_SocketServer_A08 {  
    public static void main(String[] args) throws Exception{      
        // create a server socket and listen on port number 12345 for incoming connections    
            ServerSocket s = new ServerSocket (12345);            
         while (true){              
           System.out.println ("Waiting for client ...");  
          Socket connectionSocket =  s.accept();              // wait here until a request comes in 
        try {                          
            OutputStream out = new PrintWriter(connectionSocket.getOutputStream(), true);   
                       BufferedReader in=new BufferedReader(                  
                          new InputStreamReader(connectionSocket.getInputStream()));         
                      String clientMessage;     // this will hold the message from  clients  
                    while ((clientMessage  = in.readLine()) != null) {       System.out.println ("Received Client : " + clientMessage);              if (clientMessage .equals("EXIT"))                                  break;}                  s.close();    }     catch(IOException e){System.out.println(e.getMessage());} 
        // the server will not respond to a message from a non-authenticated user, hence security is only concerned with plaintext communication here  
            System.out.println ("Closing connection");             
      }        
    }