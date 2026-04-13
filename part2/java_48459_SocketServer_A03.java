import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Logger;
  
public class java_48459_SocketServer_A03 { 
    private static Logger logger = Logger.getLogger(SecureChatServer.class.getName());     
      
     // Server port       
     public final int PORT = 7021;          
        
     SSLServerSocket serverSocket  = null ;           
         
   BufferedReader reader=null; 
    Socket socket = null;                  
               
 private void start() throws Exception {             
       try{                
             // Create a new ServerSocket at port PORT                 
               logger.info("Starting chat server");     
                          System.out.println("\nServer is running on "+PORT); 
        SSLServerSocketFactory sslServerSF = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();   
                SSLEngine sslEngine=sslServerSF.createSSLEngine( PORT );            // Create an engine                  with the server socket                  
               sslEngine.setNeedClientAuth(true);                           // Setup authentication, if necessary      println("SSL Engine created");  
          cipherSuitesToString();  System.out.println("\nAdded Ciphers: "+cipherSuiteNames());         return; }              catch (Exception ex) {logger .warning ("Server failed to start \n\n" +ex ); throw new ExceptionInInitializerError(ex);    }}           
   public static void main(String[] args){             try{  Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());              SecureChatServer scs =null;                scs= new SecureChatServer();         if (scs== null) throw new ExceptionInInitializerError("Cannot initialize Singleton");         
             try {  System.setProperty( "javax.net.ssl.keyStore", "/home/user1234567890-workspace/.pki/tks_andrewsaltstackoverflow") ;           // Key Store     println("Set Property");               
                  scs .start();                             } catch (Exception ex){logger_.warning( "Server failed to start \n\n" +ex);  throw new ExceptionInInitializerError(e)}}}   private void cipherSuitesToString(){            try{    CipherSuite[] arrayOfCipherSUITES = java.security.Security.getCipherSuiteNames();                  
              for (int i = 0; i <arrayOfCipherSUITES .length ; ++i){                  println("Added ciphersuites: "+((Object)  ((ByteArrayWrapper ) arrayOfCipherSuites[i])).getName());}}     private String[] getAllProviders(){            try{   return java.security.Security.getProviderNames(); }catch (Exception ex){logger_.warning(ex .toString()) ; throw new ExceptionInInitializerError("Cannot initialize Singleton"); }}