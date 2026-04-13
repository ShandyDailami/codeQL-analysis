import javax.net.ssl.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class java_46173_SocketServer_A07 {  // Define your own name for this server if you prefer a more descriptive one instead of 'Socket Server'  
    private static final Logger LOGGER = Logger.getLogger(MainClass.class.getName());
    
    public void start() throws IOException, SSLException{
        int port = 12345;  // define the server listening port here (your choice) - be creative about this number!  
        
        ServerSocket socket = new ServerSocket();         
        LOGGER.log(Level.INFO,"Server started on Port: {0}",port);   
            
            try{             
                SSLServerSocket sslServerSock= (SSLServerSocket)socket.accept();                    // Accepts incoming connections  
                                                                                                    
                  SSLContext ctx = SSLContext.getInstance("TLSv1_2");                        /*Creates an instance of the Tls server socket factory*/ 
                  
                 KeyStore ks =  new FileInputStream("/path/to your .keystore file")); // replace '/path' with actual path to keystore  
                  String password = "yourpassword";                                //replace 'yourpassword' and './key.store passphrase'(if any) are the same 
                  
                 sslServerSock= (SSLServerSocket)(ctx.getServerSocket(sslServerSock));     /*Binds Server socket to port number*/   
                  (( SSLServerSocket )sslServerSock).setNeedClientAuth(true);         // Requires client authentication  
                                                                                                     
                KeyStore truststore = new FileInputStream("/path/to your .keystore file"));  /// replace '/path' with actual path of the Trust Store and password, same as key store passphrase.   
                 sslServerSock  = (SSLServerSocket)(ctx.getServerSocket(sslServerSock));     /*Binds Server socket to port number*/   // Bind server Socket 
                                                                                                    
                SSLCertificate certificate = new FileX509Certificate("/path/to your .crt file");    /// replace '/path' with actual path of the Cert and Key Store passphrase.        
                  sslServerSock  = (SSLServerSocket)(ctx.getServerSocket(sslServerSock));        /*Binds Server socket to port number*/  // Bind server Socket    
                                                                                                    
                SSLCertificate trustCert = new FileX509Certificate("/path/to your .crt file");   /// replace '/path' with actual path of the Trust Store and password, same as certificate store passphrase.   
                  sslServerSock  = (SSLServerSocket)(ctx.getServerSocket(sslServerSock));          /*Binds Server socket to port number*/  // Bind server Socket    
                                                                                                    
                KeyManagerFactory kmf = new KeyStoreKeyManagerFactory("mykeystore",password,"mykey");   /// create a key store manager that uses the specified keystore and password for client authentication.   
                  sslServerSock  = (SSLServerSocket)(ctx.getServerSocket(sslServerSock));          /*Binds Server socket to port number*/  // Bind server Socket    
                                                                                                    
                SSLContext ctx1 = SSLContext.getInstance("TLSv1_2");                    /// Create a Tls Client factory with the same keyStore,truststore and password as for client authentication    sslSocketCli  = (SSLSocket)sslServerSock .accept();  // accept an incoming connection at server port    
                  SSLSession c = ctx.getClient(sslSocketCli);                          /// Retrieve a Secure Session from the remote side of socket and get client authentication status    sslCertificate  = (SSLCertificate)c.getRemoteCertificate();   // Get certificate on connection at server end 
                                                                                                    
                LOGGER.log(Level.INFO,"Client Cert : {0}",sslCertificate);                  /// Log the retrieved SSL证书     x509certificates = sslSocketCli .getEnabledProtocols ( );                   -- Print enabled protocols   // Enable protocol by getting certificate from client side
                                                                                                    
            }catch(Exception e){      LOGGER.log(Level.SEVERE,"Error accepting connection or processing data",e);  return;    };           /*Close connections and exit gracefully on any error*/     finally {socket .close();};   // Close socket in the end         }}        ;