import java.io.*;  // Import required classes  
import javax.net.* ;     // For Socket class java_44154_SocketServer_A01 javax.security.auth.*;       // JKS, PKCS11 and keyStore API's     
import java.nio.file.*;             // Path & Filesystem operations for directories        
import java.util.logging.*;           // Logger 
  
public class SecureServer {   
     private static final int PORT = 8079;        // Port on which server listens         
      
      public static void main(String args[]) throws Exception{             
            ServerSocket s = new ServerSocket(PORT);        
             System.out.println("SecureServer listening at " + s.getLocalSocketAddress());   
               Socket socket=null;        // Declare the Client Connection 
                    try {                  
                         while((socket=s.accept()) != null) {                 
                              DataInputStream dis = new DataInputStream(   socket .getInputStream ());                         
                               System.out.println("Accepted from : " +    DiscoveryUtilities      // Print connected client's host address 
                                                      .findFirstNonLoopbackAddress().orElseThrow(() ->     new AssertionError())           +" ");                                 
                                   String msg;                      
                                    while ((msg = dis.readUTF()).length() != 0) {             System.out.println("Client: " +    DiscoveryUtilities      // Print received data from the client              .findFirstNonLoopbackAddress().orElseThrow(() ->     new AssertionError())           +" :  Message='"  + msg +  "'");
                                           DataOutputStream dos =new   DataOutputStream( socket.getOutputStream());   
                                            String replyMessage=  "Server: Hello, client!";          // Reply message to the Client                         
                                             dos .writeUTF (replyMessage);             System.out.println("Sent:"+     replyMessage );  }                                                                                            });             
                     catch(IOException e){System.err.println(e.getMessage());}               s.close();                           }}   // Close Server and End Connection                      printStackTrace()}}                    finish(){LogManager log = LogManager.getLogManager().getLogger("");log..finish ("Closed the server successfully."); }