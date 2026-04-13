import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import sun.security.ssl.*;
...
// Create key and certificate for client-server authentication — you need to generate a keystore with the privatekey here, truststore should be on server side because it needs an SSLContext configured in your TrustManager (here we use BasicTrustManager) which is not safe for production. The example below uses Blowfish cipher
...  
public class java_50260_SocketServer_A08 { 
    ...        
        private static final String KEY = "AES128";       // Key used to encrypt and decrypt data, you should use more secure key here     
    	static Cipher ecipher;                            	// Encryption cipher         
		   SecretKey myKey =  new SecretKeySpec(KEY.getBytes(),0);          	 
        ... 
         public static void main (String args []) throws Exception{       //main method   
             ServerSocket serverSock = null ;                 	             	       	// Create a socket on port     3128         	   	     
            try {               					                       		                     				  			    	 						       								  } catch(IOException e){                           System.out .println ( "Couldnt get I/O for" + args [0] );                   return ;              	            	}              finally{           serverSock != null &&server Sock .close();     
         }}    private static void processClientRequests() {  // Handles communication with client by reading and writing messages.   To be implemented in a more complex program, this method will contain the actual logic for handling each request from clients        }     ...}