import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;
import java.security.KeyStore;
import org.apache.commons.codec.binary.Base64;
  
public class java_45702_SocketServer_A07 {   
      
     private static ExecutorService executor = Executors.newCachedThreadPool();     
          
        public static void main(String[] args) throws Exception  {         
            ServerSocket server=null;            
                try{                 
                    // Create a KeyStore and load it with the certificate      
                   KeyStore keyStore  = KeyStore.getInstance("JKS");                    
                   InputStream inputStream = SocketServer.class    .getResourceAsStream("/client-keystore.jks") ; 
                                  
                      keyStore.load(inputStream, "secretpassword".toCharArray());                                 
                        // Create a truststore for client and load it with the certificate      
                   TrustStore trustStore = KeyStore.getInstance("JKS");                    
                    InputStream inputStream2=SocketServer.class .getResourceAsStream("/server-truststore.jks") ; 
                                  
                      trustStore.load(inputStream2, "secretpassword".toCharArray());                                 
                       // Setup SSLContext to use KeyStore and Trust Store for client authentication    
                        SSLContext sslcontext =SSLContext.getInstance("TLSv1_2");                  
                          sslcontext .init(keyStore , trustStore ,"secretpassword" .toCharArray() );                     
                           server= (ServerSocket)sslcontext .getServerSocket(8095);                // Initialize Server Socket with SSL  
                            while(!server.isClosed()) {      
                               System.out.println("Waiting for client on port "+Integer.toString(server.getPort()));     
                                Socket socket = server .accept();    if (socket != null)     // Accept new connection                  
                                  executor.execute(new EchoClientHandlerSSL   SSLContext sslcontext,  socket); }                         finally {       ServerSocket socket  = server;              while (!((ServerSocket)server).isClosed()) try{ Socket soc = ((ServerSocket)socket ).accept(); if (soc != null ) executor.execute(new EchoClientHandlerSSL   SSLContext sslcontext,  soc);} catch (Exception ex){ ServerSocket socket  = server; }    
                                System . out .println ("Closing the Socket connections ");          try { for (; ; ); new Handler().post(new Runnable()    {} ).sendMessageAndHideProgress(); }} });   if (!server.isClosed())  ((CloseableConnection)socket).close(); } catch (Exception ex){}};
}                          // Close the Server Socket                       try { socket . close(); serverSocket=null;} finally{if(executor !=  null && executor instanceof ExecutorService )((ExecutorService)    executor   ).shutdownNow() ;  }}catch      (IOException e2){ System.out.println("Error in closing connections "+e2);}}