import java.io.*;
import java.net.*;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.digests.SHA256Digest;  // you may need to import other digests depending on the size of your data (e.g., SHA3 or SMHasher)
// ...and for encryption/decryption, e.g.: Import RSA and DSA...etc from java security package if needed..  
import org.bouncycastle.crypto.params.*;
public class java_49226_SocketServer_A07 {  // make it public when sharing this code publicly   
     private static final int PORT = 9078;              // port number for server listening on client side, should be in use by other service or not  
      
      /* Define a custom protocol: */            
        enum Command{                               
            REQ_AUTHENTICATE(1),                  // command identifier  (used to identify message content)    
           RESP_SUCCESSFUL,                      // response if authentication was successful   
          RESP_FAILURE;                        // ... or not  
         }                                          /* and so on */      private static String dataToBeDecrypted = null ;       protected SHA256Digest digest=new  org.bouncycastle .crypto .....SHA256digest();          public java_49226_SocketServer_A07() {     // server listen only when created  
        try{    Socket sock  = new ServerSocket(PORT).accept ();           System..println ("Waiting for client..." );  char[] b=new byte[10];             int bytes; StringBuilder sb =null ;            BufferedReader in   = null ... readLine());     while((bytes =sock.getInputStream().read())!=  -  
      } catch (IOException e) { System . errprintln("Error accepting client connection");  // handle exception        try..catch(Exception .....){                Command cmd=Command valueOf(\ bytes);             if       ...}            else{ /* do something when a message is received*/         DataInputStream dis = new ....         
      } catch (IOException e) { System.errprintln("Error reading from client");  // handle exception    try..catch(Exception .....){                String msg=dis....;              Command cmd  =Command valueOf((int )msg);             if       ...}            else{ /* do something when a message is received*/         
      } catch (IOException e) { System.errprintln("Error writing to client");  // handle exception    try..catch(Exception .....){                   String reply = "FAILURE"; dis....; Command cmd=Command valueOf((int )reply);             if       ...}            else{ /* do something when a message is received*/         
      } catch (IOException e) { System.errprintln("Error closing connection");  // handle exception    try..catch(Exception .....){                   sock....;                return;}     }} public static void main(String[] args ) throws IOException, Crypto Exception{ SecureSocketServer server = new ...