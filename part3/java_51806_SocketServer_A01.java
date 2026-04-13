import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;
import java.nio.charset.*;

public class java_51806_SocketServer_A01 {
    private static ExecutorService executor;
    
    public static void main(String[] args) throws Exception{ 
        //SSLContext creation and configuration for TLS  
       SSLServerSocketChannel sslServer = null ;         
      try (SSLServletContext servletCtx = 
                  SslContextBuilder.create()             .loadKeyMaterial("keyStore", "password".toCharArray())   
                      .build(new X509CertificateConsumer())) {  // Load the private key material  
            sslServer = SSLServerSocketChannel.open();       
               } catch (Exception e)                   throw new ExceptionInInitializerError("Failed to create server socket channel.");    
             executor =  Executors.newCachedThreadPool() ;          void handleClient(SocketConnection conn ) throws IOException;    try {   for (;;)  sslServer .acceptedSessions().handle((session, e) -> session == null ? Thread.EOF : ()->  socketConnect= 
              SocketChannel chan= (socketconnect).getRemoteSocket();         // Accept new connections     if(chan!  =null ) executor    .submit(()  => handleClient  ((SSLServerSocketChannel)(sslserver)))); } catch      { e.printStackTrace() ; System..exit(-1); }}      
}