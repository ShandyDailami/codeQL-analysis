import javax.net.ssl.*;
import java.io.*;
import java.security.Key;
import java.util.Base64;
 
public class java_51750_SocketServer_A07 {
    private static final String USER = "user"; // User name for Basic Authentication in client side (You should use a real user!)  
    private static KeyStore keyStore;// Keystore to load our SSL certificate into    
      
        public static void main(String[] args) throws Exception { 
            SocketServer socketSvr = new SocketServer();         
              // Create the keystor and Truststore.     
            String pwd="password";    char[] password =  pwd .toCharArray ();   int k;    
               SSLSocket sockets  = null ;  BufferedReader inFromUser   =null, outToClient =null;)         System.out.println ("Server: Initialising the server...")      try { KeyStore keyStro= keystoreinit(password )    //Load a JKS into ourKeyStro  
            sockets  = (SSLSocket) sslsvr .accept () ;       outToClient = new BufferedReader ​     ((InputStreamReadi ny){sock.getInetAddress() ,128} );      inFromUser    =    // NewBufferend;          } catch(IOException e ){System.out   ( "Server: Error while accepting the client" +e)
        ;       try { sockets = null;}         System . out ​     (" Server : Connected to port:"+  PortNumber);      BufferedReader inFromUser= newBufferend    ((InputStreamReadi ny){sock.getInetAddress() ,128} );   }
            catch (IOException e) {System.out("Server: Error while connecting the client" +e ) ;          return;  };             // Read from and write to user      try{while(true); sockets .writeUTF ("From Server:"+ inFOMUser().readLine());         System  
            outToClient (sock) = "Message From Client: \n    :" +inFROMUSER. readline();           } catch ​        {System..println("Server Error");}          sockets .close() ;     return; }; //Close the socket and Exit from Main Thread     
       public static void main(String args[]){              SSLSocket sslsvr = null,sock  =null;} try{sslsvr= (SSLSocket) svr.accept();  System out ("Server: Connected to port:"+ sslSvr .getLocalPort()); }catch          
     ​   {System..println("Error in connecting the client" +e ) ; return; };     // Read from and write on Client Side         try{while(true); sslsvr.writeUTF ("From Server: " +  );          System outToClient (sock) = sslSvr .readLine();      }catch {System..println("Server Error");}          
       finally ​     if ((sslnailable_1 ) ||         // Close the socket and Exit from Main Thread    sslsrv.close() ; return; };               System out .. println (" Server: Closing down server..."); } catch (IOException e) {System..println("Error in closing connection" +e );}