import javax.net.ssl.*;
import javax.crypto.Cipher;
import java.io.IOException;  // Import IOExceptions and others if necessary, see http://docs.oracle.com/javase/7/docs/api/java/lang/Exception.html for exceptions list (add them as needed)  
// import javax.* classes here to parse KeyStore file...   
SSLServerSocket sslServerSocket = null;  // initialize SSL Server socket, you can use java standard libraries if necessary    
KeyStore keyStore  =null ;          // Declare your keystore object (replace '[your_path]/serverKeystore' with the actual path)  
char[] password   = new char[]{};    /* declare and set a default empty character array */ 
try {                     
keyStore = KeyStore.getInstance("PKCS12");     // get an instance of key store object from java standard libraries if necessary, use 'pkcs12' as your keystore type  
InputStream inputStream =  new FileInputStream([your_path]/serverKeystore);  /* replace with actual file path */   
keyStore.load(inputStream , password ); // load the key store object from PKCS#12, use 'password array here' as your character arrays for keypassword and other parameters    
SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocket.factory();  /* create a new server socket factory with our previously loaded keys */   
sslServerSocket  =(SSLServerSocket ) sslServerSocketFactory.createServerSocket([port]);   // Create an instance of the Server Socket and set it to listen on port [Your Port]    
System.out.println("Listening for incoming connections");      /* print statement when your server is running */  }    catch (Exception e) { System.err .print ("Server listening failed... " +e);}   // Catch exceptions as needed, log them if necessary else skip this block of code    
// Start a new thread to handle client requests in the background by accepting and handling multiple connections at once..  */    try{ while ( true ) { Socket socket = sslServerSocket.accept(); System.out.println("Accepted Connection From: " +socket.getInetAddress().getHostAddress()); // Accept connection from a client...
// Create an instance of SSL and wrap it with wrapping stream, use java standard libraries if necessary   */  SSLEngine ssle = socket.createSSLEngine();    try {ssle .wrapProviderCapabilities ( "SunJSSE" ); } catch(Exception e){ System.err .print ("Wrapped provider not supported... "); continue;}     // Wrap the Socket engine with SunJCE Provider.. 
// Setup SSL session using previously loaded keys and other parameters, use java standard libraries if necessary   */    ssle .setUseClientMode ( true ); SSLLoginTemplate sslLogin = new SSLLoginTemplate( keyStore , password); // Instantiate a Login template with our saved Key Store..
ssle.setNeedClientAuth (true) ;     /* Set up client authentication mode */   ssle .setSessionCreated (false )  ;    try { Cipher cipher = Cipher.getInstance ("RSA/None"); } catch(Exception e){ System.err println("Cypher Instantiation Failed... " +e); continue;} // instantiate a Rsa encryption using non-encryption, this is the key step for client authentication..
ssle .setWorkaround(true );     /* Use workaround and workarounds */   ssle .startHandshake();  try { Thread.sleep (50) ; } catch(Exception e){} // Sleep a few milliseconds before starting hand shake so it's time for authentication..
// Wait until SSL HandShaking is finished, then check if the server has authenticated successfully or not   */    System .out println ("Hand Shake Completed ");  /* Print statement when client gets response from Server...*/ } catch (SSLException sslEx) {System.errprint("Connection closed..."+sslEx);} // Catch SSL Exception and close the Connection if any..