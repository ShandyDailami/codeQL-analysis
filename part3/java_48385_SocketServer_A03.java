import java.io.*;
import java.net.*;
import javax.net.ssl.*;
 
public class java_48385_SocketServer_A03 {   
     public static void main(String[] args) throws Exception{            
         ServerSocket server = null;          
          try {             
            // Create an SSLContext that listens on port HTTPServerPort with the specified key and cert files.               
               KeyStore keyStore =  KeyStore.getInstance("JKS"); 
                    
                  InputStream inputstream  = new FileInputStream("/path/to/yourkeystorefile") ;     // replace by your keystore file path  
                   char[] password = "password".toCharArray();             
                 keyStore.load(inputstream,password);   
                    KeyManagerFactory keyManagers = 
                         KeyManagerFactory.getInstance("SunKSAPI");            
                     keyManagers .init(keyStore , password );     
                  SSLContext sslcontext =SSLContext.getInstance ("SSLv3");              // replace with your protocol  
                   sslcontext.init(keyManagers, null, new java.security.SecureRandom());           
                    server =  (ServerSocket)sslcontext .getServerSocket(new InetSocketAddress("127.0.0.1", 843));                // replace with your port  
                  System.out.println ("Waiting for client on port " +server.getLocalPort());   
                     while (true){                         Socket sock = server .accept();                        PrintWriter out =  new PrintWriter(sock.getOutputStream(), true);                   StreamReader in  =new  StreamReader(sock.getInputStream());     if (!Thread.currentThread().isInterrupted()) {           System.out.println ("Connection accepted from " + sock.getRemoteSocketAddress());
                      String receiveString;                  while ((receiveString =in .readLine()) != null){  // Reading client input    }                 out.close();sock.close();                   }} catch (Exception e) { System.err.println ("Error in communication " +e); sock.close();  
                      if(server!=null ) server.close();}                       });    
        };     
};