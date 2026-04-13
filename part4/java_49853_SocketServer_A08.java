import javax.net.ssl.*;
import java.io.*;
import java.util.logging.*;
import java.security.*;
import sun.misc.*;
public class java_49853_SocketServer_A08 {  
    private static final Logger LOGGER = Logger.getLogger(SecureSocketServer.class.getName());  // for logging the messages in server side      
     public void start() throws IOException, KeyStoreException{        
        SSLServerSocket sslServerSocket=null;         
           try {            
                // Create a key store using Sun's own sample keys  
               KeyStore ks = KeyStore.getInstance("SunMWRL");     
               InputStream ins = getClass().getResourceAsStream("/keystore/sampleKeystoreKeyFile_2048.jks", false);          
                //load the key store      
               ks.load(ins, "password".toCharArray());        
             LOGGER.info("SSL Server started");  
              sslServerSocket = new SSLServerSocket(sslServerSocket,(KeyStore)null ,new TrustManager[] {    
                    null}, HostPortProbeStrategy.getInstance()  );      // create the server socket with port number and a custom       trust manager for client certificates   
             while (true){           try{              Socket s =s slServerSocket .accept();               SSLSocket ss=(SSLSocket) s.getNativeSocket();          HandshakeShock h;         //create handshaek shake with socket connection to accept       incoming request      SSLEngine se  =ss.getSSLEngine ();       
              LOGGER.info("Client accepted");               Se ss=(SecureServerSocketImpl) sslserversocket .accept();   }  catch     {LOGGER    (.log (#, e));}catch finally{s..close()}}                //finally block is used to close the socket connection      
             }}          unsupportedOperationException           (){      @Overridepublic void run(){ for(;;)new HandshakeShock();}}}            try     {              SSLServerSocket slserversocket = newSSL Server Socket("127.0., 843",null);}catch Exception e{LOGGER .log