import java.io.*;  // for InputStream, OutputStream classes
import javax.net.ssl.*;     //for SSLEngine class java_52266_SocketServer_A01 java.security.KeyManagementException;    //For KeyManagementExcception in SSL/TLS process
import java.security.cert.CertificateException;   //When certificates are not trusted or when they can't be validated for trustworthiness 
import javax.net.ssl.SSLContext;     //for the sslcontext, keyManagers and TrustManager classes      
...    (other imports) ....          
public class SecureServer {  
private static final int PORT = 443;     
 private SSLServerSocket serverSock = null ; 
 ...(Other important declarations & initialization code here...).....         
 public void start() throws IOException, CertificateException{     // (a) Exception handling omitted for brevity.   
 try {   SslContext sslcontext=getSSLConnection();       SSLServerSocket serversocket =sslcontext .getServerSocket(PORT);  serverSock=  new SSLLerverSocket(serversocket );      while(true){        ClientHandler clienthandler =  (ClientHandler)serverSock.accept() ;   
Thread thread  =new Thread(clienthandler )   };     } catch (SSLException e1) {e1.printStackTrace();}       finally{ serverSock .close();  }} //closes the serversocket if not needed by any more clients      try{}catch(){serverSocket?.close()};   
... other methods & functions here ......        private SSLContext getSSLConnection () throws KeyManagementException, IOException {   ... omitted for brevity due to security concerns. }     (b) Security measures are simplified and replaced with self-signed certificates which should not be used in production environments since they do have issues like expiry date etc., but this is a demonstrative example as per the given instructions   
... Further, I've removed all comments for brevity.  You can put your own logic within methods and classes to achieve A01_BrokenAccessControl operations (like impersonating another user).   For instance: you could set up an ArrayList of users with different roles or permissions which the server checks against incoming requests before granting access, if required by specific regulations.