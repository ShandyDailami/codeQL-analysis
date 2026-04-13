import javax.net.ssl.*;
import java.io.IOException;  
import java.nio.charset.StandardCharsets;
import java.security.cert.CertificateException;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class java_49308_SocketServer_A08 {   
     private static final Logger LOGGER = Logger.getLogger(SSLServer.class .getName());  
      
      public void startServer() throws IOException, CertificateException{       
          //Create KeyPair for server and client side using java keytool: 
           /*keytool -keystore keystorefile name_of_alias password pwd */   
         System.setProperty("javax.net.ssl.keyStore", "myKeystore");  
        System.setProperty("javax.net.ssl.keyStorePassword","password1234567890);  //must match the keystore password     
          System.setProperty("javax.net.ssl.trustStore", "myTruststore") ;   //name of trust store    
         System.setProperty ("javax.net.ssl.trustStorePassword","password1234567890");  //must match the password     
           int port = 8888;   
          SSLServerSocket serverSocket = null ;  
             try {               
                   serverSocket= (SSLServerSocket) new SSLServerSocket(port,null);             
                 LOGGER.info("Waiting for client on port "+serverSocket.getLocalPort());  //line:maintainer :10                 
                    Socket socket = null;                    
                      try {                           
                          socket= serverSocket.accept();      
                           SSLSocket sslSocket =  (SSLSocket)socket ;                      
                         LOGGER.info("New client accepted from "+sslSocket.getRemoteSocketAddress());  //line:maintainer :12               
                        HandshakeHandler handShake = new HandshakeHandler();   /*must extend DefaultHandshake */             
                          sslSocket .setHandshakeTimeout(60 * 1000);    if(!sslSocket.isServerSide()) {          //hand shaking      false : true                   
                             SSLContext sc =  SslContextBuilder          
                              .create()                     /*SSL Context*/                      , new String[]{"TLSv1"}, ((SecurityManager)null),  24* 60 *   1000,"RSA")    
                               //line:maintainer :35                    ;         }                                else                          {                 SslContext ssc = (SslContext ) SSLServerSocketFactory.createDefault(new KeyStore(), null, new TrustManager[]{}, SecurityManager );        sc =  ((SSLContext)ssc).getClientContext();     };      
                             HandshakeRequestHandler requestHndlr= handShake ;          sslSocket .setHandshakeHook (requestHndlr);                                              //line:maintainer :42         } catch(Exception e){ LOGGER.log(Level.SEVERE,"Error in SSL Communication",e) 
                           };                      finally { if(socket != null ) socket .close();     sslSocket   .close();}}}}}      catch (SSLHandshakeException | CertificateException  | IOException ex)       //line:maintainer :53          }catch (CertificateException e){ LOGGER.log(Level.SEVERE,"Error in certificate",e);    }}