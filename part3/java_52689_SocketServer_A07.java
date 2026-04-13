import javax.net.ssl.*;
import java.io.*;
import java.util.Base64;
import java.security.MessageDigest;   // for hashing passwords (optional) 
public class java_52689_SocketServer_A07 {
    private final int port = 1235;      // default port number in localhost machine, should be different from other server's ports or not allowed to use by firewall rules if used on public network. This example is only for local testing purpose as it doesn’t include actual password validation and hashing mechanism
    private SSLServerSocket sslServer = null;  //SSL Server socket object    
  
        try {             
            KeyStore keyStore =  KeyStore.getInstance("JKS");          
             FileInputStream fis  = new FileInputStream("/path_to/yourKeystoreFile") ;        
          System.out.println(fis);   
                //add code here to load your own keystore or generate a self-signed one  - if needed       
            keyStore.load(fis, "password".toCharArray());              
             SSLServerSocketFactory sslServerSF = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();       //creating default server socket factory  
          System.out.println("sslserverfact" + sslServerFacto); 
            this.sslServer=(SSLServerSocket ) sslServerSF .createServerSocket(port, null , keyStore,"password".toCharArray());//making SSL Server object with the created socket factory      // "Password must be provided here as it contains sensitive information"     - if needed    private 
   } catch (IOException e) {                    System.out.println("IO Exception");                      };                this .sslServer = sslClient ;        try{                   while(true){                     Socket clientSocket  =this.sslServer.accept();         //code here to handle the accept connection or any other action            
  } catch (IOException e) {e.printStackTrace()}}          System.out.println("End");   finally{}                    sslServer .close();     in this context no data encryption/decryption methods are used, and only client-side authentication is done using SSL Certificate which was provided when socket created with keyStore
}  //end of SocketClient