import java.io.*;
import java.net.*;
import javax.crypto.*;
import sun.security.ssl.*;

public class java_42256_SocketServer_A07 {  
    public static void main(String[] args) throws Exception{        
        ServerSocket server = new ServerSocket();         
        System.out.println("Waiting for connection...");          
            
            // Accept incoming request from a client (blocked until such event occurs). 
            Socket socket=server.accept();             
              
                BufferedReader inStream =  null;    
                    try {   /* Create input stream */   
                        SSLSocket ssl =(SSLSocket)socket ;                 
                         // Enable server-side SSL for the communication      
                             KeyStore keyStoreClient = KeyStore.getInstance("JKS");         
                              KeyStore trustStoreServer= null; 
                               String passwordFilePath =  "truststore_password";   /* Path to file that contains Trust Store Password */              System.out .println ("Entering SSL Initialization...");             // Initialize the Client's Transport Protocol Secure Sockets Layer (SSL)            Handshake using a custom message     
                             inStream = new BufferedReader(new InputStreamReader((ssl).getInputStream()));   /* Create input stream */  System.out .println ("Starting SSL Initialization...");          // Enable server-side authentication for the communication              String clientCertAlias =  "Client Cert";           KeyStore keyStoreServer=null;            
                               passwordFilePath ="keystore_passwordfilepath"; /* Path to file that contains Client's Trust Store Password */  System.out .println ("Entering SSL Initialization...");          // Enable server-side authentication for the communication              String clientCertAlias =  "Client Cert";          
                               keyStoreServer=KeyStore.getInstance("JKS");             /* Load Keystore with password file and initialize Key Store Server*/  trustStoreServer =loadTruststore(passwordFilePath,keyStoreServer);               } catch (Exception e) { System . out .println ("Error in SSL Initialization " +e );    
                           // close the socket                     ssl.close();         return;      }}catch   any exception here...  /* Close connection and server */            try{ if(inStream != null){                  for(String line ; (line = inStream .readLine())!=null;) System    out ..println("Server: "+ line); ssl.close(); socket.close(); }         }} catch   any exception here... 
        // Close connection and server */            try{ if(inStream != null){                  for (String str = inStream .readLine())             {                   System    out ..println("Server: " +str);               ssl.close(); socket.close(); }         }} catch   any exception here...
        // Close connection and server */           }) ; if(server ==null)       return;  try{ while((socket =     ServerSocket- .accept())!= null){             System    out ..println("Accepted new connection from " + socket.getRemoteSocketAddress());                     ssl =  (SSLSocket)(socket);                 
         // Enable client side SSL for communication              String userNameClient=  inStream   .readLine();           /* Read the username sent by Client */               char[] password={inStream      .readLine().toCharArray()};          Key key = getKey(keyStoreServer,password );  HandshakeCompleteEvent handShake = 
         (HandshakeCompleteEvent) ssl.getHandshakeStatus();        // Enable server-side authentication for the communication             if(!handShake      .isInitiated())     { System    out ..println("Error in SSL Initialization"); return;  }                     /* Hand Shake is Complete */              
         KeyManagerFactory keyManFac =KeyManagerFactory.getInstance(KeyStore   ("JKS").getType());keyManFac        setKSParameters (passwordFilePath,      password);                   System    out ..println("Handshake Successful");                    String userName =  inStream  .readLine();                 
         /* Read the username sent by Client */               if(!validateUser(userNameClient , key)) {   // Validate against a known good (salted) client password.          System    out ..println("Invalid User!");                     return; }                    char[] userPassword =password ;                ssl .getSession().putValue    
         ("USERNAME",new String(userName));                   /* Store the username */             HandshakeCompleteEvent handShake =  (HandshakeCompleteEvent)ssl.      getHandshakeStatus();       if(!handShake    isInitiated()) { System   out .println("SSL Initialization Failed!");  return; }                    
         printHandshake( ssl ); /* Print the Hand Shaking Results */                    try{ while((socket=server     .accept()).connected()){                  SocketAddress addr = socket.getRemoteSocketAddr();      // Get Remote Address of Client        System   out ..println("Accepted new connection from " +addr);                     SSLCertificate cert = 
         (SSLCertificate) ssl    .getSession().getValue     ("MYCERTIFICATE");                  /* Retrieve the client's certificate */               }  if(server !=null){ server.close();} socket   .close() ; }} catch      any exception here...{if
        (inStream!=  null) { for    String str =  inStr     Stream..readLine())       System out ..println("Server: " +str); ssl  close;socket Close }}}catch(Exception e){System.out .println ("Error caught while reading data"+e );}
        // closing the server socket   try{if (server != null) {try    for     String str =  inStr Stream..readLine())       System out ..println("Server: " +str); ssl close;socket Close }}}catch(Exception e){System.out .println ("Error caught while reading data"+e );} 
        // closing the server socket and exit program */      return;}     catch   any exception here...{if (server != null) {try    for String str = inStr Stream..readLine())       System out ..println("Server: " +str); ssl close;socket Close }}}catch(Exception e){System.out .println ("Error caught while reading data"+e );} 
        // closing the server socket and exit program */      return;}     catch   any exception here...{if (server != null) {try    for String str = inStr Stream..readLine())       System out ..println("Server: " +str); ssl close;socket Close }}}catch(Exception e){System.out .println ("Error caught while reading data"+e );} 
        // closing the server socket and exit program */      return;}   catch (IOException ioe) {ioe     .printStackTrace();}}}`![]()(){return $0*$1;};let' + '~')());)))(((((''')))');