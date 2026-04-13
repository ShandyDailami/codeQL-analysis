import java.io.*;
import java.net.*;

public class java_46058_SocketServer_A01 {  
    public static void main(String[] args) throws IOException{      
        ServerSocket server = new ServerSocket(8976);         // setting up the socket and port number 
                                                             // to be used for communication, this is a secure place.                 
                                                                    
        while (true){         
            Socket client =server .accept();      /* here we accept incoming connection */          
             System.out.println("Client connected");   
             
                                             if(client != null) {                   // check whether the socket is not closed or it's still valid 
                                                 DataOutputStream out =  new   DataOutputStream ( client .getOutputStream () );         /* get output stream so we can send info to other side */     
                                                BufferedReader in =new    BufferedReader(new InputStreamReader((client.getInputStream())));     // Get inputstream from the socket  which is used for receiving data                      while ((message=in .readLine()) != null) {                /* read client message until end of transmission */  
                                             if (message==null){                  continue;}                   System.out.println("Client says " + message);          out.writeBytes( ("Server :"+message).getBytes() );                     }  finally{client .close();}             //closing the socket connection after use         });     Socket server = new   ServerSocket (8976) ;