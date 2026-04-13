import java.io.*;
import java.net.*;
import javax.net.ssl.*;
  
public class java_50144_SocketServer_A07 {    
    public static void main(String[] args) throws Exception{        
        SSLServerSocket sslServerSocket = null;         
          
            try {              
                KeyStore keyStore = KeyStore.getInstance("JKS");             
                 // Load your own certificate and privatekey into keystore 
                  FileInputStream fis =  new FileInputStream("/path/toYourKeystoreFile") ;  
                   keyStore.load(fis, "yourpassword".toCharArray());       
                SSLServerSocket sslServerSocket = (SSLServerSocket)sslServerSocket;         
               // Setup the certificate and privatekey as truststore 
                 TrustManagerFactory tmf =  new 
                    javax.net.ssl.TrustManagerFactory();          
                  String keyStorePassword= "yourpassword";            
                   sslServerSocket .setNeedClientAuth(true);         
                SSLContext sc=  SSLContext.getInstance("TLSv1");              // TLS v1 only           
               tmf   .init((KeyStore) null,                    new  String[]{keyStorePassword},null );    
                 System.out.println ("Server Started.");                  sslServerSocket    = (SSLServerSocket ) sc          .getServerSocket();     
              } catch(Exception e){           // catching exceptions            
                throw   e;                   };            try {        new SocketServer().listenToPort ((ServerSocket)sslServerSocket);       System.out.println ("Waiting for Clients ...");    while (true ){  if((new SocketServer()).hasConnection()){          set : c = sslServerSocket .accept();          
                     Thread t= new   //handling client requests             ServerThread(c) ;               }}} catch       Exception e      { throw        e; };                  public void listenToPort (final    ServerSocket socket ){try  {}catch     (IOException ex){throw}for (;;)          try            { c = sslServer.accept();          
                      Thread t= new SocketThread(c);               } catch       Exception   // closing down the server and stopping all threads                e        .printStackTrace() ;      }}`  private class ServerSocket{    public static void listenToPort (final          ServerSocket socket ) {}} `private     Class           ConnectionManager, ClientConnectionHandler extends Thread