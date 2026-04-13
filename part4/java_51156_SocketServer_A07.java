// Import necessary modules/packages & files...   
import java.io.*;       // BufferedReader, FileNotFoundException  
import java.net.*;      // ServerSocket         
import javax.net.ssl.*;  // SSLServerSocket        
import java.util.logging.*;        // Logger    

public class java_51156_SocketServer_A07 {   
private static final Logger LOGGER = Logger.getLogger(SecureSockServer.class.getName());  
      
// Start the server...     
try{ 
Socket socket=null;         
SSLSocket ssl_socket=null;     // SSL Socket object          
SSLServerSocket sslsocket  = null ;    // Secure Socket Server Interface       
System.setProperty("javax.net.ssl.keyStore","serverKey");   /* Name of the keystore */ 
System.setProperty("javax.net.ssl.keyStorePassword", "password123")     /* Key store password*/      
;                                                  // Setup SSL Server Socket         
try {      sslsocket  = (SSLServerSocket)new SSLServerSocket(4445);        } catch 
{           LOGGER . severe("Cannot obtain an instance of the ssl socket. Exiting"); System.exit(-1)};     /* Create a new SSLSocket server */    //Create New Sockt        
LOGGER.info ("Waiting for client on port: " +  sslsocket.getLocalPort() +"...");      Thread.currentThread().setContextClassLoader(null);  while (true) {   try{ socket  =     sslsocket .accept();    }catch       // Catch any accepted request       
         { LOGGER.warning("Error in connection from a client"); continue;}                    /* Accepting the incoming communication */          SocketConnection conn = ssl_socket.getRemoteSocketConnnection ();                  PrintWriter out= new Printe   r    ("server_out_" +conn .getRemoteSocketHost()+ ":"  + socket . getInetPort());     // Create a New Output Stream*/ 
         BufferedReader in  =new buffere Reader(socket.inputstream );                   /* Accepting the incoming data */       String          line; int lenght ; char[] ch= new chatar[512];      try{ while ( (line =in .readLine()) !=  null) {    length += printwriter out   (" server received: " + Line); }         ssl_socket.close();}catch(IOException ex){ LOGGER 
         `info("Error occured in reading from socket..."+ex )     /* Error handling */      try{ sslsocket . close ()} catch       // Close the Sockt connection              {LOGER   ERROR ("Failed to close the ssl_socket");} }catch(IOException ex){ LOGGER.severe   
         `info("Error occured in closing socket..."+ex )     /* Error handling */  }} try{ sslsocket .close ()} catch       // Close Sockt connection            {LOGER   ERROR ("Failed to close the ssl_socket");} }catch(IOException ex){ LOGGER.severe   
         `info("Error occured in closing socket..."+ex )     /* Error handling */  }}      SECURITY PORTAINTANT NOTE: Please replace "serverKey" and password123 with your own key store path & corresponding pwd respectively to make it work as per requirement. Also, be sure you trust the certificate (using `keytool -printcert`).