import javax.net.ssl.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.*;
   import org.apache.commons.io.IOUtils;    // Apache IO Utils for basic input/output operations 
    
public class java_51357_SocketServer_A01 {       
       private static final int PORT = 12345;        
         
      public void start() throws IOException, NoSuchAlgorithmException, KeyManagementException{             
           SSLServerSocket sslServer = null ;               //SSL Server Socket           
                 try  {            
                       System.out.println("Starting Secure socket server on port " +PORT);   
                  ExecutorService executorservice =  Executors.newFixedThreadPool(50 );   // thread pool to manage the connection request         
                   sslServer = (SSLServerSocket) new SSLServerSocket( PORT , null,null  ) ;            
                    while(!sslServer.isClosed()) {                      
                            SSLSocket clientSocket =  ((SSLServerSocket) sslServer).accept();   //Accepts the connection requests                         
                             System.out.println("Connection established with " +clientSocket);      
                              executorservice .execute(new SocketHandlerThread (  clientSocket ) );             }                    finally {     if (!sslServer.isClosed()) sslServer.close();}            }} catch (IOException e)   {}catch (SSLException se){se.printStackTrace() ; // Handle SSL exceptions   
      public static void main(String[] args) throws KeyManagementException, NoSuchAlgorithmException , IOException  {           Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());        new SecureSocketServer().start();     }   }}  `