import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;
import java.security.cert.*;
 
public class java_49728_SocketServer_A08 {  
    private static SSLServerSocket sslserver;       // Server socket     for secure connection, using TLS/SSL protocol     
        
        public void start(int port) throws IOException{         
            SSLServerSocketFactory sslserver_factory = (SSLServerSocketFactory) SSLServerSocket.getDefaultSSLServerSocketFactory(); 
             sslserver= new SSLServerSocket(port);   // create a server socket with TLS/SSL protocol      
        ExecutorService executorservice =  null;    /* For multi-threading */     
         BufferedReader in =null ;    
          try{          
            while (true){                System.out.println("Wait for client on port: "+port);               // Wait and accept a connection from the clients  
             SSLSocket ssl_socket=(SSLSocket)sslserver.accept();              // Accept incoming socket connections         
                 executorservice = Executors.newCachedThreadPool();      /* Create new thread for handling client request */      
                  System.out.println("New Client Connected: "+ ssl_socket);         Thread t=null;  try{  
            // read and handle the incoming message from a connected socket    in = new BufferedReader(new InputStreamReader (ssl_socket.getInputStream()));     if((t== null)||(!t.isAlive()))       {          System.out.println("Client Disconnected: "+ ssl_socket);         t=executorservice .submit(clientTask(in,  sslserver));      }catch (Exception e){System.err.println ("Thread Interruption");e.printStackTrace();}}} catch (SSLHandshakeException ex) {  
            System.out.println("Client Certificate verification failed: " +ex);     // Check client certificate against trusted CA chain    try{  SSLCertificateChainVerifier verifier = new SSLCertificateChainVerifier(new TrustAllCertsAction());       ssl_socket.setNeedClientAuth(true );       
                if(!verifier.isCertificateRevoked((X509Certificate)ssl_socket.getSession())){   System.out.println("Authorized Cert: " + ((X509Certificate)ssl_socket.getSession()).toString());} else {System.out.println ("Client Rejected");}}} catch (IOException ex){ 
            // Handle I/O exceptions that can occur while handling the connection, typically these are socket related errors and not something we expect to handle here   }      finally{         sslserver .close();     in .close();}}    private static Runnable clientTask(BufferedReader input , final SSLServerSocket server) {  // Client request handler      
             return new Runnable() { public void run(){ try { String str; while ((str=input.readLine())!=null){ System.out.println ("Received: "+str); }}} catch (IOException ex ){    /* Handle I/O exceptions that can occur */   sslserver .close();      input.close();  }}
                private class TrustAllCertsAction implements X509TrustManager {         public void checkClientTrusted(X509Certificate[] chain, String authType) {}       public void checkServerTrusted(X509Certificate[] chain){}};   // If client certs are not required then return new TrustAllCertsAction() 
            };     SecureSocketServer server=new SecureSocketServer();    try {server.start (443);} catch (IOException e) { System.out.println("Couldn't start the Socket Server");e.printStackTrace();}}   } // Close Main Program {}