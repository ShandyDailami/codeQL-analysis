import java.io.*;
import javax.net.ssl.*;
import java.util.*;

public class java_48068_SocketServer_A08 {  
    private static final String END_OF_SESSION = "EOS";     // Message sent by client to end session       
      
    public static void main(String[] args) throws Exception{        
            int port = 1234;      // Specified in command line argument         
            
            SSLServerSocket serverSocket  = null ;  
              try {                
                // Create a socket that listens for client connections on the specified port. 
                  serverSocket = (SSLServerSocket) new SSLServerSocket(port);    
                   System.out.println("Waiting connection..." );       
                      while (true){              
                          Socket clientsocket  = null;           //socket definition                    
                         try {                      
                            //Accept a socket from the client request                   
                               clientsocket = serverSocket.accept();                 
                                SSLSocket ssl    =(SSLSocket)clientsocket ;   
                                  System.out.println("Connected to port " +port);    
                                   BufferedReader in  = new BufferedReader (new InputStreamReader   (ssl.getInputStream()));                //stream buffering                      
                                         String message;                   
                                          while  ((message = in .readLine()) != null ){                     
                                              System.out.println("Received: " +    message);     }                            });}                  catch(IOException e){System.out   out.println ("Exception caught when trying to read");}}}                           finally {serverSocket.close();}}  // close the socket connection                try,catch block ends here         
                                            private static class EndPoint extends java.net.Endpoint{              public void live(){             while (true) {} }    }     SocketServer s = new   SocketServer() ;}