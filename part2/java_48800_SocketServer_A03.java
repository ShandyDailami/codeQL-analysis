import java.io.*;
import java.net.*;
import javax.net.ssl.*;
  
public class java_48800_SocketServer_A03 {    
    public static void main(String[] args) throws Exception{ 
        ServerSocket sock = null;      // Creating a server socket for secure communication using SSL/TLS protocol        
       try{            
           System.out.println("Started the Java Socketserver....");         
               
            int port = 4242 ;   // Assign to desired listening ports (must be above 1024)             
               sock = new ServerSocket(port, null ,new SSLServerSocketFactory(      
                               new KeyStoreReader("myKey.jks", "mypassword".toCharArray()),        
                             ("myAlias" ,null),      // password of keystore is required    
                              new TrustManagerFactory().getTrustManager("TSF"))));// Trusted Manager Factory      
            sock.setReuseAddress(true);         
                  
             while ( true ) {             
                 Socket connectionSocket = null;    /* Awaiting client */       
                     try{      // Accept incoming connections              
                         System.out.println("Waiting for a Connection....."); 
                          connectionSocket= sock.accept();  
                             System.out.println ("Connected to Client");    
                                }catch (IOException e){             /* Handle IOExceptions */               
                                    e.printStackTrace();          // Print the exception on console          
                                        continue;                     // Continue with next loop           
                                     }}// end of try catch     
        connectionSocket .close();         System.out.println("Closed Connection");     }  finally {       if ( sock != null ){    /* Close Server socket */             sock.close();          }           printStackTrace();   return;}}}` // remove this line in production code, it's there for debugging