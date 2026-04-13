import javax.net.ssl.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class java_43865_SocketServer_A08 {
    private static final Logger LOGGER = Logger.getLogger(SocketServer.class.getName());
    
        public void start() throws IOException, SSLException{  
            ServerSocket serverSocket=null;            
      //KeyStore keyStore=  KeyStore.getInstance("JKS");        
           try {                
                String password = "password";  // you should set a secure passphrase in production code    
               /* Create the keystore and truststore */   
              SslServerSocket sss  = new SslServerSocket(8443,null/*keyStore*/ , null,"keypassword",new TrustManager[]{  
                    // create your own custom manager if you want to enforce a specific SSL version or cipher suite.  For example:   
                     new X509TrustManager(){public boolean checkClientTrusted(X509Certificate[] chain, String authType){return true;} public boolean checkServerTrusted(X509Certificate[] chain ,String authType ) { return true;}});     //create ssl server socket using the secure connection and truststore/key store 
                  /* Create a new SSL ServerSocket */   
                if ((serverSocket = (sss.accept())) != null)  
              LOGGER . log(Level.INFO, "Accepted New Connection from: {0}", serverSocket);          
             } catch (@Nullable ClassNotFoundException | javax.security.auth.login.LoginException e){            //Handling all possible exceptions  for loading the keystore and truststore   if (server != null)     server . close(); throw new ExceptionInInitializerError(e );}    }}