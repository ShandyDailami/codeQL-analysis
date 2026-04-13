import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;
import java.nio.charset.StandardCharsets;
import org.apache.commons.codec.binary.Base64;
public class java_44635_SocketServer_A01 { 
    private static ExecutorService executor = Executors.newCachedThreadPool();  
     public static void main(String[] args) throws Exception{            
          int port = 8091 ; // the same as in ServerSocket          
         SSLServerSocket serverSocket = null;      
            try { 
                trustStorePassword("truststore");    ///< change this with your keystore password     
                  KeyStore keyStore=KeyStore.getInstance(KeyStore.getDefaultType());    
                 // Load a Trust Store containing certificate authorities  
                    keyStore.load(new FileInputStream("/path_to/yourkeystore"), trustStorePassword("truststore").toCharArray()) ;         
                   // Create an SSLServerSocket  (Explicitly set the port we wish to listen on, using any available port)          
                  serverSocket = new SSLServerSocket(port ,keyStore,(SSLContext)null);      
                      System.out.println("Waiting for client connection..." );     
                    while((serverSocket)!= null){         // We are going infinite here until our program is closed        try {    
                          Socket clientSocket = serverSocket .accept();   }  catch (IOException e)    {} finally{ if(null !=  serverSocket )try { ServerSocket sss  = ((SSLServerSocket)serverSocket).getShared() ; ss.close();}catch (IOException var10){}}        
            // here is the part where client connects and reads from it, same for writing to socket          } catch {}        System . out  . println (" Exiting ")           return;     }}    private static String trustStorePassword(final char[] password) { try{   TrustManagerFactory tmf =     
>TrustManagerFactory.getInstance(KeyManagementStrategy.getDefaultAlgorithm());       KeyStore keystore=tmf.getKeyStore();         PasswordAuthenticationStrategy pasw     =  (PassAuthenticationStrategy)( new javax .net    .ssl  .PasswordAuthenticationStrategy() { public boolean getRequestedPasswordainterface   ()     
>{ return true;}});Keystore charakter =(CharArray)password ;        keystore.load((InputStream )new java .io。Streams..read (charakter),     passw );  tmf   =  new TrustManagerFactory();       //We set the required algorithm to our factory     
tmf   .init ((KeyStore)(keystore));         return;}} catch(Exception e){ System.out.println("Error: "+e); }return;}        };