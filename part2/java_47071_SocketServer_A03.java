import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;
import java.security.cert.*;

public class java_47071_SocketServer_A03 {
    private static final int PORT = 8091; // Port for the server to listen on 
    
    public static void main(String[] args) throws Exception{  
        ExecutorService executor = null;  
         try {          
             ServerSocketChannel ssc  = ServerSocketChannel.open();         
              SSLServerSocket sslsoc =  (SSLServerSocket)ssc .accept();  //Accept incoming connection, secure by using socket channel     
              
            KeyStore keystore=KeyStore.getInstance("JKS");  
                char[] password ="password".toCharArray();   
             keystore.load(new FileInputStream("/path/yourkeystore"),password);  //Load your own key store and truststore using its path    
         
            SSLContext sslcontext=SSLContext.getInstance("TLSv1_2");  
               KeyManagementStrategy kmStrat=  new KeymanagementStrategyImpl();    /*Implementation of keymanagementstrategy*/  //Use this for secure client communication      SDKManagerFactory,PKCS12Provider are not used here because they can't be loaded from the file system.     sslcontext .init(keystore ,kmStrat);//Initialize SSL context with our key store and kmstr at same time   
               trustAllCerts( (X509TrustManager)sslcontext  .getTrustManager());   //Set up all certs as trusted, using default X509 Trust Manager      ssc.bind(sslsoc);          /*Bind server socket to port number*/     executor= Executors.newCachedThreadPool();
              for ( ;; ) {  Thread t = null;}//Infinite loop thread handling each client connection in its own threads and handle connections here    } finally{   ssc .close();}             //Close the server socket      if(executor!=null) executor.shutdownNow();     System.out.println("Server ShutDown now");}}
              catch (Exception e){  throw new Error("Failed to setup httpserver:"+e);}}}   /*catch Exception in finally block, so that we cleanup resources regardless of success or failure*/      for(;;) {Thread thread = null;} //end infinite loop as server is running endlessly and does not do any real job
               public void trustAllCerts(X509TrustManager tm) throws Exception{     try   {for (Certificate cert : tm.getAcceptedIssuers()){ CertificateVerifyResult res =    tm.verify(cert);}} catch  (IOException e2 ){}
                finally      {} } //empty block to keep the code clean in case of any exceptions} }}//Closing our HTTPServer with all its threads going down}}}   */catch blocks here and also close server socket as we got an exception. But from there, further action will not be taken at this point due to already closed connection or some issue occurred while handling the client request}}