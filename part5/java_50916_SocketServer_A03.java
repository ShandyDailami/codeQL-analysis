import java.io.*;
import java.util.*;
import javax.net.ssl.*;
import java.nio.*;
import org.apache.log4j.*;
  
public class java_50916_SocketServer_A03 {   
     private static SSLServerSocket serverSocket;  // Server socket for accepting connections from clients...        
      public static void main(String[] args) throws IOException, IllegalArgumentException{      
           Logger logger = Logger.getLogger("com.example");       
            try (ServerSocket sock = new SSLServerSocket(8043)) {          // Setup server socket to accept connections from clients...    
                  System.out.println("\n*** Waiting for client on port: " +  9126);        
                    while (true)  {                // Server will keep running until it is stopped by a call to stop() method            
                         SSLSocket clnt = sock.accept();      /* Accept incoming connection */                 
                             System.out.println("\n*** Connection from: " +clnt.getRemoteSocketAddress());                     
                              PrintWriter out = new PrintWriter(clnt.getOutputStream(), true);    // Get output stream for sending data back to client...                    try {     /* Create and setup the socket connection */                                          
                                  BufferedReader in  =new BufferedReader (new InputStreamReader  ( clnt . getInputStream()));                System.out.println("*** Waiting Messages from Client ...");                      String userInput;             do{                   // Read client input...                      
                                       if (! ((userInput = in.readLine()) == null)) {                 /* If message not empty */                     try  {                        out . println ("\nServer: " + (new Date()));                          } catch(Exception e) {}                      System.out.println("*** Message received from Client :"+ userInput);    
                                       if (!userInput.equalsIgnoreCase(".quit")){continue;}              /* If quit command, then close connection and exit loop */                  clnt .close();                     out .flush() ;  // Flush buffer to ensure all messages are sent                    } while(!userInput.equals("-1"));       
                                     System.out.println("\n*** Connection closed...");                      if (!sock.isClosed()) sock.close();                   /* Close the socket and exit program */   }} catch (IOException ex) { logger . error ("Error in communicating with client",ex );}  }}}    // End of main method