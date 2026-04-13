import javax.net.ssl.*;
import java.io.IOException;  
 
public class java_42396_SocketServer_A08 {    
    public static void main(String[] args) throws IOException, SSLException{        
        // Create a KeyStore that contains the Certificate and Private key for our server            
            char[] password = "password".toCharArray();          
                KeyStore ks = KeyStore.getInstance("JKS");  
                    ks.load(Thread.currentThread().getContextClassLoader()  // load from classpath    
                            .getResourceAsStream("ssl_keystore"),            password);            
        // Create a truststore that contains Certificates of trusted CAs for our clients          
                KeyStore ts = KeyStore.getInstance("JKS");  
                    ts.load(Thread.currentThread().getContextClassLoader()  // load from classpath    
                            .getResourceAsStream("ssl_keystore"),            password);      
        TrustManagerFactory tmf    = new JdkTrustManagerFactory();      /*Create a factory for our trust manager*/        
                SSLServerSocket sss = null;         
                    try {                       // Create an instance of the server socket and bind it to port 8095                         
                        KeyManagers kms          =new KeyStoreKeyManager(ks,"password".toCharArray());     /*Create a key manager from our keystore*/        
                                sss = new SSLServerSocket(null,kms.getKeyManagementStrategy(),1234); //bind to the port we specified and use km as ks            for server socket                 (new JettyAcceptor())        );      } catch {}  f    /*catch block*/          
                    finally {sss = null;}          if(null != sss) try{ ss  =  ((SSLServerSocket)ssl).getSSLEngine().getSessionContext()               .createContext ( "userlogin" + "_session_reused" ,                                                  SecureRandom.getInstance("SHA1PRNG"));          
                        while (!(new SSLCertificateRequest(_clientHelloVerifier,sss)).equals (_requestedState)) { }            ss = new BufferedWriter  IO      ( sockets[i] .getOutputStream () ) ;               try{ SSLEngine   _engine        =                                                   getInstance ("SSLv3")    // create an engine instance.        SSLParameters parameters = 
                            ciphersuite                    + "TLS_SERVER_AUTHENTICATION_KEY" +                                  sss .getSessionContext () ,     null             );          try  { SSLEngine   _engine= getInstance (ciphersuite, true) ; } catch {}       if(null != 
                            ss){}           //try to connect client            SecureSocketClientConnection c = new                SSLSecureSocketClientConnection      (_server.getInetAddress(),sss);                  try { BufferedReader br=new InputStreamReader (c . getInputStream () ) ;     while (( str =  br   
                            .readLine()) !=  null)           System             . out            . println  ("Message Received on port" + i   );}} catch {}       if(null == ss){}          //if not connected to client,close connection        c. close(); }});     finally {}}};