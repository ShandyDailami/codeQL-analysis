import java.io.*;
import java.net.*;

public class java_50743_SocketServer_A01 {  
    public static void main(String[] args) throws Exception{        
        ServerSocket server = new ServerSocket(5000);          // Create a socket on port 49876              
       while (true){                                                  
            Socket client =  server.accept();                     /* Wait for the connection */            
           System.out.println("Connected to " +client.getRemoteSocketAddress());        
              DataOutputStream out = new DataOutputStream(client.getOutputStream());   // Get an output stream from socket         
               BufferedReader inFromClient=new BufferedReader(                        /* Read input */                     
            	       new InputStreamReader(client.getInputStream()));               
           String clientInput;                           
         while((clientInput =inFromClient .readLine()) !=  null){              // Get the string received from a  connected socket   
               System.out.println("Received: " + clientInput);                    /* Display it on console */                  }                        });}}));}                               catch (Exception e) {e.printStackTrace();}}}