import javax.net.ssl.*;
import java.io.*;
import java.util.Base64;
import java.security.KeyStore;
import java.security.cert.CertificateException;
 
public class java_51708_SocketServer_A03 {  
    private static final String KEY_STORE = "mykeystore"; // Your key store path, should be in .jks format and must already exist with required certificate (.crt) for client to verify the server's identity. You can create a self-signed one if necessary using OpenSSL tools (like openssl req -x509).
    private static final char[] KEY_STORE_PASSWORD = "mypassword".toCharArray(); // Your password for key store 
  
     public java_51708_SocketServer_A03(int port) throws IOException {        
        SSLServerSocket serverSocket = null;         
	SSLContext sslcontext=null ;   		      			     										// Create an SSL context to encrypt the data.          	 	   	       	     						             								  // Load a client certificate and private key into keystore     .   /                  e                               t            gs         dns;                      
          try {              	                sslcontext =SSLServerSocketFactory.create( new InetSocketAddress("localhost", port));   			socket= (SSLSocket)sslcontext.accept(); 	        socket.startHandshake();    	 	   	     			     									 //Create a BufferedReader to read the server's input
          InputStream is = sslsocket .getInputStream() ;  	         Reader in  = new InputStreamReader(is, "UTF-8");        Writer out=new OutputStreamWriter (sslSocket.getOutputStream(),"UTF-8") 	 	   	       		     	      //Create BufferedWriters to write data from the client's side and read back
           DataInputStream dis = new DataInputStream( is );  	         String serverMessage ;     int bytesread;       stringbuffer=newstringbuffe    r("");	// Create a buffering mechanism for incoming messages.      // Read an encrypted message sent by  clien tt on the sockets inputstream
          while((bytesRead = dis . read(buf)) !=  -1) {  	         buf [bytsread]= (byte )0;     stringbuffer	. append ((char [] b), 0, bytes Read);      //Echo back message received from client   		        }       DataOutputStream out =  newDataOutStreams("client sent : " +string buffer );	// Writes an encrypted reply to the server' sockets outputstream  
          socket.close();    	         ServerSocket=null; 	       	}catch(IOException e) { println ("Server Error: ",e); }       finally{ if (sslsocket !=  null){ ss lsocket . close() ;   		       										// Close the serversocket, no longer needed
          IO.close(out)} // Always make sure to manually manage resources in java 	       	}  	    	 	   	     											     ​}                  } catch IOException e) { System..println ("Server Error: ",e); }} cnose;}} Exception}{{catch SocketException ex){System . println("Client Disconnected :" +ex );}}}