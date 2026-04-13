import java.io.*;
import java.net.*;
import java.util.concurrent.*;
import javax.net.ssl.*;
import ch.qos.logback.classic.Level;
import org.slf4j.LoggerFactory;

public class java_47909_SocketServer_A01 {  
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(SSLServer.class);  // SLF4J logging mechanism by logback framework, not external library requirement        
    
       public void start() throws IOException{     
        ExecutorService executorservice=Executors.newCachedThreadPool();         
           SslServerSocketChannel channel = null;   
               try {                // SSL Server Setup                 
                     KeyStore keyStore =  new FileInputStream("mykeystore");            
                    char[] passwords  = "password".toCharArray() ;  
                   TrustManagerFactory tmf   =new  JSSECTrustManagerFactory(keyStore,passwords);   
                                         SslContext context =SslContextBuilder.create().loadKeyMaterial( keyStore,"mypassword" ,tmf ).build();    
                     SSLServerSocketChannel channel  =SSLServerSocketChannel.open();                   //Create a server socket Channel          
                    channel .configureBlocking(false);    /* Setting non-block mode */        
                      CloseableChannel ch =channel;  ///create client to connect with the created connection            
                        SslHandler handler= new SSLEngineClientHelloHandler("SSLv3/TLS");   // SSL Handler for Client Hello Request                  
                     channel.bind(new InetSocketAddress (8095));     /* Bind port number */       return;      }  catch (Exception e) {LOGGER .error ("Caught Exception ",e);}}               finally{if ((channel != null)) ch.close();    }}                  
public static void main(String[] args){SSLServer ssl = new SSLServer() ; try   {"Starting the server" };catch  (IOException e) {LOGGER .error ("Exception caught while starting",e);}     finally{s.start();}}            }