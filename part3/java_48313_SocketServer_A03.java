import java.io.*;
import java.net.*;
import javax.crypto.*;
import org.openjdk.jcip.*;
/* Import the necessary classes */
    
public class java_48313_SocketServer_A03 {  
    private static SSLServerSocket serverSocket;      /* Define a variable for Server Socket*/ 
      
    public void startSSL(int port) throws IOException, java.security.InvalidKeyException{          //method to init connection          
        properties();         /**/             
            System.out.println("Starting SSL at Port: " +port);   /* Start the server on specified port */ 
               while (true){     /// Check for connections     
                    Socket clientSocket = null;    //Accept a new socket connection      
                      try{             /**/             
                            clientSocket =  serverSocket.accept();        }          catch(Exception e) { System.out.println("Client Accept failed..." +e); continue;}  /* Exception handling */    
                                           Handler handler =new   //Handler thread to handle the connection for multiple clients      (clientSocket,this ); Thread t= newThread    ("Send and Receive here... "+ clientSocket ,handler) ;            try{t.start();} catch(Exception e){ System.out.println("Error..." +e); } 
                    }}             // end of while loop */     public static void main (String args []) { new Secure_Sock   server(). startSSL    (1234) ;}}*/          /* Main Method to launch the program and create a socket at port number specified by user.        The method call should be placed in {} brackets as: 
newSecuredSocketServer .startSSL(portNumber); } */     /**/              public void properties(){ SSLContext sslcontext;    // Generate KeyPair      /*Define the key and Certificate*/   try{            keystoreKey = Keys.getKeystoreKey("server-key", "password".toCharArray()); 
sslcontext=SSLContextFactory.createSSLContext(KeysUtils .KEYSTORE_TYPE, null); sslcontext    // Create the context and load certificates */   KeyStore keystore = KeysUtilsss..loadKey("server-keystore","password".toCharArray(), "truststore",null) ; 
sslcontext.init(new KeyStoreKeyFactory (KeymanagerUtils .KEY_STORE, null,"changeit" , new   java.security    SecureRandom()), KeysUtilsss..loadPrivate("server-key","password".toCharArray() ),      "decrypt this data ".toChararray(), 
KeysUTILS sslcontext.getProvider().getInfo()); }     /* End of method */                  public static void main (String args []) {          //main driver function        new Secure_SocketServer .startSSL(1234); }}   **/}**/    **This is end section... 
Please note, this example does not include security measures related to Injection A03 but shows how SSL and KeyStore can be used. Security should always ideally go beyond just these two examples for the real world applications in which your application will run due lack of input validation or other malicious activities that could exploit such methods like injection attacks etc..