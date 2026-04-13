import java.io.*;
import javax.net.ssl.*;
import java.util.concurrent.*;
  
public class java_52554_SocketServer_A03 {    
    private static ExecutorService executor;     
      
    public static void main(String[] args) throws IOException, InterruptedException{       
         // Create a pool of worker threads to process client requests           
          executor = Executors.newCachedThreadPool();            
          
          SSLServerSocket sslServerSocket = null;                    
               try {                        
                KeyStore keyStore = KeyStore.getInstance("JKS");                     
                  InputStream inputStream =  SecureSocketServer.class                              .getResourceAsStream("/keystore.jks" );  // path to your keystore  
                   String password= "password";                                  
                    keyStore.load(inputStream, password.toCharArray());               
                     SSLServerSocketFactory sslServerSocketfactory =                           (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();            
                      sslServerSocket  =          (SSLServerSocket)sslServerSocketfactory                        .createServerSocket(1234);              
                       SSLEngine eng=                          sslServerSocket                                .createSSLEngine();                     // Create an engine with the server socket 
                         eng.setUseClientMode(true);                   
                           } catch (Exception e) {                             System.out.println("Error while creating SSL Server Socket");     return;            
                        }          finally    {                                  if (!executorService .isShutdown()) sslServerSocket       .close();  // Don't forget to close the server socket when you are done with it!        
                                                     executor.shutdown();}                   }}                       ;