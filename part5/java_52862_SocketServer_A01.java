import java.net.*;
import javax.net.ssl.*;
import java.io.*;   // Import Input/Output Streams, Serializable and IO Exceptions            
public class java_52862_SocketServer_A01{   
     public static void main(String args[]) throws Exception { 
        int port = 1234;       // local loopback traffic on the port number provided by JVM argument: -Djava.library.path=/usr/local/lib:/etc/../lib   (on Unix-based systems, use /tmp instead of \/)    In other words 'localhost'
        SSLServerSocket sslServerSocket = null;  // Create a new socket and bind it to the port provided by JVM argument         
         try {              
             KeyStore keyStore =  KeyStore.getInstance("JKS");   /* Load server keystore*/      SslServerSocket chanel=new SSLServerSocket(port,keyStore);  // Create a new socket and bind it to the port provided by JVM argument    sslServersocket = (SSLServerSocket)chanels;
             KeyManagerFactory kmf =  KeyManagerFactory.getInstance("SunKS");   /* Load client keystore*/     SSLServerCertificateExtention extn=(SSLServerCertificateExtension )kmf .getKeyManagers(); // Get the certificate Extentions for key managers        sslServersocket = (SSLServerSocket)chanels;
             TrustManagerFactory tmf =  TrustManagerFactory.getInstance("SunTS");  /* Load trusted certificates */   SSLServerCertificateExtention extn=(SSLServer Certificate Extension )tmf .getTrustManagers(); // Get the certificate Extentions for trust managers        sslServersocket = (SSLServerSocket)chanels;
             KeyStore ks =  KeyStore.getInstance("JKS");  /* Load client keystore */     SSLServerCertificateExtention extn=(SSL Server Certificate Extension )ks .getKeyManagers(); // Get the certificate Extentions for key managers        sslServersocket = (SSLServerSocket)chanels;
              KeyStore ts =  KeyStore.getInstance("JKS");  /* Load trusted certificates */   SSLServerCertificateExtention extn=(SSL Server Certificate Extension )ts .getTrustManagers(); // Get the certificate Extentions for trust managers        sslServersocket = (SSLServerSocket)chanels;
              chanel.accept() ; /* Accept client connection*/   InputStream is =  c.getInputStream());  BufferedReader br=  new buffereaedreader(is);    String str=null ""; // Read line from the input stream of server          while((str =br .readline()));// Send a response back to each connected user        
             } catch (Exception e) {      System.out "IOException was caught" ;  };       sslServerSocket.close();            /* Close socket and release resources*/    finally {} // Do clean up here if required     try{SSLContext sc= SSLcontext .getDefault(); chanel =(SSLSocket )sc.getServerSocket(port);       
             }   catch (Exception ex) {  System "IOException was caught"; };      sslServersocket - close() // Close socket and release resources if exception occurs         try{SSLContext sc= SSLcontext . getDefault();chanels =((SSLSocket )sc.getServerSocket(port));}catch