import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;
import java.security.cert.CertificateException;
  
public class java_47082_SocketServer_A08 { 
    private static final int port = 12345; // Choose an arbitrary uncommon one!    
      
      public void start() throws IOException, CertificateException{         
        SSLServerSocket serverSocket = null;        
          
            try {            
                KeyStore keyStore  = KeyStore.getInstance("JKS");   
                
                    InputStream inputStream =  SocketServer.class     .getResourceAsStream("/keystore.jks") ;  // load your own keystore file  
                   byte[] keyStoreBytes = new byte[inputStream.available()];        
                inputStream.read(keyStoreBytes);             
                  keyStore.load(new ByteArrayInputStream (keyStoreBytes), "mypass".toCharArray());  // load your own password          
                        
             SSLServerSocketFactory sslServerSocketFactory =      
                    (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();     
                serverSocket=   (SSLServerSocket)sslServerSocketFactory .createServerSocket( port );         
            } catch  (IOException | CertificateException e ) {              System.out.println("Starting Server failed");           throw new RuntimeException(e);     // end try block                      
               while ((serverSocket =      sslServerSocketFactory    .acceptConnection()))   != null{                   Thread thread =  new        SecureThread ( serverSocket );            Executor exec  =       Executors.newCachedThreadPool();           executor 	.execute(thread);}} catch     // end try block and catches