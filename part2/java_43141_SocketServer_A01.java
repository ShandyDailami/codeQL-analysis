import java.io.*;
import java.net.*;

public class java_43141_SocketServer_A01 {    
      public static void main(String[] args) throws Exception{            
        ServerSocket server = new ServerSocket(80);              // Create a socket on port 80          
         System.out.println("Waiting for connection... ");      
          Socket client = server.accept();                      // Accept incoming connections    
            System.out.println ("Connected to: " +client.getRemoteSocketAddress());   
             DataInputStream in = new DataInputStream(client.getInputStream());               
              BufferedReader br =new BufferedReader (new InputStreamReader((client.getInputStream())));   // Create input stream and buffering reader    
            String clientInput;                            // Declare a string for user's message 
           while ((clientInput=br.readLine())!= null){                   //While loop to read the data sent by users       
                System.out.println("Received: " + clientInput);          }                      });     catch (IOException e) {                       if(server !=null ) server .close();                               
              if (client  !=  null   )         client . close() ;                        }}                            // If there is any exception, it will be caught and closed.                EOFException            printStackTrace          }                     ExceptionUtils    final class IOException extends RuntimeException { ...}}}}}      });