import java.io.*;
import javax.net.ssl.*;
import java.util.concurrent.*;

public class java_50901_SocketServer_A03 {  
    private static ExecutorService executor = Executors.newCachedThreadPool();  // thread pool for handling connections
    
    public static void main(String[] args) throws Exception{        
        SSLServerSocket serverSocket=null;         
          
            try{            
                String keyStorePath =  "/path/to/yourKeyStore";   /* Enter your keystore path */ 
                  
                    char[] password = 'password'.toCharArray();      // Password for the Key Store             
                    
                        SSLServerSocketFactory sslServerSocketFactory= 
                            (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();         
                          serverSocket=(SSLServerSocket)sslServerSocketFactory.createServerSocket(8443, new javax.net.ssl.SSLServerSocketImpl(serverSocket));                  
                           ((javax.net.ssl.SSLSocket)(serverSocket)).setNeedClientAuth(true);  // enabling client authentication      
                          serverSocket.setNeedClientAuth(false);   /* This is for Client side */   
                        
                            KeyStore keyStore=KeyStore.getInstance("JKS");       
                             keyStore.load(new FileInputStream (keyStorePath),password );        
                             
                           SSLContext sslcontext =SSLContext.getInstance("TLSv1.2");  /* Tweak to your version */    // To use OpenSSL you need JRE8 or higher and Oracle's Java Native Access  
                             sslcontext .init(keyStore,password , new java.security.SecureRandom());      
                              SetupCallback sc =new SetupCallback(){          public void setUp(SSLSocket s){  // SSL socket initialization        }};            };            
                          serverSocket= (SSLServerSocket)sslcontext.getServerSocket();              
                            System.out.println("Starting Secure Server on port "+serverSocket.getPort());     
                             while(true ){          new Handler(serverSocket.accept()).start();           }   };              catch(Exception e){System.err.println ("Failed or busy at: " + sockadd);e.printStackTrace ();}    finally { serverSocket?.close(); executor.shutdownNow();}}