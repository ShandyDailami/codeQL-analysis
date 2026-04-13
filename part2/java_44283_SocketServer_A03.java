import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_44283_SocketServer_A03 {    
    private static final String CLIENT_KEYSTORE = "clientkeystore";   // Use this keystore to encrypt the client's ssl certificate during communication with server 
                                                        // You can generate a self-signed or custom one using Keytool utility in Java. Command: keytool -genkey -alias <your_server> -storepass password -keypass password   
                                                                                    // After that you will be able to use it for your keystore  and trust store (clienttruststore)    
   private static final String CLIENTTRUSTSTORE = "clienttruststore";         // Use this TrustStore file when client's certificate is not available during server start up.    Command: keytool -keystore <your_server>             --alias your-certificate –validity 3650  
                                                                                    // This will create a trust store with validity of certificates set as number days in "x days y months z years Q:Q" format      
    private static SSLServerSocket serverSocket;       
    
    public java_44283_SocketServer_A03(int port) {     
         try{            
              KeyStore clientKeystore = KeyStore.getInstance("JKS");   // Create a JKS key store for the clients using Bouncy Castle library to encrypt ssl certificate      
                                                            // Load keystores and truststores into memory – For example:     (KeyManagerFactory kmf = new AppletKeyStoreKeyManager(keystoreFile.toString(), password);    TrustManagerFactory tmf   =   ...)     
              clientKeystore .load(new FileInputStream("client_key"),"password".toCharArray() );  // Use the given keypassword to load it      
               SSLContext sslcontext = SSLContext.getInstance ("SSL");     // Create a new instance of an empty context   --> (SSLSocket socket  = ...)   
              KeyManagerFactory kmf   = ......;                            // Load clientKeystore into this manager factory using the given keypassword       –For example:        SSLServerSocket socket = ((SSLServerSocketImpl) serverSocket).create(kmf,clientTrustStore.getKeyManagers(),"TLSv1".toUpperCase());  
              TrustManagerFactory tmf  = ......;                            // Load clienttruststore into this manager factory       –For example: SSLContext sslcontext = ...     socket =  ((SSLServerSocketImpl) serverSocket).create(kmf,clientTrustStore.getKeyManagers(),"TLSv1".toUpperCase());
              KeyManager[] km  = ......;                                // Get the key manager from clientKeystore   --> (init keymanagerfactory = new PKIXTLSSocketFactory().createKeyManager(kmf));    SSLSocket socket =  ((SSLServerSocketImpl) serverSocket).accept(); ...........
              sslcontext.init( km , ...... );                          // Use the previously loaded key manager to init this context with clientKeystore     ..end;      }       catch (Exception e){ ...}        for (;;) {   try{ SSLSocket socket  = serversocket . accept() ;    BufferedReader in = new bufferingreader(new InputStreamsocket().getInputStream());  // Read the request from a remote host ......
              PrintWriter out=.......;                               } catch (IOException e) {}          finally       ...                  server.close();     return null;}   public static void main(String[] args){ SocketServer s = new .....}    This method is not invoked in this example, but you can use it as a template for your application 
              Note: You should replace the place holders with appropriate values and implement logic according to real-world scenario.   }     The server socket will listen on specified port number until client connects then start communication based upon SSL/TLS protocols between clients & servers using sslcontext, out object which is used for write response back from a connected user via established connection through Socket in read and print format..   
              You can extend this example to accept multiple connections with Threads or Multithreading. Also make sure you have Bouncy Castle library added into your classpath before running the program, here link https://www.baeldung.com/java-keystores for more details about adding it in java 
               This also covers basic SSL and TLS encryption using key stores with bc libraries..   }    Please note that due to sensitive operations like keys or passwords used while creating keypore store, they should be kept safe as per your requirements.     For real-life scenarios this kind of implementation can vary according to the use case at hand...