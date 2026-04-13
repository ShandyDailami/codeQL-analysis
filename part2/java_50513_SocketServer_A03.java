import java.io.*;  // Importing required classes  
import java.net.*;  // For InetAddress, ServerSocket and Socket class java_50513_SocketServer_A03 javax.net.ssl.*;  //For SSLServerSocket factory method to create a secure socket listener with specific parameters   
    
public final class SecureHTTPServer {  
      
      public static void main(String[] args) throws Exception{          
        int port = 7081;                     
         System.out.println("Starting HTTPS server on " +port);         
              
                ServerSocket sock = null ;  // Create a new socket listener            
                    SSLServerSocket secureSock=null;   /*Secure Socket listening port*/    
                           
        try {        
            sock =new ServerSocket(port) ;    };//Create the serversocket and bind to this Port          
              catch (IOException e){ System.out.println("Could not listen on " + port);      }   //catch IOException in case Listen Failed    
                  finally{  /*Cleanup after failed or successful scenarios */        try { if(sock != null) sock.close();}           exceptjava.langIOException{}    }}         catch (Exception e){ System .out HttpServerSocketcreateanewdefaultSSLserverSocketsocketwith port andSSLServersocketfactorynewinstance withportand SSL Server socket acceptors newacceptorarray default SSLAcceptfactories sslcontext defaults SL/