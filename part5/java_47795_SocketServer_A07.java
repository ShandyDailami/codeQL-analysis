import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import sun.security.x509.*;
  
public class java_47795_SocketServer_A07 {   
     private KeyStore ks;  // Keystore to bind SSL certificate into it is required for client authentication via keytab/certificate file or directly from keystores which are trusted by clients (e.g., Java truststore) and CAs(Certificates Authorities). Here we will use built-in cert store of java
     private KeyStorePasswordCallback ks_pass; // Password callback to set the password for key Store, Required while using keystore 
      
      public java_47795_SocketServer_A07() throws Exception{  
           TrustManagerFactory tmf = new TrustManagerFactory();    //Creating trust manager factory and adding our custom trusted cert.    
          KeyStore ts  =KeyStore.getInstance("JKS");        ///Initializing a JAVA KETSTORE  here we are assuming that keystore is in .jks format   which stores client-side certificate, private key information of SSL enabled server and Certificate Authority (CA) certificates to be used by clients for authentication.
          ks  = ts ;    //Reference our Key Store    
           FileInputStream fin= new  FileInputStream("MyKeyStore");//Here Mykeystore contains the trusted CA'cert(iOS, Mac OS etc).   PLEASE replace it with your certificate path (use keytool -list -keystore <path> to find where you stored them)   
          ts .load(fin , "mypassword".toCharArray() ); //Password of KeyStore and its alias  here we are assuming that keystore is in JKS format.   replace this with your password    
           tmf .init(ts);                  /// Initialize trust manager factory using key store    Here We have added custom trusted cert, so adding it to the TrustManagerFactory's list     
          SSLServerSocket sslSock = new  SSLServerSocket((SSLServerSocket)null , null   ,tmf );//Creating an instance of our server socket here we are setting up port number and using trust manager factory which is already initialized.    replace this with your assigned values     //Increase the protection by adding more security measures like AES, Blowfish etc
          System.out .println("Wait for client connection ... ");      ///This line will show that our server waiting to accept a new connections   It must be in while loop else it may cause memory leaks    replace this with your value     //Increase the protection by adding more security measures like AES, Blowfish etc
          Socket sock =sslSock.accept();      ///Accepting clients connection here we are accepting new connections and get a socket from server   It must be in while loop else it may cause memory leaks    replace this with your value     //Increase the protection by adding more security measures like AES, Blowfish etc
          System .out.println("Connection accepted... ");      ///This line will show that client is connected to our server  It must be in while loop else it may cause memory leaks    replace this with your value     //Increase the protection by adding more security measures like AES, Blowfish etc
          sock .close();       ///Closing connections here we are closing all clients after they have done their work and disconnect them  It must be in while loop else it may cause memory leaks    replace this with your value     //Increase the protection by adding more security measures like AES, Blowfish etc
      }  
       public static void main (String args[] ) throws Exception { new SocketServer();} ///Main Method Calling our class method here we are calling or initiating of object methods    replace this with your value     //Increase the protection by adding more security measures like AES, Blowfish etc 
 }