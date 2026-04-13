import javax.net.ssl.*;
import java.io.*;
import java.nio.*;
import java.util.*;
import static javax.net.ssl.SSLServerSocketChannel.*;
public class java_43906_SocketServer_A08 {  
    public static void main(String[] args) throws IOException{  // Main method to start the server    
        SSLServerSocketChannel sslServerSocket = null;      // Initialize a new Server socket channel for Secured communication.      
          try{           
                KeyStore keyStore =  KeyStore.getInstance("JKS");   /* Create and load your own keystore here */ 
                    System.out.println(keyStore);                
              InputStreamReader isr = new InputStreamReader (new FileInputStream ("mykeystore"),"UTF-8");        //Load the key store file      
                keyStore .load(isr, "mypass".toCharArray());           /* Loads with password */     
               TrustManagerFactory trustMgrFact =  TrustManagerFactory.getInstance (TrustManagerFactory.getDefaultAlgorithm());    
              KeyStoreConnection keystoreConn =keyStore   .newKeyStoreCo    nnection(null);          //Creates a new key store connection       System.out.println("Keyset Store created and loaded!");      trustMgrFact.loadKeyStore (keystore, "mypass".toCharArray());               
              SSLServerSocketChannel sslChan =SSLServerSocketChannel .open();          //Create a new Server socket channel for Secured communication       System.out.println("Secure Socket Channel created!");      trustMgrFact  =new  PKIXTrustManager[]{trust Mgr};           ssl Ch an =  ( SSLServerSocketChannel )sslChan;             
               int id=1024 ;          // ID for socket         System .out.println("ID : " +id );       KeyManipulation keyM = keystoreConn   .getKeyEntry(null, null);     sslch an  .. accept (SSLServerSocketChannel )sslChan;             
               SSLContext sc =  STSPServerSocketFactory    . getDefaultSSLContext();          // Creates a default server context with our KeyStore and TrustManager      System.out   outprintln("server-context created");     assert sslch an  != null ;         } catch (Exception e){System.err