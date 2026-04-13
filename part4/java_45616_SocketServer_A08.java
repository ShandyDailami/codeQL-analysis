import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;
import java.net.*;
 
public class java_45616_SocketServer_A08 {
    private static final String CLIENT_AUTH = "ClientAuth"; // Trust self signed certs if enabled, use keytool command: keytool -selfcertificate <keyStoreFile> | sed '31q;.' > ca-file.txt   and trust this file using `cat ca-file.txt| xargs kill -9`
    private static ExecutorService executor = null;  // ThreadPool for handling connections, e.g., if you have a lot of clients connecting at the same time...
     
     public java_45616_SocketServer_A08(int port) {  
         SSLServerSocket serverSocket=null ;       
            try{               
                 String keyStorePath  = "path_to/your-keystore"; // Path to your keystore file, should be in .p12 format  OR use Keytool command: keytool -importkeystore <keyStoreFile> | sed '31q;.' > myKeystore.txt
                 String password = "password_for_your Keystore"; // Password for your keystore file (must match with the one in .p2 or p12 format)  OR use Keytool command: keytool -keypasswd <keyStoreFile> | sed '35q;.' > myPassword.txt
                 char[] passwordArray = "password_for_your Keystore".toCharArray(); // Password array for your keystore file (must match with the one in .p2 or p12 format)  OR use Keytool command: keytool -keypasswd <keyStoreFile> | sed '35q;.' > myPassword.txt
                 
                 SSLServerSocketFactory sslServerSocketFactory = null ;       
                      TrustManager[] trustAllCerts     =  new   TrustManager[]{new   X509TrustManager() {public X509Certificate getTrustedCertificate(String arg0, String arg1){return  null;} }};    //信任所有证书链          sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
                      KeyStore keyStore =  KeyStore.getInstance("JKS");         keystoreProperties  = new Properties() ;   keystoreProperties .put( "keystore.password", passwordArray )  //Key Store and Password are the same as in myKeystore file OR use a command : openssl pkcs12 -in <myKeysStoreFile>  | sed '3q;.' > keyPasswordAndfile
                      keystoreProperties .put( "javax.net.ssl.keyStore",   keyStorePath )  //Key Store and Password are the same as in myKeystore file OR use a command : openssl pkcs12 -in <myKeysStoreFile>  | sed '3q;.' > keypass
                      KeyManagerFactory kmf =  KeyManagerFactory.getInstance( "SunKSAPI" ) ;  ksP =kmf .getKeyStore()   // return the key store instance OR use a command : openssl pkcs12 -in <myKeysStoreFile>  | sed '3q;.' > myPass
                      kmf .init ( keystoreProperties , passwordArray ) ;  sslServerSocketFactory = new SSLServerSocketFactory(kmf, trustAllCerts,"TLSv" + CLIENT_AUTH.equals("ClientAuth") ? "TLSv1.2" : null)
                      serverSocket  =   (SSLServerSocket)sslServerSocketFactory .createServerSocket  ( port ) ;      // Create a new Server socket at given port and set up the SSL connection OR use Keytool command: keytool -listkeystore
              } catch(Exception e){    System.out.println("caught" +e);}   finally {if((serverSocket)!=null) try{ serverSocket .close() ;     executor !=  null ?  (executor ).shutdownNow();      println ("Server Stopped")      
            } catch(Exception e){ System.out.println("Caught exception closing the connection "+e);   }}    );}else {System.out.printf("%s%n", sslConnection .getInetAddress ());  try{sslSocketFactory = new SSLSocketFactory() ; println ("SSL Server Factory Created")     
            } catch(Exception e){ System.err.println("Failed to create factory " +e);   }}    };       // Main Method... the execution begins from here..        public static void main (String args []) {new SocketServer();  if(!executor .shutdown () ) executor
          = Executors.newCachedThreadPool() ;     System.out.println("Starting Server ...")   println ("Wait for client on port: " +PORT)       try{socket = (SSLSocket)sslSocketFactory    (.accept())  }catch(IOException e){System . out
          .printf("%s%n", sslConnection .getInetAddress());      System.out     .println("Exception occured in connection establishment"+e);   return; }} //... and it continues with the exception handling OR use try-catch to handle exceptions    } catch (IOException e) {
          println ("Server accept failed: " + sslSocketFactory ) ;  exit(-1)}                                                                                                                  };}}};