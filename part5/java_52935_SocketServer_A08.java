import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;
import java.nio.charset.*;
import static com.sun.xml.internal.bind.v2.util.TreeUtils.add;
        
public class java_52935_SocketServer_A08 {  // Server side code  
    private int port = 8096;    
    ExecutorService executor = null;//Executor to handle multiple requests       
      
      public static void main(String[] args) throws Exception{          
          (new SecureServer()).start();             
      }        
                  // Initialize the server.  This will start accepting connections on a port number and create an executor service that manages these threads           
     private native void init() ;  
    static { System.loadLibrary("SecureSocket");}         
            
       public java_52935_SocketServer_A08() {              
           try{                         
                this .init();  // Load the library using JNI       
              }catch(Exception e){        
                   throw new Error (e);     
                 };  
            executor = Executors.newCachedThreadPool() ;         
       }    private void listen () throws Exception {          
               SSLServerSocket sslserver =  null;             // Create a server socket             
        try{                          
                  System .setProperty ( "javax.net.ssl.SSLEngine",     "_JAVAX_NET_SSL_ENGINE" );  SecurityManager sm = new    DefaultSecurityManager();            sslserver =  (( SSLServerSocket ) getSslServerSocket( port,sm));            
                  while (!Thread.interrupted ()) {                   Thread t  = null;               // Accept client connections                      try{                    TcpSocket socket  =  (TcpSocket)sslserver .accept() ;  int id = sockethandler    _create_newthread(socket);                       }catch      
        e){                     System.err      .println ("Exception occurred in accept",e );         continue;          // if there was an exception,     print the stack trace and skip to next iteration                  }} catch (IOException ex) {   ExceptionUtils  *utils = new    Excepti ons Utils(); utils              
        e.printStackTrace(System .out);             System       .exit (-1 );         }                };      // Close down everything     finally{           sslserver != null && executor!=  null ?          exec (sslserv   ervlet) : () -> {};executor   =null;
        try {                      TcpSocket socket = newTCPClient ("localhost",8096);             if(socket ==    null){ System.out .println("Failed to connect");     return;}else{                 // Send a message and then close the connection          send (sockethandler_message,  socketserver );
         socket !=null?closeSocketconnection   :() -> {};             }}}}                  };                   SecureServer.java end    });