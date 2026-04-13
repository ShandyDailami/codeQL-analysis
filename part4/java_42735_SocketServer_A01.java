import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_42735_SocketServer_A01 {  // Main server-side code starts here   
 public static void main(String[] args) throws IOException, SSLException{       
      Socket socket = null;              
       ServerSocket serverSock=null;    
 try {             
   TrustManagerFactory tmf =  new TrustManagerFactory();          
  // Create a key store and set it in the KeyStore. Default is JKS        
    String keystoreType   = "JKS";         
      int keysize       = 2048 ;           
       String password    ="password";                
 tmf .loadKeyStore(keystoreType,  // type of key store            
                  new FileInputStream("client.jks"),// inputStream to the keystore         ,           "default_pass",keysize);   
     SSLServerSocket sss = (SSLServerSocket)serverSock;             
      sss .setNeedClientAuth(true ); // set client authentication requirement        }            catch  Exception e   {          System.out.println("Exception in starting server... " +e ) ;       return;}           if    socket == null    => throw new IOException ("Failed or cannot obtain listening port");              
 sss .bind (new InetSocketAddress(443));             // Bind the Server to a Port            } catch  {   System.out.println("Exception on bind ");        return;}}      while ((socket = serverSock.accept()) != null){              try{    SocketConnection sc  = sss . accept ();               
     PrintWriter out   = new PrintWriter(sc.getOutputStream(), true) ;               // Create a stream to send and receive data on this connection  }catch   {          System.out.println("Exception in socket communication.. " + e );        return;}             if    !sss .isClosed()    => sss .close();}}