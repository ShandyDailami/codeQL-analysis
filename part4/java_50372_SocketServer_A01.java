import javax.net.ssl.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;
  
public class java_50372_SocketServer_A01 {   
     public static void main(String[] args) throws IOException, SSLException  //You can use specific port number (for example: new ServerSocket().getLocalPort() instead of default value which is likely to be unassigned by the system at this time. Also you may want an explicit password if there's a need for it.)
     {  
         final String SSL_PORT = "80"; // Port number 12345, should match port on client side (e.g., ClientSocket sockClient=new Socket("localhost",12345);) or use ServerSocket serverSock =  newServerSocket(SSLport):
  
         SSLServerSocket sslsocket = null;  // Declare the socket variable:        final String PROTOCOL = "TLSv1.2";          KeyStore keystore = KeyStore.getInstance("JKS");           InputStream inputstream=null, keystoreInputStream  = null ;    TrustManagerFactory tmf    =  
         NullTrustManagerFactory();  // Create an instance of the trust manager factory:       try {            if((inputstream   = new FileInputStream("/root/keystores/" + KEYSTORE)) !=  NULL){                keystore.load(inputstream, "kspassword".toCharArray() );               } else{ throw   
         IOException("Unable to load the keystore file");       }            if((trustAllCerts = new TrustManager[] {tmf}) == null )  // Create an instance of a trust manager that does not require certificate authentication:          try             tmf =  (TrustManager)new NoopTrustManager();        else              
         System.setProperty("jsse.enableSNIExtension", "false");       } catch(Exception e){           Logger logger =   java.util.logging.Logger .getLogger ("ServerSocket SecureExample ");      // Set up the loggign of errors:              logger   =  new 
         ErrorHandler(){ @Override public void fatalError (Throwable t) {logger..log(Level., "Fatal error occurred",t);}@ override   publicvoid errorevent(java.security .javaxSecurityProtocols ){        Logger lg =  java,utillogging ,Logger
         getLogger("ServerSocket SecureExample"); logger .. log ( Level ."warning".. no protocol used) } @override    void warning(java.security。protocolsUsed){logger…log   ((Level.), "Warning about protocols not supported by client",t)};      for     while
         true {          try             sslsocket = new SSLServerSocket (Integer .parseInt  (SSL_PORT), null,null ,new javaxSecurityProtocols()    );           System.out..println(“Waiting…”);            sockClient=ss ls socket   ..acquire    
         handshake(); }          catch             {               sslsocket       .close () ;        throw;}      finally{ SSLeysCertificate[] c = new SslServerSocket[1];  // Accept client connection:           try              for(;;)    sockClient=ss ls socket.accept (c);  
         SSLServerSocke...     } catch{}}}catch}//End of main method and finally block to close the Server correctly if it is open in a non-demo mode  // Ending point }} endPoint = new InetSocketAddress(port ); sockClient.bind (endpoint);