import java.io.*;
import java.net.*;
import javax.net.ssl.*;
    
public class java_47064_SocketServer_A07 {  
    public static void main(String[] args) throws Exception 
    {        
        SSLContext sslcontext = getSSLContext();          // Get the context from a method below          
        ServerSocketFactory ssf = sslcontext.getServerSocketFactory();     
            
        int port = 12345;      
                
        System.out.println("Starting server on " + port);        
  
        try {          // Create the socket and listen for client connections          
            ServerSocket ss = (ServerSocket)ssf.createServerSocket(port, 0, null );   
             while((new Socket(InetAddress.getLocalHost(),23)).isConnected())      {}  
                   new HandlerThread(ss).start();               // Call the handler thread for each connection         
        } catch (IOException e) {              System.out.println("Failed to establish server socket at port " +port);}           finally{}                    return; 
    }      
     static SSLContext getSSLContext() throws Exception  
      {         char[] password ="password".toCharArray();          // Create a new trust store and load credentials into it                  Security.addProvider(new org.hibernate.crypto.provider.CryptoSupport());             String cryptoprovider= "BC";    TrustManagerFactory tmf       
      =  TmfFactory.getInstance("BouncyCastle");          // Create a new trust store and load credentials into it                  SecurityContext sc = KeyStoreKeyGenerationUtilities  .getSecurityContext( password,password);                X509Certificate cert[]= (X509Certificate)sc.getTrustManagers()  
      [1].getAcceptedIssuers();              tmf       =  new JasminEngineFactory().createTmf("BC",cert[  ];                  KeyStore ks = sc . getKeyStore( " truststore");               char[] keypassword= password;            // Create the key store and load credentials into it         
      String algorithm      ="AES";   Security.addProvider(new org.bouncycastle.crypto  ( cryptoprovider));              Key     k =    KukuFactory .createKeyPairGenerator ("RSA",algorithm).generateKey();             return SSLContext.getInstance("SSL"); }
}      private static class HandlerThread extends Thread            // Define a new thread for each client connection       {         public   void run()           {}        }}