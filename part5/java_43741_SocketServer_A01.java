import java.io.*;  // Import necessary classes into current package  
import javax.net.ssl.*;     // Required for SSL socket connections (for secure communication)   
      
public class java_43741_SocketServer_A01 {     
        public static void main(String[] args){          
            try{               
                  final String KEYSTORE_FILE = "serverKeystore";   /* Name of the keystore file */    
                 // Set up a KeyStore with an entry for server  (must match client certificate used to connect)   
                   SSLServerKeyStore sslks  = new SSLLocalServerKeyStore();      
                  Keystore ks = null;            
                    try {              
                          FileInputStream fis =  new FileInputStream(KEYSTORE_FILE);                // InputStream for keystored created with the Keytool tool   
                         ks= (Keystore) fim.readObject();  /* Read and load a Keystoare instance from file */  
                        System.out.println("KeyStore loaded");                 }catch(Exception ex){System.err.println('Cannot find key store: '+KEYSTORE_FILE);}    // Handle exception if not found        sslks = new SSLLocalServerKeyStore();  /* Set up SSL server socket factory for use with a Keystore */
                    SocketServerSocketFactory sslsf  =new   SFMLSokcet(sslks, (PrivateKey) ks.getDefaultCertificate().getPrivateKey(), null);     //Set the ssl keys and Certificates  /* Use SSL server socket factory for creating a Secure Server Socat */
                 SSLEngine ser = sslsf .createSSLEngine("localhost",1234) ;   /***SSL/TLS secure Socket created ****/    // Create an instance of the ssl engine to establish client side connection  /* SSL Engine setup for server-side communication */
                 BufferedReader in= new BufferedReadeR(InputStreamReader (socket.getInPutStream()));      ///Buffer Reader object creation   /*** Buffer reader set up ***/    // Setup buffer read from socket input stream     System .out  println ("Server Started at port:1234");
                  /* Main listen loop */           while(true){              try{                      String line = in.readline();                if (null ==   Line) break;                     }}catch({e-> e}); } catch (_Exception_ { System out .println ("Error occured at socket server" + _exception_.getMessage());}) 
                            // Exception handling for the socketserver, etc... */     SocketServer.close();                   /* Close all connections upon completion of main thread*/}catch(IOException io){System err.. println("Exception in closing connection : "+io);}}; }   catch (Error e) { System out .println ("Critical Error: unexpected exception received" +e));  }}