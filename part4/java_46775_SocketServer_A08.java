import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import sun.security.x509.*;

public class java_46775_SocketServer_A08 { 
    private static final String ALGORITHM = "AES";   // AES or DES is the algorithm used here, choose according to your needs (more CPU power for faster security)
    
// Method that will be called when a client connects. This method uses SSL/TLS and checksum calculation in order not only secure but also handle integrity failure 
    public static void processRequests(Socket socket){   // Socket is the connection between server & clients, it represents communication end point of two ends (client or other servers).    
        try {      
            SSLServerSocket sslServerSock = new SSLServerSocket(socket);         
            
// Loading trusted certificate from file. This should be done only once when your application starts and can cache the result so you don't load it every time a client connects 
           CertificateFactory cf = new X509CertificateFactory();         // Here we use sun internal class to fetch certificates, change with any external certificate manager if required.  
            String cname="";    char[] password=null;      boolean debug=false ;     KeyStore ks =  null  ;       SystemKeyStore tks = new JKSKeyStore();        try {               X509Certificate cert  = (X509Certificate)cf.getCertificate("src/certificates/" + cname);
                sslServerSock . setNeedClientAuth(true );             if(! cf.isCertificateRevoked ("MyCACert",  "CN="+cname, cert)){                  KeyStore ts = CertificateManager._loadKeyStore (new File("src/keys/" + cname), password);             
                sslServerSock . setKeyStore(ts );                   tks.setKeyEntry ("localhost","MyCACert",cert,"changeit".toCharArray(),"SHA1PRIVATEKEY"); ks=tks;                  TrustManagerFactory trustMF = new JKSX509TrustManagerFactory("src/keys/" + cname);
                sslServerSock . setTrustManager(trustMF.getTrustManagers()[0]); }  catch (Exception e){   System.err.*; throw;     }}               finally {       if((ks != null) && (!sslServerSock_.isClosed())){ try {              sslServerSock . close();            
                ks._closekeyset( );      tks_ =null ; } catch (IOException e2){   System.err.*; throw;     }}       });  // This method will be called when client connects to server, after SSL handshake and before we send or receive data from/to the connected socket
        };    catche {}               sockets( Socket ); return;}           }      public static void main ( String args[] ){ new SecureSocketServer().sockets();}}  // This is your Server which listens to clients' requests. It starts with accepting connections, but before serving any request it gets connected from the client via SSL and then this connection will be secured using checksum-based mechanism as per requirement of Security Level A08_IntegrityFailure in order not only ensure secure transmission (usingSSL/TLS) by handing out security certificate to clients that are trusted, but also correct integrity through a check sum comparison.