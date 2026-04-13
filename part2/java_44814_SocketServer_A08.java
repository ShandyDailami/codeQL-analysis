import javax.net.ssl.*;
import java.io.*;
import java.net.*;
  
public class java_44814_SocketServer_A08 {    
    public static void main(String[] args) throws Exception{        
        SSLServerSocket serverSocket = null;             
          
        try {           
          // create a listener to accept client connections and 
          // listen for them on port number `12345` with the same certificates (SSL/TLS).  
          SSLEngine sslEngine  = SSL.createSSLEngine("localhost", 12345, new File("/path_to/_keystore"), "mypassword");     
           serverSocket = (SSLServerSocket)sslEngine.getServerSocket();        
        } catch(Exception e){         
            System.out.println("\n Error creating SSL Server Socket...\n ");             return;   // exit if fails      
              }; 
   
          try{    
               while(!Thread.currentThread().isInterrupted() ) {     
                      new VanillaJavaSocketServerHandler(serverSocket).start();         }           catch (Exception e) {}                   break;}        finally{}                serverSocket .close();   }}            `});  // End of code block