import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;
import java.nio.charset.*;

public class java_46409_SocketServer_A01 {  
    private static final int PORT = 1234;  // Change port number as required by your application    
      
    public static void main(String[] args) throws Exception{          
        ExecutorService executor = Executors.newFixedThreadPool(5);         
        
        SSLServerSocket serverSocket = null;  
            
        try {             
            SSLServerKeyStore sslServerKeyStore =  newSSLServerKeyStore();  // Create your own implementation of this method          
                        
            KeyManagerFactory keyManagerFactory  = sslServerKeyStore.getKeyManagerFactory(PORT);    // Retrieve the appropriate details based on port       
                                                                                           
                      SSLServerSocketFactory sslsf =   newSSLServerSocketFactory (keyManagerFactory,null ,new SecureRandom());         
            serverSocket =  ((SSLServerSocket)sslsf).accept();    
                    
             Future<Socket> futureClientConnection  = executor.submit(()->  {  return sslServerKeyStore .getSocketFromAccept((SSLServerSocket )serverSocket); });    // Use a connection pooling mechanism for better efficiency         
                      Socket client = null;          
                       try{       if (futureClientConnection !=null)    
                              client  = futureClientConnection.get();   }catch(Exception e){}        finally { executor .shutdownNow(); }}                  
            BufferedReader reader =  newBufferedReader((InputStreamReader )client.getInputStream());    // Create input stream from socket      
             printWriter out = null;      try{  if ( client !=null)   }catch(Exception e){}               finally {if ((out)!=null) out .close();}}                     
     });