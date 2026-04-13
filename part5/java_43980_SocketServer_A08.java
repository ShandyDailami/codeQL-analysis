import javax.net.ssl.*;
import java.io.*;
import java.security.*;
import java.nio.charset.StandardCharsets;
import sun.misc.IOUtils;
  
public class java_43980_SocketServer_A08 {
    private static final SSLServerSocket serverSocket = null;  //SSL Server socket object created using default key and certificates (if not provided in constructor)
    
      public void start(int port, String cafilePath, String keypath ,String certpath){  
        try{      
            KeyStore keyStore=KeyStore.getInstance("JKS");          //Create a JKS store to protect our SSLServerSocket          
              keyStore.load(new FileInputStream (keypath), "password".toCharArray());  /* load the privatekey and certificate */  
            
               TrustManagerFactory trustManagerFactory = TrustManagerFactory .getInstance(TrustManagerFactory .getDefaultAlgorithm());    //Create a DefaultLocker object for server to use when verifying client certificates    
              trustManagerFactory.init(new java.security.KeyStoreReader (cafilePath));  /*Load the Certificate Authority from file*/  
               SSLServerSocket sslServer = new SSLServerSocket(port,null ,keyStore ,trustManagerFactory);    // Create a Server socket with our specified port and key/cert pair    
              System.out.println("Secure Socket server started on " + Integer.toString (sslServer .getLocalPort())  +" port");   /* Print out the local Port */ 
             while(true){      try{    // Wait here until a client connects to our socket       
               SSLSocket csocket = sslServer.accept();     System.out.println ("Accepting connection from " +csocket .getRemoteSocketAddress());       SecureReader secureReader =  new   SecurityManager().wrap(new BufferedReader (new InputStreamReader((csocket . getInputStream()),"UTF-8"))); 
                  String message = "";        while ((message=secureReader.readLine())!=  null){          System.out.println("Received: " + message );}}       catch   Exception e{e.printStackTrace();}     }            sslServer .close ();    }}           // if exception occurs, it will be caught and handled here               
 public static void main(String args[]) { new SecureSocketServer().start(443,"mycertificates","myprivatekey", "client_truststore");}}  /* Here is how you start the server */    catch (Exception e){e.printStackTrace();} }}}}