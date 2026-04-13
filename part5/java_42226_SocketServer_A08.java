import javax.net.ssl.*;
import java.io.*;
import java.net.*;
      
public class java_42226_SocketServer_A08 {   
     private static SSLServerSocket sslServerSocket; // Server socket for TLS communication            
      public static void main(String[] args) throws Exception  
          { 
           int port = 7051 ;// Port number on which server is going to run                 
       System.out.println("Starting Socket Server at " +port);               
     SSLServerSocketFactory sslServerSocketfactory = (SSLServerSocketFactory)SSLServerSocketFactory.getDefault();   // Create the socket factory with custom TLS parameters 
      try {   
         //Create server-side SOCKS5 TCP port and bind to it, listen for connections from clients    
          sslServerSocket =  ( SSLServerSocket )sslServerSocketfactory .createServerSocket(port);          
              } catch (IOException ex)  
             {            System.out.println("Could not listener on port: " + port );    return;  };      // Stop if listening or binding fails    
                 while (true){          Socket clientSocket = sslServerSocket .accept();       DataInputStream dis=new DataInputStream(clientSocket.getInputStream());              try {                   String messageReceived  =dis.readUTF() ;         System.out.println("Client says "+messageReceived);           
                // Here we can do more security sensitive operations like encryption,decryption and so on   }  catch (IOException ex)              
                 {System.err .println ("Error accepting client at: " +clientSocket );          return;     };      }}   
}             });