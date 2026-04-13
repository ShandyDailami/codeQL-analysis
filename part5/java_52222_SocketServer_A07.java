import java.io.*;  // Import Input/Output Streams  
import javax.net.ssl.*;    // Required classes to create a secure socket listener    
import sun.security.util.SSLUtils;     
        
public class java_52222_SocketServer_A07 {         
        public static void main(String[] args) throws Exception      
        {            
            SSLServerSocket serverSocket = null ; 
                  try{                     
                KeyStore keyStore=KeyStore.getInstance("JKS");   //self-signed certificate                    
               keyStore.load(new FileInputStream("/path/to/yourcertificate"),"password".toCharArray());             
             TrustManagerFactory tmf = new JettyTrustManagerFactory();  /*Custom trust manager for SSL*/     
            KeyManagers kmf=new KeyManagers(){                     @Override public KeyManager[] getKeyManagers() { return null;}} ;    // no keystore        
               sslContext  = SSLServerSocketFactory.createServerSocketFactory(). createServerSocket(8443);          /*Create server socket using port 80 */     m_sslContext =SSLServerSocketFactory . createDefaultSSLServerContext (keyStore, "password".toCharArray(), tmf );        
               System.out.println("Starting Server at Port: :" +  sslContext  =  new SSLServerSocket(m_socket).getLocalPort());  /* Get local port */                m_sslConnection =null;          serverSocket =  (SSLServerSocket)sockitmlcontext . getTransport();
                       }catch Exception e{         System.out.println("Exception occured: " +e);}             };           catch(IOException ioe){System out! IOException  ioexceptions, uper then  1024 and the server is not running on port from where your application runs      return;}}