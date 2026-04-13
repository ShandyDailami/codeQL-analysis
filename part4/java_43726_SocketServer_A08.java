import java.io.*;   // Import required Java packages   
import javax.net.ssl.*;   // For SSL related classes    
import java.security.*;      // Provides a key store, KeyPairGenerator etc..      

public class java_43726_SocketServer_A08 {  
// Start of the server code... 
private static final String KEY_STORE = "mykeystore";   
 private static final char[] KEY_PASSWORD = 's'.toCharArray();     // Store password for KeyStore     
      
 public SSLServerSocket createSSLSocket(int port) throws IOException {  
         FileInputStream fis =  new  FileInputStream (KEY_STORE);        /* Here, we assume that the keystore is in .jks format */   
          KeyStore keyStore = KeyStore.getInstance("JKS");      // Create a Java Keystore instance    
           try {  
               keyStore.load(fis , KEY_PASSWORD );  // Loading our stored password into the keystore, this is necessary while loading from file   
          } finally{       /* closing FileInputStream */         fis .close();       
                  }     
            KeyManagerFactory kmf = null;   KM
 public SSLServerSocket createSSLServer(int port) throws IOException {     return (SSLSocket) keyStore.getDefaultCertificate().createChannel();  // Here we are assuming that the default certificate is already set in our keystore */    }       /* End of code snippet...*/  
}