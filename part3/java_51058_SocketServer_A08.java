import javax.net.ssl.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.util.stream.Stream;
  
public class java_51058_SocketServer_A08 {    
    public static void main(String[] args) throws Exception {        
        SSLServerSocket sockets = createSSLServersocket();              
          
            try (SSLSocket socket = 
                  ((SSLServerSocket)sockets).accept())  // accept connection from client  
          {            
              System.out.println("Client Connected ");                  
                       
                BufferedReader in = new BufferedReader(new InputStreamReader((socket.getInputStream())));              
                              
                      String line;                        
                           while ((line=in .readLine()) !=  null)  {                      
                              System.out.println("Received: " + line);              // read the message from client  
                          }    
            } finally{    socket.close();}        
        sockets.close();            
       }}          
          public static SSLServerSocket createSSLServersocket() throws Exception {  /* This method will be used to establish a secure connection */      // Create the server-side SSLeSocket object with port number:  12345 on localhost    
        SslServerSocket = (SSLServerSocket) initSock(new int[] {}, "localhost", new InetAddress("127.0.0.1"), 12345);    // Bind the socket to this port number          return sSLServersocket;    
      }   public static SSLServerSocket initSock (int [] ports, String hostname ,InetAddr addr_receive) throws Exception {        /* establish a secure connection */  Port=ports[0];            Inetsocketserver.bind(sSlserversocctiomt,(port));    
       return sslServersocket;    }}}   // this is the server side socket object, which will accept client connections indefinitely         private static SSLServerSocket SSlserversocket = null ;        KeyStore keystore=null  /* A keystore where our certificate and private keys are stored */            
       try {KeyStore ks =  Kle("SSL","key.jks");      // create a new instance of the Java Keystone   } catch (Exception e){e .printstacktrace();}    TrustManagerFactory tmf =null;        KeyPair key ;  private static final int SOCKET_PORT=12345, SERVER_SOCKET_PORT= 8096 ,KEYSTORE_PASSWORD =  "password", KEY_PASSWORD  ="keypassword";    
       String ALGORITHM = "SunRSASHA1";  // Cipher and Mac algorithm      try {ks=KeyStore.getInstance("JKS","Standard charsets utf-8");   ks .load(new java.io,FileInputStream("/ssl/keystore"),KEYSTORE_PASSWORD.toCharArray());       
       tmf = new PKIXTrustManagerFactory().loadTrustManagers();      KeyPairGenerator keygen=null;  try {ks=  Kle("SSL","KeyStore");     ks .load(new FileInputStream("/ssl/keystore"),KEY_PASSWORD.toCharArray());   
       cipher =  Cipher.getInstance (ALGORITHM);   } catch {} //catch block for exception handling  */         try {keygen= KeyPairGenerator.getInstance("RSA");      key =(Key) keygen .generateKey();     socket.setEnabledCipherSuites
! [new  CipherSuite[] (SSL_300,TLS_SSLv2 , TLS_1065 ...)]    ciphers=cipher..getAdequateTraffic(null);          } catch {} //catch block for exception handling     try {socket .startHandshake();}//hand shakes happen here.
       return sslServerSocket;  }}   */}}}}}      /* End of code snippets above are my creative solutions, I hope you find them helpful and that they meet your criteria eclipse will provide no comments or explanations on the solution as it's all in a Legacy style due to context-sensitive requirements.