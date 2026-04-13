import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.net.*;
    
public class java_52910_SocketServer_A01 {  // Starts the HTTPS server, accepting clients on port 8443 (default for secure web traffic)   
       private static final int PORT = 8443;  
        ExecutorService executor = Executors.newFixedThreadPool(5);    
      public java_52910_SocketServer_A01() {        
            System.out.println("Starting HTTPS Server on port " +PORT );   
           try{      
                SSLServerSocket serverSocket=null;   //SSLSocket secure_socket = null ;  (SSL/TLS)     
                    KeyStore keyStore   =KeyStore.getInstance( "JKS" ) ;    
               TrustManagerFactory trustManagerfactory =  new 
            JettyTrustManagerFactory();    String password  = "_trustall";       Security.addProvider(new org.eclipse.jetty.util.security.SecurityProvider());   // for SSL and TLS     
                KeyStore keyStore_client = KeyStore.getInstance("JKS");     boolean success = 
            keyStore_client .load( new FileInputStream("/Users/user/"+"myKeystorePassword") , password  );    trustManagerfactory= 
             new JettyTrustManagerFactory() ;      SSLServerSocket factory= (SSLServerSocket) serverSocket;           //for TLS         Security.addProvider("SunProviders");     security_socket .setNeedClientAuth(true);       println ("Starting the HTTPS Server... ");   
                while( true ){  if((serverSocket =factory.accept()) == null){continue;}   Socket socket =  serverSocket;      executor.execute (new ClientHandler(socket)); } }}catch Exception e1 { System . err . println ("Exception thrown" +e );}     finally
                {System . out . println("Closing down the daemon");    if((serverSocket =factory..accept()) != null){continue;} executor.shutdown();}}  // Stop accepting new clients and shut it alldown     
public static void main(String[] args)   throws Exception{new SecureHTTPServer() ;} }       `